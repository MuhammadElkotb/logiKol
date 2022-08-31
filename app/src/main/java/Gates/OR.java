package Gates;

import java.util.ArrayList;
import java.util.List;

public final class OR extends BasicGateMultiIn{

    public OR()
    {
        
    }

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

    public boolean getValue()
    {
        if(this.processed) return value;
        return this.process();
    }

    @Override
    public boolean process()
    {

        if(this.processed) return this.getValue();

        if(this.in.size() == 0) 
        {
            this.processed = true;
            this.value = false;
            return false;
        } 
        for(BasicGate arg : this.in)
        {
            if(arg.process())
            {
                this.processed = true;
                this.value = true;
                return true;
            }  
        }
        this.processed = true;
        this.value = false;
        return false;
    }

    
}
