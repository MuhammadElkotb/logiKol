package Gates;

import java.util.ArrayList;
import java.util.List;

public final class AND extends BasicGateMultiIn {


    
    public AND(BasicGate... args)
    {
        this.in = new ArrayList<BasicGate>();
        for(BasicGate arg : args)
        {
            this.in.add(arg);
        }
    }
    public AND(List<BasicGate> gates)
    {
        this.in = new ArrayList<BasicGate>();
        this.in = gates;
    }
    @Override
    public boolean process()
    {
        for(BasicGate arg : this.in)
        {
            if(!arg.process()) return false; 
        }
        return true;
    }
    
}



