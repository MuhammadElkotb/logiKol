package UIObjects;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import Gates.BasicGate;
public abstract class BasicGateUIObject extends MoveAbleUIObject {

    protected IONode outNode;
    public BasicGateUIObject(Group root, BasicGate basicGate, IONode outNode)
    {   
        super(root);
        this.outNode = outNode;
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
