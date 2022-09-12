package Gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Input implements BasicGate{
    
    private BasicGate in = null;
    private BasicGate out = null;
    public boolean value;



    public Input()
    {
        this.value = false;
    }
    public Input(boolean value)
    {
        this.value = value;
    }

    public void setValue(boolean value)
    {
        this.value = value;
    }


    public boolean process(Set<BasicGate> processed)
    {
        return this.value;
    }


    public void setIn(BasicGate... args)
    {
        return;
    }
    public List<BasicGate> getIn()
    {
        return new ArrayList<>();
    }

    public void addIn(BasicGate gate)
    {
        return;
    }

    public void setOut(BasicGate gate)
    {
        this.out = gate;
    }

    public BasicGate getOut()
    {
        return this.out;
    }

        
    public void update()
    {
        this.value = !this.value;
    }

    public void removeIn(BasicGate gate)
    {
        return;
    }
}
