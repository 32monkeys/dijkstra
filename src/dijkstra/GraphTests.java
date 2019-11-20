package dijkstra;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {
        // Create graph
        GraphTests TestGraph= new GraphTests();
        Graph g = TestGraph.MakeSmallGraph();
        Vertex startNode = g.getvertex("A");
        Vertex endNode = g.getvertex("E");
        Pair<Integer, Map<Vertex, Vertex>> results=g.ShortestDistance(startNode, endNode);
        Vertex current =endNode;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(endNode);
        while ((current != startNode) && (results.getValue().get(current)!=null))
        {
            //System.out.println(current.name);
            current=results.getValue().get(current);
            Path.add(0,current);
        }
        for(Vertex v : Path)
        {
            System.out.print( v.name);
            if (v!=endNode)
                System.out.print("->");
        }



    }
    public Graph MakeSmallGraph()
    {
        Graph mygraph= new Graph();
        final Vertex A=mygraph.addvertex("A");
        final Vertex B= mygraph.addvertex("B");
        final Vertex C =mygraph.addvertex("C");
        final Vertex D = mygraph.addvertex("D");
        final Vertex E = mygraph.addvertex("E");
        //final Vertex F = mygraph.addvertex("F");



        mygraph.newedge(A,B, 5,  3);
        mygraph.newedge(A,C, 10,  3);
        mygraph.newedge(B,C, 3,  3);
        mygraph.newedge(B,D, 2,  3);
        mygraph.newedge(B,E, 9,  3);
        mygraph.newedge(C,B, 2,  3);
        mygraph.newedge(C,E, 1,  3);
        mygraph.newedge(D,E, 6,  3);
        mygraph.newedge(E,D, 4,  3);





        return mygraph;

    }
}
