package Gates;

import java.util.ArrayList;
import java.util.List;

public final class AND extends BasicGateMultiIn {


    public AND()
    {
    }
    
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

    public boolean getValue()
    {
        if(this.processed) return value;
        return this.process();
    }

    @Override
    public boolean process()
    {
        if(this.processed) return this.getValue();
        if(this.in.size() < 2) {
            this.processed = true;
            this.value = false;
            return false;
        }
        for(BasicGate arg : this.in)
        {
            if(!arg.process()) {
                this.processed = true;
                this.value = false;
                return false; 
            }
        }
        this.processed = true;
        this.value = true;
        return true;
    }
    
  
}



