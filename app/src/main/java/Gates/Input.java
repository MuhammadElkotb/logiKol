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
    public boolean toggle()
    {
        this.value = !this.value;
        return this.value;
    }
    public boolean process()
    {
        return this.value;
    }
    
}
