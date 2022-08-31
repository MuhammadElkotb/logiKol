package Gates;

public class Input implements BasicGate{
    
    private boolean value;


    public Input(boolean value)
    {
        this.value = value;
    }

    public void setValue(boolean value)
    {
        this.value = value;
    }


    public boolean getValue()
    {
        return this.process();
    }

    public boolean process()
    {
        return this.value;
    }

    
}
