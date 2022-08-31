package UIObjects;

import Gates.AND;
import Gates.BasicGate;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class ANDGate extends BasicGateMultiInUI{


    private ImageView texture;
    
    public ANDGate(Group root, BasicGate gate, IONode outNode, IONode inNode1, IONode inNode2, ImageView texture, double x, double y)
    {
        super(root, gate, outNode, inNode1, inNode2);
        this.texture = texture;

        this.texture.setX(x);
        this.texture.setY(y);
;

        System.out.println(this.texture.getFitHeight());
        System.out.println(this.texture.getFitWidth());


        this.outNode.move(x + this.texture.getImage().getWidth() - 1, y + this.texture.getImage().getHeight() / 2 - 5);


        this.inNode1.move(texture.getX() - this.inNode1.node.getWidth(), texture.getY() + 11);
        this.inNode2.move(texture.getX() - this.inNode2.node.getWidth(), texture.getY() + this.texture.getImage().getHeight() - this.inNode2.node.getHeight() - 11);



        this.root.getChildren().addAll(texture);

        texture.setOnMouseDragged(e -> {

            
            texture.setX(e.getSceneX() - texture.getImage().getWidth() / 2);
            texture.setY(e.getSceneY() - texture.getImage().getHeight() / 2);
            this.outNode.move(texture.getX() + this.texture.getImage().getWidth() - 1, 
                                texture.getY() + this.texture.getImage().getHeight() / 2 - 5);

           
            this.inNode1.move(texture.getX() - this.inNode1.node.getWidth(), texture.getY() + 11);
            this.inNode2.move(texture.getX() - this.inNode2.node.getWidth(), texture.getY() + this.texture.getImage().getHeight() - this.inNode2.node.getHeight() - 11);


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
