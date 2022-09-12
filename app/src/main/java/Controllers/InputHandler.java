package Controllers;

import java.util.Map;
import java.util.Set;

import UIObjects.BasicGateUI;
import UIObjects.IONode;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class InputHandler {


    private Pane root = null;
    private ConnectLine line = null;
    private ConnectCircle circle = null;
    private IONode outNodetemp = null;
    private boolean dragging = false;
    private GateDeleter gateDeleter;


    public InputHandler(Pane root, GateDeleter gateDeleter)
    {
        this.gateDeleter = gateDeleter;
        this.root = root;
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
                    this.handleDrag(gate, e, gate.getOutNode(), null, 0);
                }
                else
                {
                    this.handleRelease(ioConnectionsController, gate, e, null);
                }
            }
        });

        gate.getOutNode().setOnMouseReleased(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRelease(ioConnectionsController, gate, e, null);
            }

        });

        for(IONode node : gate.getInNodes())
        {
            node.setOnMouseDragged(e -> {
                if(e.getButton() == MouseButton.SECONDARY)
                {
                    if(e.getX() > 0)
                    {
                        this.handleDrag(gate, e, node, null, 0);
                    }
                    else
                    {
                        this.handleRelease(ioConnectionsController, gate, e, null);
                    }
                }
            });
            node.setOnMouseReleased(e -> {
                if(e.getButton() == MouseButton.SECONDARY)
                {
                    this.handleRelease(ioConnectionsController, gate, e, null);
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
                    this.handleDrag(gate, e, gate.getOutNode(), null, 0);
                }
                else
                {
                    this.handleRelease(ioConnectionsController, gate, e, null);
                }
            }
            
        });

        gate.getOutNode().setOnMouseReleased(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRelease(ioConnectionsController, gate, e, null);
            }
        });

        for(IONode node : gate.getInNodes())
        {
            node.setOnMouseDragged(e -> {

                if(e.getButton() == MouseButton.SECONDARY)
                {
                    if(e.getX() > 0)
                    {
                        this.handleDrag(gate, e, node, null, 0);
                    }
                    else   
                    {
                        this.handleRelease(ioConnectionsController, gate, e, null);
                    }
                }
            });
            node.setOnMouseReleased(e -> {
                if(e.getButton() == MouseButton.SECONDARY)
                {
                    this.handleRelease(ioConnectionsController, gate, e, null);
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
                this.handleDrag(gate, e, gate.getOutNode(), null, 0);
            }
        });

        gate.getOutNode().node.setOnMouseReleased(e -> {

            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.handleRelease(ioConnectionsController, gate, e, null);
            }
        
        });

       
        for(IONode node : gate.getInNodes())
        {

            node.setOnMouseReleased(e -> {

                if(e.getButton() == MouseButton.SECONDARY)
                {
                    this.handleRelease(ioConnectionsController, gate, e, null);
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
                Set<ConnectLine> connectedLines = ioConnectionsController.getConnectedLinesMap().get(outLine);
                if(connectedLines != null)
                {
                    for(ConnectLine connectedLine : connectedLines)
                    {
                        connectedLine.setLine(connectedLine.getEndX(), connectedLine.getEndY());
                    }
                }
                
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
                    Set<ConnectLine> connectedLines = ioConnectionsController.getConnectedLinesMap().get(inLine);
                    if(connectedLines != null)
                    {
                        for(ConnectLine connectedLine : connectedLines)
                        {
                            connectedLine.setLine(connectedLine.getEndX(), connectedLine.getEndY());
                        }
                    }

                    if(inLine.circleAttached())
                    {
                        inLine.setLine(inNode.getX(), inNode.getY());
                    }
                } 
            }
        }
        
    }


    private void handleDrag(BasicGateUI gate, MouseEvent e, IONode node, ConnectLine connectLine, int lineNumber)
    {
        if(gate != null)
        {
            if(line == null)
            {
                line = new ConnectLine();
                outNodetemp = node;
                gate.getRoot().getChildren().addAll(line.getLines());
            }
    
            line.setLine(node.getX(), node.getY(), e.getX(), e.getY());
        }
        else
        {
            if(line == null)
            {
                line = new ConnectLine();

                if(circle == null)
                {
                    circle = new ConnectCircle(connectLine.getLines()[lineNumber], lineNumber, e.getX(), e.getY());
                }
                System.out.println(circle.isLineVertical());
            System.out.println(lineNumber);
                this.root.getChildren().addAll(line.getLines());
                this.root.getChildren().add(circle.getCircle());
                line.setConnectionCircle(circle);
            }
    
            
            line.setLine(e.getX(), e.getY());
        }
        
        this.dragging = true;
    }

    private void handleRelease(IOConnectionsController ioConnectionsController, BasicGateUI gate, MouseEvent e, ConnectLine connectLine)
    {
        if(this.dragging)
        {
            this.root.getChildren().removeAll(line.getLines());
            
            if(circle != null)
            {
                this.root.getChildren().remove(circle.getCircle());
            }

            for(IONode node : ioConnectionsController.getIoNodes())
            {
                if(node.node.contains(e.getX(), e.getY()))
                {
                    if(circle == null)
                    {
                        ioConnectionsController.connect(outNodetemp, node, null, null);
                    }
                    else
                    {
                        ConnectCircle newCircle = new ConnectCircle(connectLine.getLines()[circle.getLineNumber()], 
                                circle.getLineNumber(), circle.getCircle().getCenterX(), circle.getCircle().getCenterY());

                        System.out.println(newCircle.isLineVertical());

                        ioConnectionsController.connect(ioConnectionsController.getLinesIONodesMap().get(connectLine).get(0), node, newCircle, connectLine);
                    }
                    break;
                }
            }

            this.dragging = false;  
            line = null;
            circle = null;
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


    public void handleLinetoNodeConnection(IOConnectionsController ioConnectionsController, ConnectLine line)
    {

        line.getLines()[0].setOnMouseDragged(e -> {
            
            this.handleDrag(null, e, null, line, 0);
        });

        line.getLines()[1].setOnMouseDragged(e -> {
            
            this.handleDrag(null, e, null, line, 1);
        });

        line.getLines()[0].setOnMouseReleased(e -> {
            this.handleRelease(ioConnectionsController, null, e, line);
        });

        line.getLines()[1].setOnMouseReleased(e -> {
            this.handleRelease(ioConnectionsController, null, e, line);
        });

        line.setOnMouseClicked(e -> {
        });
        
    }


}
