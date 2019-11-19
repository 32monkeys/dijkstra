package dijkstra;

import java.util.*;
import javafx.util.Pair;

public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<>();

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        vertices.add(v);
    }
    public Vertex getvertex(String s)
    {
        for(Vertex v : vertices )
        {
            if (v.Name==s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge=new Edge(from,to);
        newedge.distance=dist;
        newedge.time=tim;
    }

    /////////////////////////////////////
    // TODO: implement a global variable for the infinity
    int FUCKING_HIGH_NUMBER = (int)Double.POSITIVE_INFINITY;
    int infinity = FUCKING_HIGH_NUMBER;

    /////////////////////////////////////

    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex source, Vertex zink)
    {
        Map<Vertex,Vertex> predecessorMap= new HashMap<>();
        Map<Vertex,Integer> distanceMap=new HashMap<>();
        // initialize arrays
        for(Vertex vertex: vertices) {
            distanceMap.put(vertex,infinity); // This is the nodes and their weight
            predecessorMap.put(vertex, null); // This is the nodes and their reference to last vertex
        }

        // TODO: We implements the dijkstra
        /////////////////////////////implement Dijkstra /////////////////////////////
        Vertex current = vertices.get(0);
        Vertex next = current;
        while(next!=null&&current!=zink) {
            System.out.println("For: " + current.Name + " {");

            int currentMin = infinity;
            Vertex tempVertex = current;

            for (Edge startOfEdge : current.getOutEdges()) {
                if (!current.equals(startOfEdge.getTovertex())) {
                    System.out.print("\t From: " + current.Name + " ");
                    System.out.print("\t To: " + startOfEdge.getTovertex().Name + ". ");
                    System.out.print("\t Distance: " + startOfEdge.distance);
                    System.out.println(); // Print where we start

                    if (startOfEdge.distance <= currentMin) {
                        currentMin = startOfEdge.distance;
                        next = startOfEdge.getTovertex();
                    }

                }
            }

            System.out.println("\t Minimum is: " + currentMin + " So we select: " + next.Name);
            System.out.println("}");
            System.out.println();

            // Now we have evaluated the shortest of the available paths
            // We will now set the current to the next
            current = next;

        }
        //for(Vertex vertex : vertices){
            //System.out.println(vertex.getOutEdges());
            //if(vertex.getOutEdges())
            //predecessorMap.put(source,vertex);
        //}
        /////////////////////////////////////////////////////////////////////////////////
        System.exit(0);
        return null;
        //return (new Pair<Integer,Map<Vertex,Vertex>> (DistanceMap.get(zink), PredecessorMap));
    }
    public Vertex getmin(Map<Vertex,Integer> qmap){
        // Your code
        return null;
    }
}



class Vertex{
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        Name=id;
    }
    public void addOutEdge(Edge outedge){
        OutEdges.add(outedge);
    }
    public ArrayList<Edge> getOutEdges(){return OutEdges;}
}

class Edge{
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance=0;
    public int time=0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to){
        fromvertex=from;
        tovertex=to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }
}