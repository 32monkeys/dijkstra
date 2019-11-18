package dijkstra;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {
        // Create graph
        GraphTests TestGraph= new GraphTests();
        Graph graph = TestGraph.MakeSmallGraph();
        Vertex source = graph.getvertex("A");
        Vertex zink = graph.getvertex("F");
        Pair<Integer, Map<Vertex, Vertex>> results=graph.ShortestDistance(source, zink);
        System.out.println(results);
        Vertex current = zink;
        ArrayList<Vertex> path= new ArrayList<>();
        path.add(zink);
        System.out.print("my path is: ");
        path.forEach((node)->{
            System.out.print("->");
            System.out.print(node.Name);
        });
        System.out.println("   <---The end");

        while ((current != source) && (results.getValue().get(current)!=null)) {
            current=results.getValue().get(current);
            path.add(0,current);
        }
        for(Vertex v : path) {
            System.out.print( v.Name);
            if (v!=zink)
                System.out.print("->");
        }

    }

    public Graph MakeSmallGraph() {
        Graph mygraph= new Graph();
        final Vertex A=mygraph.addvertex("A");
        final Vertex B= mygraph.addvertex("B");
        final Vertex C =mygraph.addvertex("C");
        final Vertex D = mygraph.addvertex("D");
        final Vertex E = mygraph.addvertex("E");
        final Vertex F = mygraph.addvertex("F");

        mygraph.newedge(A,B,1,2);
        mygraph.newedge(A,C, 5,1);
        mygraph.newedge(A,D, 4,6);
        mygraph.newedge(B,C, 3,2);
        mygraph.newedge(B,D, 2,3);
        mygraph.newedge(B,E, 2,4);
        mygraph.newedge(C,F, 1,8);
        mygraph.newedge(C,E, 2,2);
        mygraph.newedge(D,F, 2,7);
        mygraph.newedge(E,F, 3,6);


        return mygraph;

    }
}
