package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import UIObjects.IONode;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class IOConnectionsController {
    
    private static IOConnectionsController instance = null;
    private Pane root;
    private Set<IONode> inNodes;
    private Set<IONode> outNodes;
    private Map<IONode, IONode> inOutNodesMap;
    private Map<IONode, List<ConnectLine>> outNodesLinesMap;
    private Map<IONode, ConnectLine> inNodesLinesMap;


    private IOConnectionsController(Pane root)
    {
        inNodes = new HashSet<>();
        outNodes = new HashSet<>();
        inOutNodesMap = new HashMap<>();
        outNodesLinesMap = new HashMap<>();
        inNodesLinesMap = new HashMap<>();

        this.root = root;
    }

    public static IOConnectionsController getInstance(Pane root)
    {
        if(instance == null)
        {
            instance = new IOConnectionsController(root);
        }
        return instance;
    }


    public void connect(IONode outNode, IONode inNode)
    {
        if(inNode == null)
        {
            return;
        }

        ConnectLine connectLine = new ConnectLine();


        this.inNodesLinesMap.put(inNode, connectLine);

        if(!this.outNodesLinesMap.containsKey(outNode))
        {
            this.outNodesLinesMap.put(outNode, new ArrayList<ConnectLine>());
        }
        this.outNodesLinesMap.get(outNode).add(connectLine);


        connectLine.setLine(outNode.node.getCenterX(), outNode.node.getCenterY(), inNode.node.getCenterX(), inNode.node.getCenterY());

        
        this.root.getChildren().addAll(0, Arrays.asList(connectLine.getLines()));

        inOutNodesMap.put(outNode, inNode);
    }

    public Set<IONode> getInNodes()
    {
        return this.inNodes;
    }

    public Set<IONode> getOutNodes()
    {
        return this.outNodes;
    }

    public Map<IONode, IONode> getInOutNodesMap()
    {
        return this.inOutNodesMap;
    }

    public Map<IONode, ConnectLine> getInNodesLinesMap()
    {
        return this.inNodesLinesMap;
    }

    public Map<IONode, List<ConnectLine>> getOutNodesLinesMap()
    {
        return this.outNodesLinesMap;
    }

    

}
