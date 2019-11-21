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
        Vertex current = null;
        Vertex next = null;

        distanceMap.put(previous,0); // Setting previous distance map to 0
        predecessorMap.put(startNode,previous); // Initialize the start as "coming from previous" (which at start is start)

        ArrayList<Vertex> queue = new ArrayList<Vertex>();

        int minimum = infinity;
        int weight = infinity;

        while(predecessorMap.containsValue(null)){ //TODO: what would happen if we start at a point, where we cant evaluate everything?
            System.out.println(previous.name+" is having the weight of: "+distanceMap.get(previous));
            System.out.println("For: " + previous.name + " {");

            for (Edge edge : previous.getOutEdges()) {
                if (!previous.equals(edge.getToVertex())) {
                    current = edge.getToVertex(); // Current is set to the end of the edge, if the relation arrow is pointing outwards
                    if (predecessorMap.get(current) == null) { // check if the end of the edge is null (available)
                        System.out.print("\t From: " + previous.name + " "); System.out.print("\t To: " + current.name + " ");
                        System.out.print("\t Distance: " + edge.distance); System.out.println();

                        if (weight <= distanceMap.get(current)) {
                            weight = edge.distance+distanceMap.get(previous);
                            distanceMap.put(current, weight); // Set the weight to distMap
                            System.out.println("\t " + current.name + " is now: " + weight);
                        } else {
                            predecessorMap.remove(previous); // Removing vertex
                            System.out.println("\t removed " + previous.name);
                            // we are not setting a new previous here, the reason is that we instead had a loop that runs from the other vertices.
                        }

                        if (minimum >= edge.distance) {
                            minimum = edge.distance; // Setting the minimum to be the lowest of the edge distances in this for loop
                            next = current;
                        } else if(!current.equals(endNode)) {
                            queue.add(current); // This is the Queue of the other nodes, that is higher than the minimum
                        }
                    } else {
                        System.out.println("not evaluating: " + current.name);
                    }
                }
            }

            System.out.println("i put key: "+previous.name+" the value: "+next.name);
            if(previous.name.equals("C")&&previous!=null){
                System.out.println("fucking shit");
                System.out.println(predecessorMap.get(next.name));
                System.exit(0);
            }
            if(previous==next&&!next.equals(endNode)){
                if(queue.size()==0) System.err.println("wtf we have no Q!!! :o");
                System.out.println("Now we run the KØØØ");
                previous = queue.get(0);
                queue.remove(0);
                System.out.println("We fucking jumps mate");

            } else {
                previous = next; // Set the previous to be the current

                System.out.println("\t Minimum is: " + minimum + " So we select: " + next.name);
                System.out.println("}");
                System.out.println();

                System.out.println(next.name+" is "+distanceMap.get(next));

                System.out.println("Kø: "+queue.size());
                for(Vertex q : queue){
                    System.out.println("This Kø -> "+q.name);
                }



            }

            predecessorMap.put(next,previous);


            System.out.println("WEEEEEEEEEE HAAAAAAAAAAAAS "+predecessorMap.containsValue(null));
for(Vertex lorten : vertices){
    if(predecessorMap.get(lorten)!=null){
        System.out.println(predecessorMap.get(lorten).name);
    }
}




        }


        /////////////////////////////////////////////////////////////////////////////////
        //System.exit(0); // remove this when done
        //return null;
        return (new Pair<Integer,Map<Vertex,Vertex>> (distanceMap.get(startNode), predecessorMap));
    }

    public Vertex findMin(){
        return null;
    }

    public Vertex getMin(Map<Vertex,Integer> qmap){
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