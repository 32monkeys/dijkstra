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
    public Vertex getVertex(String s)
    {
        for(Vertex v : vertices)
        {
            if (v.name ==s)
                return v;
        }
        return null;
    }

    public void newEdge(Vertex from, Vertex to, int dist, int time) {
        Edge newEdge = new Edge(from,to);
        newEdge.distance=dist;
        newEdge.time=time;
    }

    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex source, Vertex zink)
    {
        Map<Vertex,Vertex> predecessorMap= new HashMap<>();
        Map<Vertex,Integer> distanceMap=new HashMap<>();
        // initialize arrays
        for(Vertex v: vertices)
        {
            distanceMap.put(v,1000);
            predecessorMap.put(v, null);
        }

        System.out.println(vertices.get(1).getOutEdges());
        distanceMap.put(source,0);
        Map<Vertex,Integer> qMap = new HashMap<>();
        Vertex current = source;

        for (Edge edge : current.getOutEdges()){
            qMap.put(edge.getToVertex(),edge.distance);
            System.out.println("From: "+current.name+" to: "+ edge.getToVertex().name +" distance = "+ edge.distance);
        }
        //System.out.println(getMin(qMap).name);
        current = getMin(qMap);






        //implement Dijkstra



        return (new Pair<Integer,Map<Vertex,Vertex>> (distanceMap.get(zink), predecessorMap));
    }
    public Vertex getMin(Map<Vertex,Integer> qMap){
        // Your code
        Vertex minEntry = null;
        int shortestDist = 200;
        for (Integer dist : qMap.values()){
            if(dist < shortestDist){
                shortestDist = dist;
            }
        }
        for (Vertex vertex : qMap.keySet()){
            if (qMap.get(vertex).intValue()==shortestDist){
                minEntry = vertex;
            }
        }
        return minEntry;
    }
}



class Vertex{
    public String name;
    public ArrayList<Edge> outEdges = new ArrayList<>();
    public  Vertex(String id){
        name =id;
    }
    public void addOutEdge(Edge outEdge){
        outEdges.add(outEdge);
    }
    public ArrayList<Edge> getOutEdges(){return outEdges;}
}

class Edge{
    private Vertex fromVertex;
    private Vertex toVertex;
    public int distance=0;
    public int time=0;

    public Vertex getToVertex() {
        return toVertex;
    }

    public Edge(Vertex from, Vertex to){
        fromVertex =from;
        toVertex=to;
        fromVertex.addOutEdge(this);
        //If not directional
        toVertex.addOutEdge(this);
    }
}