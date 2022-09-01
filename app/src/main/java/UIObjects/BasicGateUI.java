package UIObjects;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import Gates.BasicGate;
public abstract class BasicGateUI extends MoveAbleUI {

    protected IONode outNode;

    public BasicGateUI(IONode outNode)
    {   
        this.outNode = outNode;
        this.outNode.setGate(this);
    }
    public void setOutNode(IONode outNode)
    {
        this.outNode = outNode;
    }
    public IONode getOutNode()
    {
        return this.outNode;
    }

    public abstract IONode[] getInNodes();

    public abstract double getHeight();
    public abstract double getWidth();

    
}
