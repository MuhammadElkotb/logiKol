package Gates;

public final class NOT extends BasicGateSingleIn {


    public NOT(BasicGate gate)
    {
        in = gate;
    }

    public NOT()
    {
    }

    public boolean getValue()
    {
        if(this.processed) return value;
        return this.process();
    }
    @Override
    public boolean process()
    {
        if(this.processed == true)
        {
            return this.getValue();
        }
        if(this.in == null) 
        {
            this.processed = true;
            this.value = false;
            return false;
        }
        this.processed = true;
        boolean out = !this.in.process();
        this.value = out;
        return out;

    }

   
}
