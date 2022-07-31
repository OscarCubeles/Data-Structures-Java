package Model.DAO;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;


public class DAOConnector {

    private static DAOConnector daoConnector;
    private final String tablesDataset;
    private final String graphDataset;
    private final String binaryTreeDataset;

    private DAOConnector(){
        String resourceName = "config.json";
        InputStream input = DAOConnector.class.getResourceAsStream(resourceName);
        if (input == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        JSONTokener tokenizer = new JSONTokener(input);
        JSONObject object = new JSONObject(tokenizer);

        this.tablesDataset = object.getString("DatasetTables");
        this.graphDataset = object.getString("DatasetGraphs");
        this.binaryTreeDataset = object.getString("DatasetBinaryTrees");
    }

    public static DAOConnector getInstance(){
        if (daoConnector == null){
            daoConnector = new DAOConnector();
        }
        return daoConnector;
    }

    public String getTablesDataset() {
        return tablesDataset;
    }

    public String getGraphDataset() {
        return graphDataset;
    }

    public String getBinaryTreeDataset() {
        return binaryTreeDataset;
    }
}
