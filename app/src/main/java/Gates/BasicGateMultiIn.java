package Gates;

import java.util.List;

public abstract class BasicGateMultiIn implements BasicGate {

    protected boolean processed = false;
    protected boolean value;
    protected List<BasicGate> in;
    
    public void addIn(BasicGate gate)
    {
        this.in.add(gate);
    }
    public void setIn(List<BasicGate> gates)
    {
        this.in = gates;
    }
    public List<BasicGate> getIn()
    {
        return this.in;
    }
    public void reset()
    {
        this.processed = false;
    }
}





