package Gates;

import java.util.ArrayList;
import java.util.List;

public class OR implements BasicGate{

    protected List<BasicGate> in;

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
    public boolean process()
    {
        if(this.in.size() < 2) 
        {
            return false;
        } 
        for(BasicGate arg : this.in)
        {
            if(arg.process())
            {
                return true;
            }  
        }
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
