package Controller;

import Model.DataStructures.Graph.Vertex;
import Model.GraphModel;
import View.View;

import java.util.List;
import java.util.Scanner;

public class GraphController {
    private final GraphModel model;
    private final View view;

    public GraphController(GraphModel graphModel, View view) {
        this.model = graphModel;
        this.view = view;
    }

    public void controlUserAction(String mode){
        switch (mode) {
            case "D" -> DFS();
            case "E" -> BFS();
            case "F" -> addVertex();
            case "G" -> addConnection();
        }
    }

    public void DFS(){
        String vName;
        List<Vertex> dfsVertexes;
        view.updateView(1);
        vName = new Scanner(System.in).nextLine();

        if(model.vertexExists(vName)){
            model.DFS(vName);
            dfsVertexes = model.getGraph().getAlgorithmVertexList();
            for (Vertex vertex:dfsVertexes) {
                view.updateView(vertex.getPlace());
            }
        }else{
            view.updateView(3);
        }

        view.updateView(2);
    }

    public void BFS(){
        String vName;
        List<Vertex> bfsVertexes;
        view.updateView(1);
        vName = new Scanner(System.in).nextLine();
        if(model.vertexExists(vName)){
            model.BFS(vName);
            bfsVertexes = model.getGraph().getAlgorithmVertexList();
            for (Vertex vertex:bfsVertexes) {
                view.updateView(vertex.getPlace());
            }
        }else{
            view.updateView(3);
        }

        view.updateView(2);

    }

    public void addVertex(){
        String vName;
        String vID;
        String vType;

        view.updateView(4);
        vName = new Scanner(System.in).nextLine();

        view.updateView(5);
        vID = new Scanner(System.in).nextLine();

        view.updateView(6);
        vType = new Scanner(System.in).nextLine();
        try{
            model.getGraph().addVertex(Integer.parseInt(vID), vName, vType);
            view.updateView(7);
        }catch (NumberFormatException e){
            view.updateView(8);
        }
    }

    public void addConnection(){
        String srcVertex;
        String dstVertex;
        String distance;

        view.updateView(9);
        srcVertex = new Scanner(System.in).nextLine();

        view.updateView(10);
        dstVertex = new Scanner(System.in).nextLine();

        view.updateView(11);
        distance = new Scanner(System.in).nextLine();

        if(vertexesExist(srcVertex, dstVertex)){
            try{
                model.getGraph().addEdge(srcVertex, dstVertex, Float.parseFloat(distance));
                view.updateView(14);
            }catch (NumberFormatException e){
                view.updateView(13);
            }
        }else{
            view.updateView(12);
        }
    }

    private boolean vertexesExist(String srcVertex, String dstVertex){
        return model.getGraph().vertexExists(srcVertex)
                && model.getGraph().vertexExists(dstVertex);
    }


}
