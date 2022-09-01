package Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import UIObjects.IONode;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class IOConnectionsController {
    
    private static IOConnectionsController instance = null;
    private Group root;
    private Set<IONode> inNodes;
    private Set<IONode> outNodes;
    private Map<IONode, IONode> inOutNodesMap;
    private Map<IONode, List<Line>> outNodesLinesMap;
    private Map<IONode, Line> inNodesLinesMap;


    private IOConnectionsController(Group root)
    {
        inNodes = new HashSet<>();
        outNodes = new HashSet<>();
        inOutNodesMap = new HashMap<>();
        outNodesLinesMap = new HashMap<>();
        inNodesLinesMap = new HashMap<>();

        this.root = root;
    }

    public static IOConnectionsController getInstance(Group root)
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
        Line line = new Line();


        this.inNodesLinesMap.put(inNode, line);

        if(!this.outNodesLinesMap.containsKey(outNode))
        {
            this.outNodesLinesMap.put(outNode, new ArrayList<Line>());
        }
        this.outNodesLinesMap.get(outNode).add(line);


        line.setStartX(outNode.node.getCenterX());
        line.setStartY(outNode.node.getCenterY());

        line.setEndX(inNode.node.getCenterX());
        line.setEndY(inNode.node.getCenterY());

        this.root.getChildren().add(line);

        inNodes.add(inNode);
        outNodes.add(outNode);
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

    public Map<IONode, Line> getInNodesLinesMap()
    {
        return this.inNodesLinesMap;
    }

    public Map<IONode, List<Line>> getOutNodesLinesMap()
    {
        return this.outNodesLinesMap;
    }

    

}
