package Gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OR implements BasicGate{

    protected List<BasicGate> in;
    protected boolean value = false;

    public OR()
    {
        this.in = new ArrayList<>();
    }

    public OR(BasicGate... args)
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

        if(processed.contains(this)) return this.value;
        
        if(this.in.size() < 2) 
        {
            this.value = false;
          processed.add(this);

            return false;
        } 
        processed.add(this);

        for(BasicGate arg : this.in)
        {
            if(arg.process(processed))
            {
                this.value = true;

                return true;
            }  
        }
        processed.add(this);
        this.value = false;
        return false;
    }



    public void addIn(BasicGate gate)
    {
        this.in.add(gate);
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
    
    public void update()
    {
        
    }

    public void removeIn(BasicGate gate)
    {
        this.in.remove(gate);
    }

   

    
}
