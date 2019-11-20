package dijkstra;

import java.security.Key;
import java.util.*;

import javafx.util.Pair;

public class Graph<T> {
    private ArrayList<Vertex> vertices = new ArrayList<>();

    public Vertex addVertex(String id) {
        Vertex newVertex = new Vertex(id);
        vertices.add(newVertex);
        return newVertex;
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public Vertex getVertex(String s) {
        for (Vertex v : vertices) {
            if (v.name == s)
                return v;
        }
        return null;
    }

    public void newEdge(Vertex from, Vertex to, int dist, int time) {
        Edge newEdge = new Edge(from, to);
        newEdge.distance = dist;
        newEdge.time = time;
    }

    public Pair<Integer, Map<Vertex, Vertex>> ShortestDistance(Vertex source, Vertex zink) {
        /*
        init lists distmap predecessor and handled?
        distmap for entry source = 0
        for all vertex in graph
        current = find min(distmap, handled)
         */
        Map<Vertex, Vertex> predecessorMap = new HashMap<>();
        Map<Vertex, Integer> distanceMap = new HashMap<>();
        Map<Vertex, Integer> handled = new HashMap<>();
        // initialize arrays
        for (Vertex v : vertices) {
            distanceMap.put(v, 1000);
            predecessorMap.put(v, null);
            handled.put(v, -1);
        }
        distanceMap.put(source, 0);
        Vertex current;

        for (Vertex vertex : vertices) {
            current = getMin(distanceMap, handled);
            //System.out.println("eval: " + current.name);
            for (Edge edge : current.getOutEdges()) {
                if (distanceMap.get(current) + edge.distance < distanceMap.get(edge.getToVertex()) && handled.get(current)<1) {
                    if (edge.getToVertex() != current) {
                        System.out.println("we at " + vertex.name + " current: " + current.name + " going to: " + edge.getToVertex().name);
                        distanceMap.put(edge.getToVertex(), distanceMap.get(current) + edge.distance);
                        System.out.println("we set " + edge.getToVertex().name + " to " + (distanceMap.get(current) + edge.distance));
                        predecessorMap.put(edge.getToVertex(), current);
                        handled.put(current, 0);
                    }
                }
            }
            handled.put(current, 1);
        }

        //for (Edge edge : current.getOutEdges()){
        //    qMap.put(edge.getToVertex(),edge.distance);
        //    System.out.println("From: "+current.name+" to: "+ edge.getToVertex().name +" distance = "+ edge.distance);
        //}
        //System.out.println(getMin(qMap).name);


        //implement Dijkstra


        return (new Pair<Integer, Map<Vertex, Vertex>>(distanceMap.get(zink), predecessorMap));
    }

    public Vertex getMin(Map<Vertex, Integer> qMap, Map<Vertex, Integer> done) {
        // Your code
        /*
        for each vertex dist
         */
        int tempMin = 10000;
        Vertex result = null;
        for (Vertex vertex : qMap.keySet()) {
            if (qMap.get(vertex).intValue() < tempMin && done.get(vertex).intValue()<1) {
                tempMin = qMap.get(vertex).intValue();
                result = vertex;
                done.put(vertex,0);
                //System.out.println("temp result: "+result.name + qMap.get(vertex).intValue()+" "+tempMin);
            }
        }
        return result;
    }
}

class Vertex {
    public String name;
    public ArrayList<Edge> outEdges = new ArrayList<>();

    public Vertex(String id) {
        name = id;
    }

    public void addOutEdge(Edge outEdge) {
        outEdges.add(outEdge);
    }

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }
}

class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;
    public int distance = 0;
    public int time = 0;

    public Vertex getToVertex() {
        return toVertex;
    }

    public Edge(Vertex from, Vertex to) {
        fromVertex = from;
        toVertex = to;
        fromVertex.addOutEdge(this);
        //If not directional
        toVertex.addOutEdge(this);
    }
}