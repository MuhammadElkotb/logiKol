package Controllers;

import UIObjects.BasicGateMultiInUI;
import UIObjects.BasicGateUI;

public class UIController {
    
    public static void moveGateUI(BasicGateUI gate, double x, double y)
    {
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
    } 

    public static void moveGateUIMulitIn(BasicGateUI gate, double x, double y)
    {
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
        
        gate.getInNodes()[0].move(x, y + 14);
        gate.getInNodes()[1].move(x, y + gate.getHeight() - 15);
    }
}
