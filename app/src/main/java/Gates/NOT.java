package Gates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NOT implements BasicGate {


    private BasicGate in = null;
    private boolean processed = false;
    private boolean value;


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
        /*if(this.processed == true)
        {
            return this.getValue();
        }*/
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

    public void setIn(BasicGate... args)
    {
        if(args.length > 0)
        {
            this.in = args[0];
        }
    }

    public List<BasicGate> getIn()
    {
        return new ArrayList<BasicGate>(Arrays.asList(this.in));
    }

    public void reset()
    {
        this.processed = false;
    }

    public void addIn(BasicGate gate)
    {
        this.in = gate;
    }

    public void setValue(boolean value)
    {
        
    }
}
