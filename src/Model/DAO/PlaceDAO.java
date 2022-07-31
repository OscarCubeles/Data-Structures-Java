package Model.DAO;

import Model.DataStructures.Graph.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlaceDAO implements PlaceDAOI{
    @Override
    public Graph getPopulatedGraph() {
        Graph graph = new Graph();
        try{
            File fileObj = new File(DAOConnector.getInstance().getGraphDataset());
            Scanner fileReader = new Scanner(fileObj);
            int vertexId;
            String vertexName;
            String vertexType;
            int numPlaces = Integer.parseInt(fileReader.nextLine());
            for (int i = 0; i < numPlaces; i++) {
                String data = fileReader.nextLine();
                String[] line = data.split(",");
                vertexId = Integer.parseInt(line[0]);
                vertexName = line[1];
                vertexType = line[2];
                graph.addVertex(vertexId, vertexName, vertexType);
            }
            int srcID;
            int dstID;
            float distance;
            int numEdges = Integer.parseInt(fileReader.nextLine());
            for (int i = 0; i < numEdges; i++) {
                String data = fileReader.nextLine();
                String[] line = data.split(",");
                srcID = Integer.parseInt(line[0]);
                dstID = Integer.parseInt(line[1]);
                distance = Float.parseFloat(line[2]);
                graph.addEdge(srcID, dstID, distance);
            }

        }catch(FileNotFoundException e){
            System.out.println("Error. Unable to open " +  DAOConnector.getInstance().getGraphDataset());
            System.exit(-1);
        }
        return graph;
    }
}
