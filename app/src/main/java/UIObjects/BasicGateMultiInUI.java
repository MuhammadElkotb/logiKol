package UIObjects;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class BasicGateMultiInUI extends BasicGateUI {
    
    protected IONode inNode1;
    protected IONode inNode2;
    private ImageView texture;

    
    public BasicGateMultiInUI(IONode outNode, IONode inNode1, IONode inNode2, ImageView texture)
    {
        super(outNode);
        this.inNode1 = inNode1;
        this.inNode2 = inNode2;

        this.inNode1.setGate(this);
        this.inNode2.setGate(this);

        this.texture = texture;

        this.texture.setSmooth(true);

    }

    public void setInNodes(IONode inNode1, IONode inNode2)
    {
        this.inNode1 = inNode1;
        this.inNode2 = inNode2;

    }
    
    public IONode[] getInNodes()
    {
        return new IONode[]{this.inNode1, this.inNode2};
    }

    public void move(double x, double y)
    {
        this.texture.setX(x);
        this.texture.setY(y);
    }

    public void setRoot(Pane root)
    {
        this.root = root;
        this.root.getChildren().add(this.texture);
        this.inNode1.setRoot(root);
        this.inNode2.setRoot(root);
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