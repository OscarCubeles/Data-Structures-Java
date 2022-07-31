package Model.DataStructures.Graph;

import Model.DataStructures.Graph.Vertex;

public class Edge {
    private final Vertex adjVertex;
    private final float distance;


    public Edge(Vertex adjVertex, float distance) {
        this.adjVertex = adjVertex;
        this.distance = distance;
    }

    public String getName(){
        return adjVertex.getName();
    }

    public boolean isVisited(){
        return adjVertex.isVisited();
    }

    public Vertex getAdjVertex(){
        return adjVertex;
    }

    public float getDistance() {
        return distance;
    }
}
