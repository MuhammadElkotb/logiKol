package Gates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class NOT implements BasicGate {


    private List<BasicGate> in = null;
    private boolean value = false;

    public NOT(BasicGate gate)
    {
        in = new ArrayList<>();
        in.add(gate);
    }

    public NOT()
    {
        in = new ArrayList<>();
    }

    @Override
    public boolean process(Set<BasicGate> processed)
    {
        if(processed == null) return this.value;
        if(processed.contains(this)) { return this.value;}
        if(this.in.size() == 0) 
        {
            this.value = false;
            processed.add(this);
            return false;
        }
        processed.add(this);
        boolean out = !this.in.get(0).process(processed);
        this.value = out;
        return out;

    }

    public void setIn(BasicGate... args)
    {
        if(args.length > 0)
        {
            this.in.add(args[0]);
        }
    }

    public List<BasicGate> getIn()
    {
        return this.in;
    }


    public void addIn(BasicGate gate)
    {
        this.in.clear();
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
