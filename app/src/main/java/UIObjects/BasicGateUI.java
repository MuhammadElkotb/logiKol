package UIObjects;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import Gates.BasicGate;
public abstract class BasicGateUI extends MoveAbleUI {

    protected IONode outNode;
    protected BasicGate gate;

    public BasicGateUI(Group root, BasicGate gate, IONode outNode)
    {   
        super(root);
        this.outNode = outNode;
        this.gate = gate;
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

    
}
