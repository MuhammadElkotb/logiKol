package Controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import UIObjects.IONode;
import javafx.scene.layout.Pane;

public class IOConnectionsController {
    
    private Pane root;
    private Set<IONode> inNodes;
    private Set<IONode> outNodes;
    private Set<IONode> ioNodes;
    private Map<IONode, Set<IONode>> outInNodesMap;
    private Map<IONode, IONode> inOutNodesMap;
    private Map<IONode, Set<ConnectLine>> outNodesLinesMap;
    private Map<IONode, ConnectLine> inNodesLinesMap;
    private LogicalGraph logicalGraph;

    public IOConnectionsController(Pane root, LogicalGraph logicalGraph)
    {
        inNodes = new HashSet<>();
        outNodes = new HashSet<>();
        ioNodes = new HashSet<>();
        inOutNodesMap = new HashMap<>();
        outInNodesMap = new HashMap<>();

        outNodesLinesMap = new HashMap<>();
        inNodesLinesMap = new HashMap<>();
        this.logicalGraph = logicalGraph;

        this.root = root;
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
                this.outNodesLinesMap.put(node1, new HashSet<ConnectLine>());
            }
            this.outNodesLinesMap.get(node1).add(connectLine);

            inOutNodesMap.put(node2, node1);

            if(!this.outInNodesMap.containsKey(node1))
            {
                this.outInNodesMap.put(node1, new HashSet<>());
            }
            
            this.outInNodesMap.get(node1).add(node2);
            
            connectLine.setLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
            this.logicalGraph.connect(node1, node2);

        }
        else if(node1In && node2Out)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new HashSet<ConnectLine>());
            }
            this.outNodesLinesMap.get(node2).add(connectLine);


            inOutNodesMap.put(node1, node2);

            if(!this.outInNodesMap.containsKey(node2))
            {
                this.outInNodesMap.put(node2, new HashSet<>());
            }
            
            this.outInNodesMap.get(node2).add(node1);
            
            
            connectLine.setLine(node2.getX(), node2.getY(), node1.getX(), node1.getY());
            this.logicalGraph.connect(node2, node1);



        }
        else if(node1In && !node2In && !node2Out && node2Io)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new HashSet<ConnectLine>());
            }
            this.outNodesLinesMap.get(node2).add(connectLine);


            inOutNodesMap.put(node1, node2);

            if(!this.outInNodesMap.containsKey(node2))
            {
                this.outInNodesMap.put(node2, new HashSet<>());
            }
            
            this.outInNodesMap.get(node2).add(node1);
            
            
            connectLine.setLine(node2.getX(), node2.getY(), node1.getX(), node1.getY());
            this.logicalGraph.connect(node2, node1);


            
        }
        else if(node1Out && !node2In && !node2Out && node2Io)
        {
            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new HashSet<ConnectLine>());
            }
            this.outNodesLinesMap.get(node1).add(connectLine);


            inOutNodesMap.put(node2, node1);

            if(!this.outInNodesMap.containsKey(node1))
            {
                this.outInNodesMap.put(node1, new HashSet<>());
            }
            
            this.outInNodesMap.get(node1).add(node2);
            
            
            connectLine.setLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
            this.logicalGraph.connect(node1, node2);


        }
        else if(node2Out && !node1In && !node1Out && node1Io)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new HashSet<ConnectLine>());
            }
            this.outNodesLinesMap.get(node2).add(connectLine);

            
            inOutNodesMap.put(node1, node2);

            if(!this.outInNodesMap.containsKey(node2))
            {
                this.outInNodesMap.put(node2, new HashSet<>());
            }
            
            this.outInNodesMap.get(node2).add(node1);
            
            
            connectLine.setLine(node2.getX(), node2.getY(), node1.getX(), node1.getY());
            this.logicalGraph.connect(node2, node1);


        }
        else if(node2In && !node1In && !node1Out && node1Io)
        {
            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new HashSet<ConnectLine>());
            }
            this.outNodesLinesMap.get(node1).add(connectLine);

            inOutNodesMap.put(node2, node1);

            if(!this.outInNodesMap.containsKey(node1))
            {
                this.outInNodesMap.put(node1, new HashSet<>());
            }
            
            this.outInNodesMap.get(node1).add(node2);
            
            
            connectLine.setLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
            this.logicalGraph.connect(node1, node2);

        }
        this.root.getChildren().addAll(0, Arrays.asList(connectLine.getLines()));

    }

    public void deleteInNode(IONode node)
    {
        ConnectLine line = this.inNodesLinesMap.get(node);
        if(line != null)
        {
            this.root.getChildren().removeAll(line.getLines());
        }
        this.ioNodes.remove(node);
        this.inNodesLinesMap.remove(node);
        this.inNodes.remove(node);

        IONode outNode = this.inOutNodesMap.get(node);
        IONode deleteNode = null;

        if(line != null && outNode != null)
        {
            this.outNodesLinesMap.get(outNode).remove(line);

            for(IONode inNode : this.outInNodesMap.get(outNode))
            {
                if(inNode == node)
                {
                    deleteNode = inNode;
                }
            }
            if(deleteNode != null)
            {
                this.outInNodesMap.get(outNode).remove(deleteNode);
            }
        }

        this.inOutNodesMap.remove(node);

    }

    public void deleteOutNode(IONode node)
    {
        Set<ConnectLine> line = this.outNodesLinesMap.get(node);
        
        if(line != null)
        {
            for(ConnectLine lineTemp : line)
            {
                this.root.getChildren().removeAll(lineTemp.getLines());
            }
        }
        
        this.ioNodes.remove(node);
        this.outNodesLinesMap.remove(node);
        this.outNodes.remove(node);


        Set<IONode> inNodes = this.outInNodesMap.get(node);

        if(inNodes != null)
        {
            for(IONode inNode : inNodes)
            {
                this.inNodesLinesMap.remove(inNode);
                this.inOutNodesMap.remove(inNode);
            }
        }

        this.outInNodesMap.remove(node);
        
    }
    public void removeInConnection(IONode node)
    {
        ConnectLine line = this.inNodesLinesMap.get(node);

        if(line != null)
        {
            this.root.getChildren().removeAll(line.getLines());
        }
        this.inNodesLinesMap.remove(node);

        IONode outNode = this.inOutNodesMap.get(node);
        IONode deleteNode = null;
        if(line != null && outNode != null)
        {
            this.outNodesLinesMap.get(outNode).remove(line);

            for(IONode inNode : this.outInNodesMap.get(outNode))
            {
                if(inNode == node)
                {
                    deleteNode = inNode;
                }
            }
            if(deleteNode != null)
            {
                this.outInNodesMap.get(outNode).remove(deleteNode);
            }

        }
        this.inOutNodesMap.remove(node);

    }

    public void removeOutConnection(IONode node)
    {
        this.outInNodesMap.remove(node);
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


    public Map<IONode, ConnectLine> getInNodesLinesMap()
    {
        return this.inNodesLinesMap;
    }

    public Map<IONode, Set<ConnectLine>> getOutNodesLinesMap()
    {
        return this.outNodesLinesMap;
    }

    public Map<IONode, IONode> getInOutNodesMap()
    {
        return this.inOutNodesMap;
    }

    public Map<IONode, Set<IONode>> getOutInNodesMap()
    {
        return this.outInNodesMap;
    }

    

}
