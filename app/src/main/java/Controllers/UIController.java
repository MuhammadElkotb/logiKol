package Controllers;

import UIObjects.BasicGateMultiInUI;
import UIObjects.BasicGateUI;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class UIController {
    
    public static void moveGateUI(BasicGateUI gate, double x, double y)
    {
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
    } 

    public static void mountBasicGateUI(Group root, BasicGateUI gate, double x, double y)
    {
        gate.setRoot(root);
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
        
        gate.getInNodes()[0].move(x, y + 14);
        gate.getInNodes()[1].move(x, y + gate.getHeight() - 15);
        ImageView texture = gate.getTexture();
        texture.setOnMouseDragged(e -> {

            
            texture.setX(e.getSceneX() - gate.getWidth() / 2);
            texture.setY(e.getSceneY() - gate.getHeight() / 2);


            gate.getOutNode().move(texture.getX() + gate.getWidth(), texture.getY() + 
                                gate.getHeight() / 2 + 0.3);

           
            gate.getInNodes()[0].move(texture.getX(), texture.getY() + 14);
            gate.getInNodes()[1].move(texture.getX(), texture.getY() + gate.getHeight() - 15);
        });
    }
}
