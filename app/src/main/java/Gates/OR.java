package Gates;

public class OR extends BasicGate{

    public OR(){}
    public OR(int... args) throws Exception
    {
        super(args);
    }

    public OR(boolean... args) throws Exception
    {
        super(args);
    }
    public boolean out()
    {
        return this.ones > 0;
    }
}
