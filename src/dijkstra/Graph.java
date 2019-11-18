package dijkstra;

import java.util.*;
import javafx.util.Pair;

public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }
    public Vertex getvertex(String s)
    {
        for(Vertex v : Vertices )
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

    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex source, Vertex zink)
    {
        Map<Vertex,Vertex> PredecessorMap= new HashMap<>();
        Map<Vertex,Integer> DistanceMap=new HashMap<>();
        // initialize arrays
        for(Vertex v: Vertices)
        {
            DistanceMap.put(v,1000);
            PredecessorMap.put(v, null);
        }



        //implement Dijkstra

        public int[] Dijkstra(int source) {
        int[] shortestdistance = new int[matrixgraph.length];
        int[] predecessor = new int[matrixgraph.length];
        boolean[] handled = new boolean[matrixgraph.length];
        //Code goes here
        for (int i = 0; i < matrixgraph.length; i++) {
            predecessor[i]=-1;
            handled[i] = false;
            shortestdistance[i] = (int)Double.POSITIVE_INFINITY;
        }

        shortestdistance[source - 1] = 0;

        int v, u;
        int udist, vdist = 200;
        for (int count = 0; count < matrixgraph.length; count++) {
            v = findMin(shortestdistance, handled);
            vdist=shortestdistance[v];
            System.out.println("Smallest node " + v+ " distance " +shortestdistance[v]);
            for (int i = 0; i < matrixgraph.length; i++) {
                if (matrixgraph[v][i] > 0) {
                    if (matrixgraph[v][i] + vdist < shortestdistance[i]) {
                        shortestdistance[i] = matrixgraph[v][i] + vdist;
                        predecessor[i] = v;
                    }
                }
            }
            handled[v] = true;
        }
        return predecessor;
    }


        return (new Pair<Integer,Map<Vertex,Vertex>> (DistanceMap.get(zink), PredecessorMap));
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