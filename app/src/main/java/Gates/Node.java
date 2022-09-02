package Gates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node implements BasicGate {

    private boolean processed = false;
    private boolean value = false; 
    private BasicGate in;
    public Node(){

    }
    public Node(BasicGate gate)
    {
        this.in = gate;
    }

   /*  public boolean getValue()
    {
        if(this.processed == true) return this.value;
        return this.process();
    }*/
    public boolean process()
    {
        if(this.in == null) {
            this.processed = true;
            this.value = false;
            return false;
        }
        boolean out = this.in.process();
        this.processed = true;
        this.value = out;
        return out;    
    }

    public void setIn(BasicGate... args)
    {
        if(args.length > 0)
        {
            this.in = args[0];
        }
    }

    public List<BasicGate> getIn()
    {
        return new ArrayList<BasicGate>(Arrays.asList(this.in));
    }
    public void addIn(BasicGate gate)
    {
        this.in = gate;
    }

    public void setValue(boolean value)
    {
        
    }

}
