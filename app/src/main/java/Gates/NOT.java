package Gates;

public final class NOT extends BasicGateSingleIn {
        


    public NOT(BasicGate gate)
    {
        in = gate;
    }
    @Override
    public boolean process()
    {
        return !this.in.process();
    }

   


 
}
