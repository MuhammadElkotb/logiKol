package Gates;

import java.util.ArrayList;
import java.util.List;

public class XOR implements BasicGate {



    protected List<BasicGate> in;


    public XOR()
    {
        this.in = new ArrayList<>();
    }
    public XOR(BasicGate... args)
    {
        this.in = new ArrayList<>();
        for(BasicGate arg : args)
        {
            this.in.add(arg);
        }
    }
    @Override
    public boolean process() {
        if(this.in.size() < 2)
        {
            return false;
        }
        int ctr = 0;
        for(BasicGate gate : this.in)
        {
            ctr = ctr + (gate.process() ? 1 : 0);
        }
        if(ctr % 2 == 1) return true;
        return false;
    }

    @Override
    public void setIn(BasicGate... args) {
        this.in.clear();
        for(BasicGate arg : args)
        {
            this.in.add(arg);
        }
    }

    @Override
    public List<BasicGate> getIn() {
        return this.in;
    }

    @Override
    public void addIn(BasicGate gate) {
        this.in.add(gate);
    }

    @Override
    public void update() {
        
    }

    public void removeIn(BasicGate gate)
    {
        this.in.remove(gate);
    }

    
}
