package UIObjects;
import javafx.scene.Group;
import javafx.scene.image.ImageView;


public class BufferNode extends BasicGateUI {


    private IONode inNode;
    public BufferNode(IONode outNode)
    {
        super(outNode);
        this.inNode = outNode;
        this.outNode.node.setRadius(10);
    }

    public void move(double x, double y)
    {
        this.outNode.move(x, y);
    }


    public void setRoot(Group root)
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

  
}
