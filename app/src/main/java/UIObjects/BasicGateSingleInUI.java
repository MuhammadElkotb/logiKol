package UIObjects;

import Gates.BasicGate;
import javafx.scene.Group;

public abstract class BasicGateSingleInUI extends BasicGateUI {
    
    private IONode inNode;
    public BasicGateSingleInUI(Group root, BasicGate gate, IONode outNode, IONode inNode)
    {
        super(root, gate, outNode);
        this.inNode = inNode;
        this.inNode.setGate(this);
        
    }

    public void setInNode(IONode inNode)
    {
        this.inNode = inNode;
    }
    
    public IONode getInNode()
    {
        return this.inNode;
    }
}
