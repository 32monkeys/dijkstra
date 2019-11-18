package dijkstra;

import java.util.*;
import javafx.util.Pair;

public class Graph<T> {
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
/////////////////////////////////////////////////////////////////////
    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex source, Vertex zink) {
        Map<Vertex,Vertex> predecessorMap= new HashMap<>();
        Map<Vertex,Integer> distanceMap=new HashMap<>();
        // initialize arrays
        for(Vertex vertex: Vertices) {
            distanceMap.put(vertex,(int)Double.POSITIVE_INFINITY); // was 1000 before
            predecessorMap.put(vertex, null);
        }

        //TODO: implement Dijkstra (ours below
        //Code goes here
//////////////////////////////////////////////////////////////////////////////
        //int[] shortestdistance = new int[DistanceMap.size()];
        //int[] predecessor = new int[PredecessorMap.size()];
        boolean[] handled = new boolean[predecessorMap.size()];

        for (int i = 0; i < predecessorMap.size(); i++) {
            predecessorMap.put(predecessorMap.get(i),null);
            handled[i] = false;
            distanceMap.put(predecessorMap.get(i), (int)Double.POSITIVE_INFINITY); // was  200
        }

        // TODO: source is a vertex here, not an integer, change this
        // shortestdistance(source-1) = 0;
        distanceMap.put(predecessorMap.get(source),0);

        Vertex current, next;
        int currentDist, nextDistance = (int)Double.POSITIVE_INFINITY;
        for (int count = 0; count < predecessorMap.size(); count++) {
            current = getmin(distanceMap.get(count), 1); // TODO: implement a findMin function
            vdist=predecessorMap.get(v);
            System.out.println("Smallest node " + v+ " distance " +shortestdistance[v]);
            /*
            for (int i = 0; i < PredecessorMap.size(); i++) {
                if (PredecessorMap.size()[v][i] > 0) {
                    if (matrixgraph[v][i] + vdist < shortestdistance[i]) {
                        shortestdistance[i] = matrixgraph[v][i] + vdist;
                        predecessor[i] = v;
                    }
                }
            }
            */

            handled[v] = true;
        }
///////////////////////////////////////////////////////////////////////////// returns
        return (new Pair<Integer,Map<Vertex,Vertex>> (DistanceMap.get(zink), PredecessorMap));
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public Vertex getmin(Map<Vertex,Integer> qmap){
       // Your code
        Vertex vertex=null;
        int value=200;
        for (int i = 0; i < dist.length ; i++) {
            if (dist[i]<value && !done[i])
            {
                vertex=i;
                value=dist[i];
            }
        }
        return vertex;
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