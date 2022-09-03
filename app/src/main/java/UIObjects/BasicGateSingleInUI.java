package UIObjects;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class BasicGateSingleInUI extends BasicGateUI {
    
    private IONode inNode;
    private ImageView texture;
    public BasicGateSingleInUI(IONode outNode, IONode inNode, ImageView texture)
    {
        super(outNode);
        this.inNode = inNode;
        this.inNode.setGate(this);
        this.texture = texture;
        this.texture.setSmooth(true);

        
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

    public void setRoot(Pane root)
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

    public void setOnMouseDragged(EventHandler<MouseEvent> eventHandler)
    {
        this.texture.setOnMouseDragged(eventHandler);
    }

    public double getX()
    {
        return this.texture.getX();
    }
    public double getY()
    {
        return this.texture.getY();
    }

    public Point2D getPosition()
    {
        return new Point2D(this.texture.getX(), this.texture.getY());
    }


}
