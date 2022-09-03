package Controllers;


import java.util.List;
import java.util.Map;

import UIObjects.BasicGateUI;
import UIObjects.IONode;

public class InputHandler {


    private static InputHandler instance = null;
    private ConnectLine line = null;
    private IONode outNodetemp = null;
    private boolean dragging = false;
    private boolean foundInNode = false;


    private InputHandler()
    {

    }
    public static InputHandler getInstance()
    {
        if(instance == null)
        {
            instance = new InputHandler();
        }
        return instance;
    }

    public void handleBasicGateMultiInInput(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        gate.setOnMouseDragged(e -> {

            double x = e.getX() - gate.getWidth() / 2;
            double y = e.getY() - gate.getHeight() / 2;
            
            if(x - 8 > 0)
            {
                gate.move(x, y);
                gate.getOutNode().move(x + gate.getWidth(), y + 
                                    gate.getHeight() / 2 + 0.3);
                gate.getInNodes()[0].move(x, y + 14);
                gate.getInNodes()[1].move(x, y + gate.getHeight() - 15);
                this.handleIONodesLines(ioConnectionsController, gate);
            }
            else
            {
                gate.move(gate.getX(), y);
                gate.getOutNode().move(gate.getX() + gate.getWidth(), y + 
                                    gate.getHeight() / 2 + 0.3);
                gate.getInNodes()[0].move(gate.getX(), y + 14);
                gate.getInNodes()[1].move(gate.getX(), y + gate.getHeight() - 15);
                this.handleIONodesLines(ioConnectionsController, gate);
            }
            
        });
    }


    public void handleBasicSingleInInput(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        gate.setOnMouseDragged(e -> {

            double x = e.getX() - gate.getWidth() / 2;
            double y = e.getY() - gate.getHeight() / 2;

            if(x - 8 > 0)
            {
                gate.move(x, y);
                gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
                gate.getInNodes()[0].move(x, y + gate.getHeight() / 2);
                this.handleIONodesLines(ioConnectionsController, gate);
            }
            else
            {
                gate.move(gate.getX(), y);
                gate.getOutNode().move(gate.getX() + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
                gate.getInNodes()[0].move(gate.getX(), y + gate.getHeight() / 2);
                this.handleIONodesLines(ioConnectionsController, gate);
            }
        });
    }

    public void handleBufferNode(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        gate.setOnMouseDragged(e -> {
            double x = e.getX();
            double y = e.getY();
            if(x - 11 > 0)
            {
                gate.move(x, y);
                this.handleIONodesLines(ioConnectionsController, gate);
            }
            else
            {
                gate.move(gate.getX(), y);
                this.handleIONodesLines(ioConnectionsController, gate);
            }
            
        });
    }

    private void handleIONodesLines(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        Map<IONode, List<ConnectLine>> outNodesLinesMap = ioConnectionsController.getOutNodesLinesMap();
        Map<IONode, ConnectLine> inNodesLinesMap = ioConnectionsController.getInNodesLinesMap();

        IONode outNode = gate.getOutNode();
        List<ConnectLine> outLines = outNodesLinesMap.get(outNode);
        if(outLines != null)
        {
            for(ConnectLine outLine : outLines)
            {
                outLine.setLine(outNode.node.getCenterX(), outNode.node.getCenterY(), outLine.getEndX(), outLine.getEndY());
            }
         
        }

        if(gate.getInNodes() != null)
        {
            for(int i = 0; i < gate.getInNodes().length; i++)
            {
                IONode inNode = gate.getInNodes()[i];
                ConnectLine inLine = inNodesLinesMap.get(inNode);
                if(inLine != null)
                {
                    inLine.setLine(inLine.getStartX(), inLine.getStartY(), inNode.node.getCenterX(), inNode.node.getCenterY());
                } 
            }
        }
        
    }

   

    public void handleIOConnection(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {

       
        gate.getOutNode().node.setOnMouseDragged(e -> {
            if(line == null)
            {
                line = new ConnectLine();
                outNodetemp = gate.getOutNode();
                gate.getRoot().getChildren().addAll(line.getLines());
            }

            line.setLine(gate.getOutNode().getX(), gate.getOutNode().getY(), e.getX(), e.getY());
            this.dragging = true;
        });


        gate.getOutNode().node.setOnMouseReleased(e -> {

            if(this.dragging && !this.foundInNode)
            {
                gate.getRoot().getChildren().removeAll(line.getLines());
                this.dragging = false;  
                line = null;
                outNodetemp = null;

            }
        });
       
        // if(gate.getInNodes() != null)
        // {
        //     for(int i = 0; i < gate.getInNodes().length; i++)
        //     {
        //         final int temp = i;
        //         gate.getInNodes()[temp].node.hoverProperty().addListener(e -> {
        //             this.foundInNode = true;
        //             if(this.dragging && this.foundInNode)
        //             {
        //                 /*line.setEndX(gate.getInNodes()[temp].node.getCenterX());
        //                 line.setEndY(gate.getInNodes()[temp].node.getCenterY());*/
        //                 ioConnectionsController.connect(outNodetemp, gate.getInNodes()[temp]);
        //                 outNodetemp = null;
    
        //             }
        //             this.foundInNode = false;
        //         });

        //     }
                
        // }

    }
}
