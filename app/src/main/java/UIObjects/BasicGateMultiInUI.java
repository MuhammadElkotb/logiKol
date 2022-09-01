package UIObjects;

import javafx.scene.Group;

public abstract class BasicGateMultiInUI extends BasicGateUI {
    
    protected IONode inNode1;
    protected IONode inNode2;

    
    public BasicGateMultiInUI(IONode outNode, IONode inNode1, IONode inNode2)
    {
        super(outNode);
        this.inNode1 = inNode1;
        this.inNode2 = inNode2;

        this.inNode1.setGate(this);
        this.inNode2.setGate(this);

    }

    public void setInNodes(IONode inNode1, IONode inNode2)
    {
        this.inNode1 = inNode1;
        this.inNode2 = inNode2;

    }
    
    public IONode[] getInNode()
    {
        return new IONode[]{this.inNode1, this.inNode2};
    }

    
}