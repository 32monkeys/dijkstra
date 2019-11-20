package dijkstra;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {
        // Create graph
        GraphTests TestGraph= new GraphTests();
        Graph g = TestGraph.MakeSmallGraph();
        Vertex source = g.getVertex("J");
        Vertex zink = g.getVertex("F");
        Pair<Integer, Map<Vertex, Vertex>> results=g.ShortestDistance(source, zink);
        Vertex current =zink;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(zink);
        while ((current != source) && (results.getValue().get(current)!=null))
        {
            current=results.getValue().get(current);
            Path.add(0,current);
        }
        for(Vertex v : Path)
        {
            System.out.print( v.name);
            if (v!=zink)
                System.out.print("->");
        }



    }
    public Graph MakeSmallGraph()
    {
        Graph mygraph= new Graph();
        /*final Vertex A=mygraph.addVertex("A");
        final Vertex B= mygraph.addVertex("B");
        final Vertex C =mygraph.addVertex("C");
        final Vertex D = mygraph.addVertex("D");
        final Vertex E = mygraph.addVertex("E");
        final Vertex F = mygraph.addVertex("F");

        mygraph.newEdge(A,B,1,2);
        mygraph.newEdge(A,C, 5,1);
        mygraph.newEdge(A,D, 4,6);
        mygraph.newEdge(B,C, 3,2);
        mygraph.newEdge(B,D, 2,3);
        mygraph.newEdge(B,E, 2,4);
        mygraph.newEdge(C,F, 1,8);
        mygraph.newEdge(C,E, 2,2);
        mygraph.newEdge(D,F, 2,7);
        mygraph.newEdge(E,F, 3,6);


        final Vertex A=mygraph.addVertex("A");
        final Vertex B= mygraph.addVertex("B");
        final Vertex C =mygraph.addVertex("C");
        final Vertex D = mygraph.addVertex("D");
        final Vertex E = mygraph.addVertex("E");

        mygraph.newEdge(A,B, 5,  3);
        mygraph.newEdge(A,C, 10,  3);
        mygraph.newEdge(B,C, 3,  3);
        mygraph.newEdge(B,D, 2,  3);
        mygraph.newEdge(B,E, 9,  3);
        mygraph.newEdge(C,B, 2,  3);
        mygraph.newEdge(C,E, 1,  3);
        mygraph.newEdge(D,E, 6,  3);
        mygraph.newEdge(E,D, 4,  3);
        */
        final Vertex A = mygraph.addVertex("A");
        final Vertex B = mygraph.addVertex("B");
        final Vertex C = mygraph.addVertex("C");
        final Vertex D = mygraph.addVertex("D");
        final Vertex E = mygraph.addVertex("E");
        final Vertex F = mygraph.addVertex("F");
        final Vertex G = mygraph.addVertex("G");
        final Vertex H = mygraph.addVertex("H");
        final Vertex I = mygraph.addVertex("I");
        final Vertex J = mygraph.addVertex("J");

        mygraph.newEdge(A,B,10,0);
        mygraph.newEdge(A,D,20,0);
        mygraph.newEdge(A,E,20,0);
        mygraph.newEdge(A,F,5,0);
        mygraph.newEdge(A,G,15,0);
        mygraph.newEdge(B,C,7,0);
        mygraph.newEdge(B,D,10,0);
        mygraph.newEdge(C,B,15,0);
        mygraph.newEdge(C,D,5,0);
        mygraph.newEdge(D,E,10,0);
        mygraph.newEdge(E,F,5,0);
        mygraph.newEdge(G,F,10,0);
        mygraph.newEdge(H,A,5,0);
        mygraph.newEdge(H,B,20,0);
        mygraph.newEdge(H,G,5,0);
        mygraph.newEdge(I,B,15,0);
        mygraph.newEdge(I,H,20,0);
        mygraph.newEdge(I,J,10,0);
        mygraph.newEdge(J,B,5,0);
        mygraph.newEdge(J,C,15,0);



        return mygraph;

    }
}
