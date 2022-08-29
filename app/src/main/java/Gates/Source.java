package Gates;

public class Source extends BasicGateSingleIn {

    public Source(BasicGate gate)
    {
        this.in = gate;
    }

    public boolean getValue()
    {
        if(this.processed == true) return this.value;
        return this.process();
    }
    public boolean process()
    {
        if(this.in == null) {
            this.processed = true;
            this.value = false;
            return false;
        }
        boolean out = this.in.process();
        this.processed = true;
        this.value = out;
        return out;    
    }
    
}
