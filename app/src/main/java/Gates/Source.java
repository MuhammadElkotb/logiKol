package Gates;

public class Source extends BasicGateSingleIn {

    public Source(BasicGate gate)
    {
        this.in = gate;
    }
    public boolean process()
    {
        return this.in.process();    
    }

 
    
}
