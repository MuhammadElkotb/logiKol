package Controllers;

import Gates.BasicGate;
import UIObjects.BasicGateUI;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
public class UIController {

    private static UIController instance = null;
    private InputHandler inputHandler = null;
    private IOConnectionsController ioConnectionsController = null;
    private LogicalGraph logicalGraph = null;

    
    private UIController(InputHandler inputHandler, IOConnectionsController ioConnectionsController, LogicalGraph logicalGraph)
    {
        this.inputHandler = inputHandler;
        this.ioConnectionsController = ioConnectionsController;
        this.logicalGraph = logicalGraph;

    }
    public static UIController getInstnace(InputHandler inputHandler, IOConnectionsController ioConnectionsController, LogicalGraph logicalGraph)
    {
        if(instance == null)
        {
            instance = new UIController(inputHandler, ioConnectionsController, logicalGraph);
        }
        return instance;
    }
    
    public void moveGateUI(BasicGateUI gate, double x, double y)
    {
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
    } 

    public void mountBasicMultiInGateUI(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x + gateUI.getWidth(), y + gateUI.getHeight() / 2 + 0.3);
        
        gateUI.getInNodes()[0].move(x, y + 14);
        gateUI.getInNodes()[1].move(x, y + gateUI.getHeight() - 15);

        this.ioConnectionsController.addOutNode(gateUI.getOutNode());
        this.ioConnectionsController.addInNode(gateUI.getInNodes()[0]);
        this.ioConnectionsController.addInNode(gateUI.getInNodes()[1]);
        this.inputHandler.handleBasicGateMultiInInput(this.ioConnectionsController, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);
    }
    public void mountBasicSingleInGateUI(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x + gateUI.getWidth(), y + gateUI.getHeight() / 2 + 0.3);

        gateUI.getInNodes()[0].move(x, y + gateUI.getHeight() / 2);
        this.ioConnectionsController.addOutNode(gateUI.getOutNode());
        this.ioConnectionsController.addInNode(gateUI.getInNodes()[0]);
        this.inputHandler.handleBasicSingleInInput(this.ioConnectionsController, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);


    }
    public void mountBufferNode(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x, y);
        this.ioConnectionsController.addIoNode(gateUI.getOutNode());
        this.inputHandler.handleBufferNode(this.ioConnectionsController, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);
        this.logicalGraph.addBufferNode(gate);


    }
    public void mountInNode(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x, y);
        this.ioConnectionsController.addOutNode(gateUI.getOutNode());
        this.inputHandler.handleBufferNode(ioConnectionsController, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);
        gateUI.getOutNode().node.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY)
            {
                this.logicalGraph.getGraph().getForward(gateUI).update();
                boolean value = gate.process();
                if(value)
                {
                    gateUI.getOutNode().node.setFill(Color.GREEN);
                }
                else
                {
                    gateUI.getOutNode().node.setFill(Color.RED);
                }
            }
        });

    }
}
