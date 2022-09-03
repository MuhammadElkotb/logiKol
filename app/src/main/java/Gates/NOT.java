package Gates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NOT implements BasicGate {


    private BasicGate in = null;

    public NOT(BasicGate gate)
    {
        in = gate;
    }

    public NOT()
    {
    }

    @Override
    public boolean process()
    {
     
        if(this.in == null) 
        {
            return false;
        }
        boolean out = !this.in.process();
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


    public void addIn(BasicGate gate)
    {
        this.in = gate;
    }

    public void update()
    {
        
    }

    
}
