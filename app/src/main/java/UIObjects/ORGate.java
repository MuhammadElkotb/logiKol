package UIObjects;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class ORGate extends BasicGateMultiInUI {

    private ImageView texture;

    public ORGate(IONode outNode, IONode inNode1, IONode inNode2, ImageView texture)
    {
        super(outNode, inNode1, inNode2);

        this.texture = texture;

        /*this.outNode.move(x + this.texture.getImage().getWidth(), y + this.texture.getImage().getHeight() / 2 + 0.3);

        this.inNode1.move(x, y + 14);
        this.inNode2.move(x, y + this.texture.getImage().getHeight() - 15);
        

        this.texture.setX(x);
        this.texture.setY(y);*/

        /*texture.setOnMouseDragged(e -> {

            
            texture.setX(e.getSceneX() - texture.getImage().getWidth() / 2);
            texture.setY(e.getSceneY() - texture.getImage().getHeight() / 2);


            this.outNode.move(texture.getX() + this.texture.getImage().getWidth(), texture.getY() + 
                                this.texture.getImage().getHeight() / 2 + 0.3);

           
            this.inNode1.move(this.texture.getX(), this.texture.getY() + 14);
            this.inNode2.move(this.texture.getX(), this.texture.getY() + this.texture.getImage().getHeight() - 15);

        });*/


    }


    public void move(double x, double y)
    {

    }

    public void setRoot(Group root)
    {
        this.root = root;
        this.root.getChildren().add(this.texture);
        this.inNode1.setRoot(root);
        this.inNode2.setRoot(root);
        this.outNode.setRoot(root);
    }
 
}
