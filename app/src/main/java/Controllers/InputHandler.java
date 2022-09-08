package Controllers;

import java.util.Map;
import java.util.Set;

import UIObjects.BasicGateUI;
import UIObjects.IONode;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class InputHandler {


    private ConnectLine line = null;
    private IONode outNodetemp = null;
    private boolean dragging = false;
    private GateDeleter gateDeleter;


    public InputHandler(GateDeleter gateDeleter)
    {
        this.gateDeleter = gateDeleter;
    }
   

    public void handleBasicGateMultiInInput(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        gate.setOnMouseDragged(e -> {


            if(e.getButton() == MouseButton.PRIMARY)
            {
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
            }
        });

        gate.getOutNode().setOnMouseDragged(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                if(e.getX() > 0)
                {
                    this.handleDrag(gate, e, gate.getOutNode());
                }
                else
                {
                    this.handleRelease(ioConnectionsController, gate, e);
                }
            }
        });

        gate.getOutNode().setOnMouseReleased(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRelease(ioConnectionsController, gate, e);
            }

        });

        for(IONode node : gate.getInNodes())
        {
            node.setOnMouseDragged(e -> {
                if(e.getButton() == MouseButton.SECONDARY)
                {
                    if(e.getX() > 0)
                    {
                        this.handleDrag(gate, e, node);
                    }
                    else
                    {
                        this.handleRelease(ioConnectionsController, gate, e);
                    }
                }
            });
            node.setOnMouseReleased(e -> {
                if(e.getButton() == MouseButton.SECONDARY)
                {
                    this.handleRelease(ioConnectionsController, gate, e);
                }
            });
        }


        gate.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRightClick(ioConnectionsController, gate, e);
            }
        });
    }


    public void handleBasicSingleInInput(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        gate.setOnMouseDragged(e -> {


            if(e.getButton() == MouseButton.PRIMARY)
            {
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
            }
        });
        gate.getOutNode().setOnMouseDragged(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                if(e.getX() > 0)
                {
                    this.handleDrag(gate, e, gate.getOutNode());
                }
                else
                {
                    this.handleRelease(ioConnectionsController, gate, e);
                }
            }
            
        });

        gate.getOutNode().setOnMouseReleased(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRelease(ioConnectionsController, gate, e);
            }
        });

        for(IONode node : gate.getInNodes())
        {
            node.setOnMouseDragged(e -> {

                if(e.getButton() == MouseButton.SECONDARY)
                {
                    if(e.getX() > 0)
                    {
                        this.handleDrag(gate, e, node);
                    }
                    else   
                    {
                        this.handleRelease(ioConnectionsController, gate, e);
                    }
                }
            });
            node.setOnMouseReleased(e -> {
                if(e.getButton() == MouseButton.SECONDARY)
                {
                    this.handleRelease(ioConnectionsController, gate, e);
                }
            });
        }

        gate.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRightClick(ioConnectionsController, gate, e);
            }
        });
    }

    public void handleBufferNode(IOConnectionsController ioConnectionsController, LogicalGraph logicalGraph, BasicGateUI gate)
    {

        gate.setOnMouseDragged(e -> {

            if(e.getButton() == MouseButton.PRIMARY)
            {
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
            }
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleDrag(gate, e, gate.getOutNode());
            }
        });

        gate.getOutNode().node.setOnMouseReleased(e -> {

            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRelease(ioConnectionsController, gate, e);
            }
        
        });

       
        for(IONode node : gate.getInNodes())
        {

            node.setOnMouseReleased(e -> {

                if(e.getButton() == MouseButton.SECONDARY)
                {
                    this.handleRelease(ioConnectionsController, gate, e);
                }
            });
            gate.setOnMouseClicked(e -> {
                if(e.getButton() == MouseButton.SECONDARY)
                {
                    this.handleRightClick(ioConnectionsController, gate, e);
                }
            });
            return;
            
        }
        gate.getOutNode().node.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY)
            {
                logicalGraph.flipInputValue(gate);
            }
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRightClick(ioConnectionsController, gate, e);
            }
        });
    }

    private void handleIONodesLines(IOConnectionsController ioConnectionsController, BasicGateUI gate)
    {
        Map<IONode, Set<ConnectLine>> outNodesLinesMap = ioConnectionsController.getOutNodesLinesMap();
        Map<IONode, ConnectLine> inNodesLinesMap = ioConnectionsController.getInNodesLinesMap();

        IONode outNode = gate.getOutNode();
        Set<ConnectLine> outLines = outNodesLinesMap.get(outNode);
        if(outLines != null)
        {
            for(ConnectLine outLine : outLines)
            {
                outLine.setLine(outNode.getX(), outNode.getY(), outLine.getEndX(), outLine.getEndY());
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
                    inLine.setLine(inLine.getStartX(), inLine.getStartY(), inNode.getX(), inNode.getY());
                } 
            }
        }
        
    }


    private void handleDrag(BasicGateUI gate, MouseEvent e, IONode node)
    {
        if(line == null)
        {
            line = new ConnectLine();
            outNodetemp = node;
            gate.getRoot().getChildren().addAll(line.getLines());
        }

        line.setLine(node.getX(), node.getY(), e.getX(), e.getY());
        this.dragging = true;
    }

    private void handleRelease(IOConnectionsController ioConnectionsController, BasicGateUI gate, MouseEvent e)
    {
        if(this.dragging)
        {
            gate.getRoot().getChildren().removeAll(line.getLines());
            for(IONode node : ioConnectionsController.getIoNodes())
            {
                if(node.node.contains(e.getX(), e.getY()))
                {
                    ioConnectionsController.connect(outNodetemp, node);
                    break;
                }
            }

            this.dragging = false;  
            line = null;
            outNodetemp = null;
        }
    }

    
    private void handleRightClick(IOConnectionsController ioConnectionsController, BasicGateUI gate, MouseEvent e)
    {

        ContextMenu menu = new ContextMenu();
        MenuItem delete = new MenuItem("Delete");
        MenuItem removeFirstInput = new MenuItem("Remove Input 1");
        MenuItem removeSecondInput = new MenuItem("Remove Input 2");

        delete.setOnAction(event -> {
            this.gateDeleter.deleteGate(gate, ioConnectionsController);
            menu.hide();
        });


        if(gate.getInNodes().length > 0)
        {
            removeFirstInput.setOnAction(event -> {
                this.gateDeleter.removeInputNode(gate.getInNodes()[0], ioConnectionsController);
            });
            removeSecondInput.setOnAction(event -> {
                this.gateDeleter.removeInputNode(gate.getInNodes()[1], ioConnectionsController);
            });
    
            if(!ioConnectionsController.getInNodesLinesMap().containsKey(gate.getInNodes()[0]))
            {
                removeFirstInput.setDisable(true);
            }
            if(gate.getInNodes().length > 1)
            {
                if(!ioConnectionsController.getInNodesLinesMap().containsKey(gate.getInNodes()[1]))
                {
                    removeSecondInput.setDisable(true);
                }
            }
            else
            {
                removeSecondInput.setDisable(true);
            }
        }
        else    
        {
            removeFirstInput.setVisible(false);
            removeSecondInput.setVisible(false);
        }
       
        
        
        
        menu.getItems().addAll(delete, removeFirstInput, removeSecondInput);
        menu.show(gate.getRoot().getScene().getWindow(), e.getScreenX(), e.getScreenY());

    }


}
