package Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import UIObjects.IONode;
import javafx.scene.layout.Pane;

public class IOConnectionsController {
    
    private Pane root;
    private InputHandler inputHandler;
    private Set<IONode> inNodes;
    private Set<IONode> outNodes;
    private Set<IONode> ioNodes;
    private Map<IONode, Set<IONode>> outInNodesMap;
    private Map<IONode, IONode> inOutNodesMap;
    private Map<IONode, Set<ConnectLine>> outNodesLinesMap;
    private Map<IONode, ConnectLine> inNodesLinesMap;
    private Map<ConnectLine, List<IONode>> linesIONodesMap;
    private Map<ConnectLine, Set<ConnectLine>> connectLinesMap;
    private LogicalGraph logicalGraph;
    private Runner runner;

    public IOConnectionsController(Pane root, LogicalGraph logicalGraph, Runner runner)
    {
        inNodes = new HashSet<>();
        outNodes = new HashSet<>();
        ioNodes = new HashSet<>();
        inOutNodesMap = new HashMap<>();
        outInNodesMap = new HashMap<>();
        linesIONodesMap = new HashMap<>();
        outNodesLinesMap = new HashMap<>();
        inNodesLinesMap = new HashMap<>();
        this.connectLinesMap = new HashMap<>();
        this.logicalGraph = logicalGraph;
        this.root = root;
        this.runner = runner;
    }

    public void setInputHandler(InputHandler inputHandler)
    {
        this.inputHandler = inputHandler;
    }

    public void connect(IONode node1, IONode node2, ConnectCircle circle, ConnectLine line)
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


        ConnectLine connectLine;

        if(circle != null)
        {
            boolean vertical = circle.isLineVertical();

            connectLine = new ConnectLine(vertical ? false : true, false);

            connectLine.setConnectionCircle(circle);
        }
        else
        {
            connectLine = new ConnectLine();
        }

        this.linesIONodesMap.put(connectLine, new ArrayList<>());


        if(node1Out && node2In)
        {

            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new LinkedHashSet<ConnectLine>());
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

            this.linesIONodesMap.get(connectLine).add(node1);
            this.linesIONodesMap.get(connectLine).add(node2);


        }
        else if(node1In && node2Out)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new LinkedHashSet<ConnectLine>());
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

            
            this.linesIONodesMap.get(connectLine).add(node2);
            this.linesIONodesMap.get(connectLine).add(node1);



        }
        else if(node1In && !node2In && !node2Out && node2Io)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new LinkedHashSet<ConnectLine>());
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


            this.linesIONodesMap.get(connectLine).add(node2);
            this.linesIONodesMap.get(connectLine).add(node1);
            
        }
        else if(node1Out && !node2In && !node2Out && node2Io)
        {
            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new LinkedHashSet<ConnectLine>());
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

            
            this.linesIONodesMap.get(connectLine).add(node1);
            this.linesIONodesMap.get(connectLine).add(node2);

        }
        else if(node2Out && !node1In && !node1Out && node1Io)
        {
            this.inNodesLinesMap.put(node1, connectLine);

            if(!this.outNodesLinesMap.containsKey(node2))
            {
                this.outNodesLinesMap.put(node2, new LinkedHashSet<ConnectLine>());
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


            
            this.linesIONodesMap.get(connectLine).add(node2);
            this.linesIONodesMap.get(connectLine).add(node1);
        }
        else if(node2In && !node1In && !node1Out && node1Io)
        {
            this.inNodesLinesMap.put(node2, connectLine);

            if(!this.outNodesLinesMap.containsKey(node1))
            {
                this.outNodesLinesMap.put(node1, new LinkedHashSet<ConnectLine>());
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

            
            this.linesIONodesMap.get(connectLine).add(node1);
            this.linesIONodesMap.get(connectLine).add(node2);

        }


        this.root.getChildren().add(0, connectLine.getLines()[0]);
        this.root.getChildren().add(0, connectLine.getLines()[1]);

        this.root.getChildren().add(0, connectLine.getTempConnectCircle());


        if(connectLine.getConnectionCircle() != null)
        {
            this.root.getChildren().addAll(connectLine.getConnectionCircle().getCircle());
            line.getConnectionCircles().add(circle);
            if(!this.connectLinesMap.containsKey(line))
            {
                this.connectLinesMap.put(line, new HashSet<>());
            }
            this.connectLinesMap.get(line).add(connectLine);

            for(ConnectLine tempLine : this.outNodesLinesMap.get(node1))
            {
                if(tempLine.isMainLine())
                {
                    this.connectLinesMap.get(tempLine).add(connectLine);
                }
            }
            
        }

        this.inputHandler.handleLinetoNodeConnection(this, connectLine);

        this.runner.run();


    }

    public void deleteInNode(IONode node)
    {
        ConnectLine line = this.inNodesLinesMap.get(node);
        if(line != null)
        {
            this.removeConnection(line);
        }

        this.ioNodes.remove(node);
        this.inNodes.remove(node);



    }

    public void deleteOutNode(IONode node)
    {
        Set<ConnectLine> lines = this.outNodesLinesMap.get(node);
        
        if(lines != null)
        {
            Iterator<ConnectLine> linesIt = lines.iterator();

            while(linesIt.hasNext())
            {
                this.removeConnection(linesIt.next());
                linesIt.remove();

            }
        }
        
        this.ioNodes.remove(node);
        this.outNodes.remove(node);



    }

    public void removeConnection(ConnectLine line)
    {

        if(!this.linesIONodesMap.containsKey(line)) return;

        IONode outNode = this.linesIONodesMap.get(line).get(0);
        IONode inNode = this.linesIONodesMap.get(line).get(1);



        Set<ConnectLine> connectedLines = this.connectLinesMap.get(line);
        System.out.println("Before Loop");
        if(connectedLines != null)
        {
            for(ConnectLine connectedLine : connectedLines)
            {
                this.removeConnection(connectedLine);
                
            }
        }

       
        this.inNodesLinesMap.remove(inNode);

        this.linesIONodesMap.remove(line);
       
        this.connectLinesMap.remove(line);
        this.root.getChildren().removeAll(line.getLines());
        if(line.getConnectionCircle() != null)
        {
            this.root.getChildren().remove(line.getConnectionCircle().getCircle());
        }

        this.outInNodesMap.get(outNode).remove(inNode);
        this.inOutNodesMap.remove(inNode);

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

    public Map<ConnectLine, List<IONode>> getLinesIONodesMap()
    {
        return this.linesIONodesMap;
    }
    public Map<ConnectLine, Set<ConnectLine>> getConnectedLinesMap()
    {
        return this.connectLinesMap;
    }
    

}
