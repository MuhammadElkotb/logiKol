package Gates;

import java.util.ArrayList;
import java.util.List;

public class AND implements BasicGate {


    private List<BasicGate> in;
    private boolean processed = false;
    private boolean value = false;

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

    /*public boolean getValue()
    {
        if(this.processed) return value;
        return this.process();
    }*/

    @Override
    public boolean process()
    {
        //if(this.processed) return this.getValue();
        /*if(this.in.size() < 2) {
            this.processed = true;
            this.value = false;
            return false;
        }*/
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

    public void setIn(BasicGate... args)
    {
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

    public void setValue(boolean value)
    {
        
    }

    
  
}



