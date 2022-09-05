package Gates;

import java.util.ArrayList;
import java.util.List;

public class Input implements BasicGate{
    
    private BasicGate in = null;
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


    public boolean process()
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

        
    public void update()
    {
        this.value = !this.value;
    }
}
