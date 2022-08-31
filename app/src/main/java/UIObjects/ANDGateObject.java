package UIObjects;

import Gates.AND;
import Gates.BasicGate;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class ANDGateObject extends BasicGateUIObject{


    private ImageView texture;
    private BasicGate gate;
    private IONode[] inNodes;
    public ANDGateObject(Group root, BasicGate gate, IONode outNode, ImageView texture, double x, double y)
    {
        super(root, outNode);
        this.gate = gate;
        this.texture = texture;

        this.texture.setX(x);
        this.texture.setY(y);

        this.outNode.move(x + this.texture.getImage().getWidth() - 1, y + this.texture.getImage().getHeight() / 2 - 5);

        
        this.inNodes = new IONode[2];
        this.inNodes[0] = new IONode(root);
        this.inNodes[1] = new IONode(root);

        this.inNodes[0].move(texture.getX() - this.inNodes[0].node.getWidth(), texture.getY() + 11);
        this.inNodes[1].move(texture.getX() - this.inNodes[1].node.getWidth(), texture.getY() + this.texture.getImage().getHeight() - this.inNodes[1].node.getHeight() - 11);



        this.root.getChildren().addAll(texture);

        texture.setOnMouseDragged(e -> {
            texture.setX(e.getSceneX() - texture.getImage().getWidth() / 2);
            texture.setY(e.getSceneY() - texture.getImage().getHeight() / 2);
            this.outNode.move(texture.getX() + this.texture.getImage().getWidth() - 1, 
                                texture.getY() + this.texture.getImage().getHeight() / 2 - 5);

            this.inNodes[0].move(texture.getX() - this.inNodes[0].node.getWidth(), texture.getY() + 11);
            this.inNodes[1].move(texture.getX() - this.inNodes[1].node.getWidth(), texture.getY() + this.texture.getImage().getHeight() - this.inNodes[1].node.getHeight() - 11);
        });

    }
    public void move(double x, double y)
    {

    }

    public void setRoot(Group root)
    {
        this.root = root;
        this.root.getChildren().add(root);
    }

}
