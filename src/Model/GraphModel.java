package Model;

import Model.DAO.PlaceDAO;
import Model.DAO.PlaceDAOI;
import Model.DataStructures.Graph.Graph;

public class GraphModel {
    private final PlaceDAOI placeDAOI;
    private final Graph graph;

    public GraphModel() {
        this.placeDAOI = new PlaceDAO();
        this.graph = placeDAOI.getPopulatedGraph();
    }

    public void DFS(String vName){
        graph.dfs(vName);
    }

    public void BFS(String vName){
        graph.bfs(vName);
    }

    public boolean vertexExists(String vName){
        return graph.vertexExists(vName);
    }

    public Graph getGraph() {
        return graph;
    }
}
