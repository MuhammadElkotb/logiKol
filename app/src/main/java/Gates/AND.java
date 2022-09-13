package Gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AND implements BasicGate {


    protected List<BasicGate> in;
    protected boolean value = false;
    protected boolean prevValue;
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
    public boolean process(Set<BasicGate> processed)
    {
        if(processed == null) return this.value;
        if(processed.contains(this)) 
        {
            System.out.println("Processed"); return this.value;
        }
        if(this.in.size() < 2) {
            processed.add(this);
            this.value = false;
            return false;
        }
        System.out.println("Processing");
        processed.add(this);
        for(BasicGate arg : this.in)
        {
            if(!arg.process(processed)) {
                this.value = false;
                return false; 
            }
        }
        processed.add(this);
        this.value = true;
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

    public void removeIn(BasicGate gate)
    {
        this.in.remove(gate);
    }


    
  
}



