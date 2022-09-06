package Gates;

import java.util.ArrayList;
import java.util.List;

public class AND implements BasicGate {


    private List<BasicGate> in;

    public AND()
    {
        this.in = new ArrayList<BasicGate>();
    }
    
    public AND(BasicGate... args)
    {
        this.in = new ArrayList<BasicGate>();
        for(BasicGate arg : args)
        {
            this.in.add(arg);
        }
    }

    @Override
    public boolean process()
    {
        if(this.in.size() < 2) {
            return false;
        }
        for(BasicGate arg : this.in)
        {
            if(!arg.process()) {
                return false; 
            }
        }
        return true;
    }

    public void setIn(BasicGate... args)
    {
        this.in.clear();
        for(BasicGate arg : args)
        {
            this.in.add(arg);
        }
    }

    public List<BasicGate> getIn()
    {
        return this.in;
    }

    public void addIn(BasicGate gate)
    {
        this.in.add(gate);
    }

    public void update()
    {
        
    }


    
  
}



