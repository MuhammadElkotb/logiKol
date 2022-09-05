package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import UIObjects.IONode;
import javafx.scene.layout.Pane;

public class IOConnectionsController {
    
    private static IOConnectionsController instance = null;
    private Pane root;
    private Set<IONode> inNodes;
    private Set<IONode> outNodes;
    private Set<IONode> ioNodes;
    private Map<IONode, IONode> inOutNodesMap;
    private Map<IONode, List<ConnectLine>> outNodesLinesMap;
    private Map<IONode, ConnectLine> inNodesLinesMap;
    private LogicalGraph logicalGraph;

    private IOConnectionsController(Pane root, LogicalGraph logicalGraph)
    {
        inNodes = new HashSet<>();
        outNodes = new HashSet<>();
        ioNodes = new HashSet<>();
        inOutNodesMap = new HashMap<>();
        outNodesLinesMap = new HashMap<>();
        inNodesLinesMap = new HashMap<>();
        this.logicalGraph = logicalGraph;

        this.root = root;
    }

    public static IOConnectionsController getInstance(Pane root, LogicalGraph logicalGraph)
    {
        if(instance == null)
        {
            instance = new IOConnectionsController(root, logicalGraph);
        }
        return instance;
    }


    public void connect(IONode node1, IONode node2)
    {


        if(node1 == null || node2 == null)
        {
            return;
        }

        boolean node1In = this.inNodes.contains(node1);
        boolean node1Out = this.outNodes.contains(node1);
        boolean node2In = this.inNodes.contains(node2);
        boolean node2Out = this.outNodes.contains(node2);
        boolean node1Io = this.ioNodes.contains(node1);
        boolean node2Io = this.ioNodes.contains(node2);



        if(node1Out && node2Out) return;
        if(node1In && node2In) return;

        if(node1In && (this.inNodesLinesMap.get(node1) != null)) return;
        if(node2In && (this.inNodesLinesMap.get(node2) != null)) return;
        if(node1Out && (this.inNodesLinesMap.get(node2) != null)) return;
        if(node2Out && (this.inNodesLinesMap.get(node1) != null)) return;


        ConnectLine connectLine = new ConnectLine();


        if(node1Out && node2In)
        {

            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new ArrayList<ConnectLine>());
            }
            this.outNodesLinesMap.get(node1).add(connectLine);
            inOutNodesMap.put(node1, node2);
            connectLine.setLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
            this.logicalGraph.connect(node1, node2);

        }
        else if(node1In && node2Out)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new ArrayList<ConnectLine>());
            }
            this.outNodesLinesMap.get(node2).add(connectLine);
            inOutNodesMap.put(node2, node1);
            connectLine.setLine(node2.getX(), node2.getY(), node1.getX(), node1.getY());
            this.logicalGraph.connect(node2, node1);



        }
        else if(node1In && !node2In && !node2Out && node2Io)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new ArrayList<ConnectLine>());
            }
            this.outNodesLinesMap.get(node2).add(connectLine);
            inOutNodesMap.put(node2, node1);
            connectLine.setLine(node2.getX(), node2.getY(), node1.getX(), node1.getY());
            this.logicalGraph.connect(node2, node1);


            
        }
        else if(node1Out && !node2In && !node2Out && node2Io)
        {
            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new ArrayList<ConnectLine>());
            }
            this.outNodesLinesMap.get(node1).add(connectLine);
            inOutNodesMap.put(node1, node2);
            connectLine.setLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
            this.logicalGraph.connect(node1, node2);


        }
        else if(node2Out && !node1In && !node1Out && node1Io)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new ArrayList<ConnectLine>());
            }
            this.outNodesLinesMap.get(node2).add(connectLine);
            inOutNodesMap.put(node2, node1);
            connectLine.setLine(node2.getX(), node2.getY(), node1.getX(), node1.getY());
            this.logicalGraph.connect(node2, node1);


        }
        else if(node2In && !node1In && !node1Out && node1Io)
        {
            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new ArrayList<ConnectLine>());
            }
            this.outNodesLinesMap.get(node1).add(connectLine);
            inOutNodesMap.put(node1, node2);
            connectLine.setLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
            this.logicalGraph.connect(node1, node2);

        }
        this.root.getChildren().addAll(0, Arrays.asList(connectLine.getLines()));

    }

    public void addInNode(IONode node)
    {
        this.inNodes.add(node);
        this.ioNodes.add(node);
    }
    public void addOutNode(IONode node)
    {
        this.outNodes.add(node);
        this.ioNodes.add(node);
    }
    public void addIoNode(IONode node)
    {
        this.ioNodes.add(node);
    }
    public Set<IONode> getInNodes()
    {
        return this.inNodes;
    }

    public Set<IONode> getOutNodes()
    {
        return this.outNodes;
    }

    public Set<IONode> getIoNodes()
    {
        return this.ioNodes;
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
