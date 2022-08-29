package Gates;

import java.util.ArrayList;
import java.util.List;

public final class OR extends BasicGateMultiIn{


    public OR(BasicGate... args)
    {
        this.in = new ArrayList<BasicGate>();
        for(BasicGate arg : args)
        {
            this.in.add(arg);
        }
    }
    public OR(List<BasicGate> gates)
    {
        this.in = new ArrayList<BasicGate>();
        this.in = gates;
    }
    @Override
    public boolean process()
    {
        for(BasicGate arg : this.in)
        {
            if(arg.process()) return true; 
        }
        return false;
    }

    
}
