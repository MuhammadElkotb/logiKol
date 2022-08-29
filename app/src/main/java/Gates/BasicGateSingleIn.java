package Gates;

public abstract class BasicGateSingleIn implements BasicGate{

    protected boolean processed = false;
    protected boolean value;

    protected BasicGate in = null;
    public void setIn(BasicGate gate)
    {
        this.in = gate;
    }
    public BasicGate getIn()
    {
        return this.in;
    }
    public void reset()
    {
        this.processed = false;
    }
}





