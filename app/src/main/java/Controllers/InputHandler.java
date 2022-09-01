package Controllers;


import java.util.List;
import java.util.Map;

import UIObjects.BasicGateUI;
import UIObjects.IONode;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class InputHandler {


    private static InputHandler instance = null;
    private Line line = null;
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
        ImageView texture = gate.getTexture();

        texture.setOnMouseDragged(e -> {
            texture.setX(e.getSceneX() - gate.getWidth() / 2);
            texture.setY(e.getSceneY() - gate.getHeight() / 2);


            gate.getOutNode().move(texture.getX() + gate.getWidth(), texture.getY() + 
                                gate.getHeight() / 2 + 0.3);

           
            gate.getInNodes()[0].move(texture.getX(), texture.getY() + 14);
            gate.getInNodes()[1].move(texture.getX(), texture.getY() + gate.getHeight() - 15);

            this.handleIONodesLines(ioConnectionsController, gate);

        });
    }


    public void handleBasicSingleInInput(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        ImageView texture = gate.getTexture();


        texture.setOnMouseDragged(e -> {
            texture.setX(e.getSceneX() - gate.getWidth() / 2);
            texture.setY(e.getSceneY() - gate.getWidth() / 2);

            gate.getOutNode().move(texture.getX() + gate.getWidth(), texture.getY() + gate.getHeight() / 2 + 0.3);

            gate.getInNodes()[0].move(texture.getX(), texture.getY() + gate.getHeight() / 2);
            this.handleIONodesLines(ioConnectionsController, gate);

        });
    }

    private void handleIONodesLines(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        Map<IONode, List<Line>> outNodesLinesMap = ioConnectionsController.getOutNodesLinesMap();
        Map<IONode, Line> inNodesLinesMap = ioConnectionsController.getInNodesLinesMap();

        IONode outNode = gate.getOutNode();
        List<Line> outLines = outNodesLinesMap.get(outNode);
        if(outLines != null)
        {
            for(Line outLine : outLines)
            {
                outLine.setStartX(outNode.node.getCenterX());
                outLine.setStartY(outNode.node.getCenterY());
            }
         
        }

        if(gate.getInNodes() != null)
        {
            for(int i = 0; i < gate.getInNodes().length; i++)
            {
                IONode inNode = gate.getInNodes()[i];
                Line inLine = inNodesLinesMap.get(inNode);
                if(inLine != null)
                {
                    inLine.setEndX(inNode.node.getCenterX());
                    inLine.setEndY(inNode.node.getCenterY());
    
                } 
            }
        }
        
    }

    public void handleBufferNode(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        gate.getOutNode().node.setOnMouseDragged(e -> {
            gate.move(e.getSceneX(), e.getSceneY());
            this.handleIONodesLines(ioConnectionsController, gate);
        });
  
    }

    public void handleIOConnection(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {

       
        gate.getOutNode().node.setOnMouseDragged(e -> {

            if(line == null)
            {
                line = new Line();
                outNodetemp = gate.getOutNode();
                gate.getRoot().getChildren().add(line);
            }
            line.setStartX(gate.getOutNode().node.getCenterX());
            line.setStartY(gate.getOutNode().node.getCenterY());
            
            line.setEndX(e.getSceneX());
            line.setEndY(e.getSceneY());
            this.dragging = true;


        });


        gate.getOutNode().node.setOnMouseReleased(e -> {

            if(this.dragging && !this.foundInNode)
            {
                gate.getRoot().getChildren().remove(line);
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
