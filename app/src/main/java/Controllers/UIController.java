package Controllers;

import UIObjects.BasicGateUI;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
public class UIController {

    private static UIController instance = null;
    private InputHandler inputHandler = null;
    private IOConnectionsController ioConnectionsController = null;

    
    private UIController(InputHandler inputHandler, IOConnectionsController ioConnectionsController)
    {
        this.inputHandler = inputHandler;
        this.ioConnectionsController = ioConnectionsController;

    }
    public static UIController getInstnace(InputHandler inputHandler, IOConnectionsController ioConnectionsController)
    {
        if(instance == null)
        {
            instance = new UIController(inputHandler, ioConnectionsController);
        }
        return instance;
    }
    
    public void moveGateUI(BasicGateUI gate, double x, double y)
    {
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
    } 

    public void mountBasicMultiInGateUI(Pane root, BasicGateUI gate, double x, double y)
    {
        gate.setRoot(root);
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
        
        gate.getInNodes()[0].move(x, y + 14);
        gate.getInNodes()[1].move(x, y + gate.getHeight() - 15);

        this.inputHandler.handleIOConnection(this.ioConnectionsController, gate);
        this.ioConnectionsController.getOutNodes().add(gate.getOutNode());
        this.ioConnectionsController.getInNodes().add(gate.getInNodes()[0]);
        this.ioConnectionsController.getInNodes().add(gate.getInNodes()[1]);
        this.inputHandler.handleBasicGateMultiInInput(this.ioConnectionsController, gate);
    }
    public void mountBasicSingleInGateUI(Pane root, BasicGateUI gate, double x, double y)
    {
        gate.setRoot(root);
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);

        gate.getInNodes()[0].move(x, y + gate.getHeight() / 2);
        this.inputHandler.handleIOConnection(this.ioConnectionsController, gate);

        this.ioConnectionsController.getOutNodes().add(gate.getOutNode());
        this.ioConnectionsController.getInNodes().add(gate.getInNodes()[0]);
        this.inputHandler.handleBasicSingleInInput(this.ioConnectionsController, gate);

    }
    public void mountBufferNode(Pane root, BasicGateUI gate, double x, double y)
    {
        gate.setRoot(root);
        gate.move(x, y);
        gate.getOutNode().move(x, y);
        this.inputHandler.handleIOConnection(this.ioConnectionsController, gate);

        this.ioConnectionsController.getOutNodes().add(gate.getOutNode());
        this.inputHandler.handleBufferNode(this.ioConnectionsController, gate);

    }
}
