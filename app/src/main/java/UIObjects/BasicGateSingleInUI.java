package UIObjects;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class BasicGateSingleInUI extends BasicGateUI {
    
    private IONode inNode;
    private ImageView texture;
    public BasicGateSingleInUI(IONode outNode, IONode inNode, ImageView texture)
    {
        super(outNode);
        this.inNode = inNode;
        this.inNode.setGate(this);
        this.texture = texture;
        
    }


    public void move(double x, double y) {
        this.texture.setX(x);
        this.texture.setY(y);
    }

    public void setInNode(IONode inNode)
    {
        this.inNode = inNode;
    }
    
    public IONode[] getInNodes()
    {
        return new IONode[]{this.inNode};
    }

    public void setRoot(Group root)
    {
        this.root = root;
        this.root.getChildren().add(this.texture);
        System.out.println("set root");

        this.inNode.setRoot(root);
        this.outNode.setRoot(root);
    }

    public double getWidth()
    {
        return this.texture.getImage().getWidth();
    }
    public double getHeight()
    {
        return this.texture.getImage().getHeight();
    }


    public ImageView getTexture()
    {
        return this.texture;
    }


}
