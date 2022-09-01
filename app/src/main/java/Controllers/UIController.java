package Controllers;

import UIObjects.BasicGateUI;
import javafx.scene.Group;
public class UIController {

    private static UIController instance = null;
    private InputHandler inputHandler = null;

    private UIController(InputHandler inputHandler)
    {
        this.inputHandler = inputHandler;
    }
    public static UIController getInstnace(InputHandler inputHandler)
    {
        if(instance == null)
        {
            instance = new UIController(inputHandler);
        }
        return instance;
    }
    
    public void moveGateUI(BasicGateUI gate, double x, double y)
    {
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
    } 

    public void mountBasicMultiInGateUI(Group root, BasicGateUI gate, double x, double y)
    {
        gate.setRoot(root);
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
        
        gate.getInNodes()[0].move(x, y + 14);
        gate.getInNodes()[1].move(x, y + gate.getHeight() - 15);
        this.inputHandler.handleBasicGateMultiInInput(gate);
    }
    public void mountBasicSingleInGateUI(Group root, BasicGateUI gate, double x, double y)
    {
        gate.setRoot(root);
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);

        gate.getInNodes()[0].move(x, y + gate.getHeight() / 2);

        this.inputHandler.handleBasicSingleInInput(gate);

    }
}
