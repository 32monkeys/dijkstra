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
    int fuckingHighNumber = 200;

    /////////////////////////////////////////////////////////////////////
    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex source, Vertex zink) {

        System.out.print(source.Name);
        System.out.print(" to "); System.out.println(zink.Name);
        Map<Vertex,Vertex> predecessorMap= new HashMap<>();
        Map<Vertex,Integer> distanceMap=new HashMap<>();
        // initialize arrays
        for(Vertex vertex: Vertices) {
            distanceMap.put(vertex,fuckingHighNumber); // was 1000 before
            predecessorMap.put(vertex, null);
        }

        //TODO: implement Dijkstra (ours below
        //Code goes here
//////////////////////////////////////////////////////////////////////////////
        //int[] shortestdistance = new int[DistanceMap.size()];
        //int[] predecessor = new int[PredecessorMap.size()];
        //boolean[] handled = new boolean[predecessorMap.size()];

        for (int i = 0; i < predecessorMap.size(); i++) {
            predecessorMap.put(predecessorMap.get(i),null);
            //handled[i] = false;
            distanceMap.put(predecessorMap.get(i), fuckingHighNumber); // was  200
        }

        // TODO: source is a vertex here, not an integer, change this
        // shortestdistance(source-1) = 0;
        distanceMap.put(source,0);

        Vertex current, next;
        int currentDist = fuckingHighNumber, nextDistance = fuckingHighNumber;
        for (int count = 0; count < predecessorMap.size(); count++) {
            current = getmin(distanceMap); // TODO: implement a findMin function
            nextDistance=distanceMap.get(current);
            System.out.println("Smallest node " + current+ " distance " +distanceMap.get(current));

            for (int i = 0; i < predecessorMap.size(); i++) {
                if (distanceMap.get(predecessorMap.get(i)) > 0) {
                    if (distanceMap.get(current)+distanceMap.get(predecessorMap.get(i)) < distanceMap.get(i)) {
                        distanceMap.put(predecessorMap.get(i),distanceMap.get(predecessorMap.get(i)) + currentDist);
                        predecessorMap.put(predecessorMap.get(i),current);
                    }
                }
            }


            //handled[current] = true;
        }
///////////////////////////////////////////////////////////////////////////// returns
        return (new Pair<Integer,Map<Vertex,Vertex>> (distanceMap.get(zink), predecessorMap));
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public Vertex getmin(Map<Vertex,Integer> qmap){


        boolean done = false;
        System.out.println(qmap.size());
        qmap.forEach((k,v)->{
            //System.out.println(qmap);
            //System.out.println(k.Name);
        });

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