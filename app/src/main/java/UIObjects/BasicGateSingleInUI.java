package UIObjects;

import javafx.scene.Group;

public abstract class BasicGateSingleInUI extends BasicGateUI {
    
    private IONode inNode;
    public BasicGateSingleInUI(IONode outNode, IONode inNode)
    {
        super(outNode);
        this.inNode = inNode;
        this.inNode.setGate(this);
        
    }

    public void setInNode(IONode inNode)
    {
        this.inNode = inNode;
    }
    
    public IONode[] getInNodes()
    {
        return new IONode[]{this.inNode};
    }
}
