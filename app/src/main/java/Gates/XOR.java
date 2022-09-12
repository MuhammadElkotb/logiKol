package Gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class XOR implements BasicGate {



    protected List<BasicGate> in;
    protected boolean value;

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
    public boolean process(Set<BasicGate> processed) {
        if(processed == null) return this.value;

        if(processed.contains(this)) return this.value;
        if(this.in.size() < 2)
        {
            this.value = false;
            processed.add(this);
            return false;
        }
        int ctr = 0;
        processed.add(this);
        for(BasicGate gate : this.in)
        {
            ctr = ctr + (gate.process(processed) ? 1 : 0);
        }
        if(ctr % 2 == 1){ this.value = true; return true; }
        this.value = false;
        processed.add(this);
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
