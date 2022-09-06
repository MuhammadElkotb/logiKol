package UIObjects;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class BufferNode extends BasicGateUI {


    private IONode inNode;
    public BufferNode(IONode node)
    {
        super(node);
        this.inNode = node;
        this.outNode.node.setRadius(10);
    }

    public void move(double x, double y)
    {
        this.outNode.move(x, y);
    }

    public void setRoot(Pane root)
    {
        this.root = root;
        this.outNode.setRoot(root);
    }

    public double getHeight()
    {
        return this.outNode.node.getRadius() * 2;
    }
    public double getWidth()
    {
        return this.getHeight();
    }

    public IONode[] getInNodes()
    {
        return new IONode[]{this.inNode};
    }

    public ImageView getTexture()
    {
        return null;
    }

    public void setOnMouseDragged(EventHandler<MouseEvent> eventHandler)
    {
        this.outNode.setOnMouseDragged(eventHandler);
    }

    public void setOnMouseReleased(EventHandler<MouseEvent> eventHandler)
    {
        this.outNode.setOnMouseReleased(eventHandler);
    }

    public double getX()
    {
        return this.outNode.node.getCenterX();
    }
    public double getY()
    {
        return this.outNode.node.getCenterY();
    }

    public Point2D getPosition()
    {
        return new Point2D(this.outNode.node.getCenterX(), this.outNode.node.getCenterY());
    }
  
}
