package dijkstra;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class OurGraphTest {

    public static void main(String[] args) {
        // Create graph
        OurGraphTest TestGraph= new OurGraphTest();
        Graph g = TestGraph.MakeBigGraph();
        Vertex source = g.getvertex("J");
        Vertex zink = g.getvertex("F");
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
            System.out.print( v.Name);
            if (v!=zink)
                System.out.print("->");
        }



    }
    public Graph MakeBigGraph(){
        Graph ourGraph = new Graph();
        final Vertex A = ourGraph.addvertex("A");
        final Vertex B = ourGraph.addvertex("B");
        final Vertex C = ourGraph.addvertex("C");
        final Vertex D = ourGraph.addvertex("D");
        final Vertex E = ourGraph.addvertex("E");
        final Vertex F = ourGraph.addvertex("F");
        final Vertex G = ourGraph.addvertex("G");
        final Vertex H = ourGraph.addvertex("H");
        final Vertex I = ourGraph.addvertex("I");
        final Vertex J = ourGraph.addvertex("J");

        ourGraph.newedge(A,B,10,0);
        ourGraph.newedge(A,D,20,0);
        ourGraph.newedge(A,E,20,0);
        ourGraph.newedge(A,F,5,0);
        ourGraph.newedge(A,G,15,0);
        ourGraph.newedge(B,C,5,0);
        ourGraph.newedge(B,D,10,0);
        ourGraph.newedge(C,B,15,0);
        ourGraph.newedge(C,D,5,0);
        ourGraph.newedge(D,E,10,0);
        ourGraph.newedge(E,F,5,0);
        ourGraph.newedge(G,F,10,0);
        ourGraph.newedge(H,A,5,0);
        ourGraph.newedge(H,B,20,0);
        ourGraph.newedge(H,G,5,0);
        ourGraph.newedge(I,B,15,0);
        ourGraph.newedge(I,H,20,0);
        ourGraph.newedge(I,J,10,0);
        ourGraph.newedge(J,B,5,0);
        ourGraph.newedge(J,C,15,0);

        return ourGraph;
    }
}
