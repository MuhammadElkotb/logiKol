package Gates;

import java.util.ArrayList;
import java.util.List;

public class Node implements BasicGate {

    private List<BasicGate> in;
    public Node()
    {
        this.in = new ArrayList<>();
    }
    public Node(BasicGate gate)
    {
        this.in = new ArrayList<>();
        this.in.add(gate);
    }

   
    public boolean process()
    {
        if(this.in.size() == 0) {
            return false;
        }
        boolean out = this.in.get(0).process();
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
