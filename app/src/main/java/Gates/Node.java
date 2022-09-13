package Gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Node implements BasicGate {

    private List<BasicGate> in;
    private boolean value = false;
    public Node()
    {
        this.in = new ArrayList<>();
    }
    public Node(BasicGate gate)
    {
        this.in = new ArrayList<>();
        this.in.add(gate);
    }

   
    public boolean process(Set<BasicGate> processed)
    {
        if(processed == null) return this.value;

        if(processed.contains(this)){return this.value;}
         if(this.in.size() == 0) {
            this.value = false;
            processed.add(this);
            return false;
        }
        processed.add(this);
        boolean out = this.in.get(0).process(processed);
        this.value = out;
        return out;    
    }

    public void setIn(BasicGate... args)
    {
        if(args.length > 0)
        {
            this.in.clear();
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
