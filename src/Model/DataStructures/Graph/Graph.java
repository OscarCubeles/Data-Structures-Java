package Model.DataStructures.Graph;

import java.util.*;

public class Graph {
    private final HashMap<Vertex, LinkedList<Edge>> graph;
    private final HashMap<Integer, Vertex> idMap;
    private final HashMap<String, Vertex> nameMap;
    private final LinkedList<Vertex> graphVertexes;
    private LinkedList<Vertex> algorithmVertexList;

    public Graph() {
        graph = new HashMap<>();
        idMap = new HashMap<>();
        nameMap = new HashMap<>();
        graphVertexes = new LinkedList<>();
    }

    public void addVertex(int vID, String vName, String vType){
        Vertex vertex = new Vertex(vID, vName, vType);
        graph.put(vertex, new LinkedList<>());
        idMap.put(vID, vertex);
        nameMap.put(vName, vertex);
        graphVertexes.add(vertex);
    }

    public void addEdge(int srcVertexId, int dstVertexID, float distance){
        Vertex srcVertex = idMap.get(srcVertexId);
        Vertex dstVertex = idMap.get(dstVertexID);
        Edge srcEdge = new Edge(dstVertex, distance);
        Edge dstEdge = new Edge(srcVertex, distance);
        graph.get(srcVertex).add(srcEdge);
        graph.get(dstVertex).add(dstEdge);
    }

    public void addEdge(String srcVertexName, String dstVertexName, float distance){
        Vertex srcVertex = nameMap.get(srcVertexName);
        Vertex dstVertex = nameMap.get(dstVertexName);
        Edge srcEdge = new Edge(dstVertex, distance);
        Edge dstEdge = new Edge(srcVertex, distance);
        graph.get(srcVertex).add(srcEdge);
        graph.get(dstVertex).add(dstEdge);
    }

    public void dfs(String vName) {
        Vertex firstVertex = nameMap.get(vName);
        resetVisited();
        dfsRecursive(firstVertex);
    }

    private void resetVisited(){
        algorithmVertexList = new LinkedList<>();
        for (Vertex vertex: graphVertexes) {
            vertex.setUnvisited();
        }
    }

    private void dfsRecursive(Vertex current) {
        current.setVisited();
        algorithmVertexList.add(current);

        for (Edge edge : graph.get(current)) {
            if (!edge.isVisited())
                dfsRecursive(edge.getAdjVertex());
        }
    }

    public LinkedList<Vertex> getAlgorithmVertexList() {
        return algorithmVertexList;
    }

    public void bfs(String vName){
        resetVisited();
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = nameMap.get(vName);

        queue.add(vertex);
        vertex.setVisited();

        while(!queue.isEmpty()){
            Vertex v = queue.remove();
            algorithmVertexList.add(v);
            for (Edge edge: graph.get(v)) {
                Vertex adjVertex = edge.getAdjVertex();
                if(!adjVertex.isVisited()){
                    queue.add(adjVertex);
                    adjVertex.setVisited();
                }
            }
        }
    }

    public boolean vertexExists(String vName){
        return nameMap.get(vName) != null;
    }


}
