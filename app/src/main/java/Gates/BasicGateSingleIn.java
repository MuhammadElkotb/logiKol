package Gates;

public abstract class BasicGateSingleIn implements BasicGate{
    protected BasicGate in;
    public void setIn(BasicGate gate)
    {
        this.in = gate;
    }
    public BasicGate getIn()
    {
        return this.in;
    }
}





