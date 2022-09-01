package Controllers;


import UIObjects.BasicGateUI;
import javafx.scene.image.ImageView;

public class InputHandler {


    private static InputHandler instance = null;

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

    public void handleBasicGateMultiInInput(BasicGateUI gate)
    {
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


    public void handleBasicSingleInInput(BasicGateUI gate)
    {
        ImageView texture = gate.getTexture();


        texture.setOnMouseDragged(e -> {
            texture.setX(e.getSceneX() - gate.getWidth() / 2);
            texture.setY(e.getSceneY() - gate.getWidth() / 2);

            gate.getOutNode().move(texture.getX() + gate.getWidth(), texture.getY() + gate.getHeight() / 2 + 0.3);

            gate.getInNodes()[0].move(texture.getX(), texture.getY() + gate.getHeight() / 2);

        });
    }


}
