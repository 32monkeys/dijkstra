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
            if (v.name ==s)
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
    int infinity = (int)Double.POSITIVE_INFINITY;

    /////////////////////////////////////

    public Pair<Integer, Map<Vertex,Vertex> > ShortestDistance(Vertex startNode, Vertex endNode)
    {
        Map<Vertex,Vertex> predecessorMap= new HashMap<>(); // The key is a vertex, the value is the previous vertex
        Map<Vertex,Integer> distanceMap=new HashMap<>(); // The key is a vertex, the value is the shortest distance to it
        // initialize arrays
        for(Vertex vertex: vertices) {
            distanceMap.put(vertex,infinity); // This is the nodes and their weight
            predecessorMap.put(vertex, null); // we set the vertex to be null, which is meant to be "not visited"
        }

        // TODO: We implements the dijkstra
        /////////////////////////////implement Dijkstra /////////////////////////////
        // Initialize values


        //Vertex previous = new Vertex("Start"); // Set start to previous

        Vertex previous = startNode; // Set previous to be start node
        Vertex current = startNode;
        Vertex next = null;

        distanceMap.put(previous,0);
        distanceMap.put(current,0); // Set value of previous node
        predecessorMap.put(startNode,startNode);

        int someDistance = 0;
//!previous.equals(endNode)
        while(predecessorMap.containsValue(null)&&(!current.equals(endNode))){ //TODO: what would happen if we start at a point, where we cant evaluate everything?
            //for(int i=0; i<6;i++) {
                System.out.println(previous.name+" is having the weight of: "+distanceMap.get(previous));
                System.out.println("For: " + previous.name + " {");
                int min = infinity;
                int weight = infinity;
                for (Edge edge : predecessorMap.get(previous).getOutEdges()) {


                    if(!previous.equals(edge.getToVertex())){
                        current = edge.getToVertex();

                        if (predecessorMap.get(current)==null) {

                            //System.out.println(current.name + "<----");

                            System.out.print("\t From: " + previous.name + " ");
                            System.out.print("\t To: " + current.name + " ");
                            System.out.print("\t Distance: " + edge.distance);
                            System.out.println();
                            weight = edge.distance;
                            if (min >= edge.distance) {

                                min = edge.distance;
                                next = edge.getToVertex();
                            }

                            //System.out.println("\t this should be low is: "+distanceMap.get(next));
                            //System.out.println("\t weight+previous is: "+(distanceMap.get(previous)+weight));
                            //System.out.println("\t current is: "+distanceMap.get(current));
                            //System.out.println("\t next is: "+distanceMap.get(next));

                            if((distanceMap.get(previous)+weight)<=distanceMap.get(current)){
                                System.out.println("\t "+current.name+" is now: "+(distanceMap.get(previous) + weight));
                                distanceMap.put(current, distanceMap.get(previous) + weight);
                            } else {
                                System.out.println("\t removed "+previous.name);
                                predecessorMap.remove(previous);
                                current = previous;
                            }


                        } else {
                            System.out.println("not evaluating: "+current.name);
                            //current = previous;
                        }
                    }


                }

                System.out.println("\t Minimum is: " + min + " So we select: " + next.name);
                System.out.println("}");
                System.out.println();


            // TODO: make foreach here
            //for(edge.)

                current = next;
                previous = current;
                predecessorMap.put(previous,current);
            System.out.println("i put key: "+previous.name+" the value: "+current.name);
                //predecessorMap.put(previous,current);

            //}
        }


        /////////////////////////////////////////////////////////////////////////////////
        System.exit(0); // remove this when done
        return null;
        //return (new Pair<Integer,Map<Vertex,Vertex>> (distanceMap.get(startNode), predecessorMap));
    }
    public Vertex getmin(Map<Vertex,Integer> qmap){
        // Your code
        return null;
    }
}



class Vertex{
    public String name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        name =id;
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

    public Vertex getToVertex() {
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