package logikol;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ToolsPane {


    private ScrollPane toolsPane;
    private AnchorPane anchorPane;
    private Map<String, Node> nodesMap;
    
    
    public ToolsPane(Scene scene, String toolsPaneId, String anchorPaneId)
    {

        toolsPane = (ScrollPane)scene.lookup("#".concat(toolsPaneId));
        anchorPane = (AnchorPane)toolsPane.lookup("#".concat(anchorPaneId));
        this.nodesMap = new HashMap<>();
        for(Node node : anchorPane.getChildren())
        {
            nodesMap.put(node.getId(), node);
        }
    }


    public Node getNodeById(String id)
    {
        Node node = null;
        node = nodesMap.get(id);
        return node;
    }

    public double getLayoutWidth()
    {
        return this.toolsPane.getWidth();
    }

    public Map<String, Node> getToolsNodes()
    {
        return this.nodesMap;
    }
    
}
