package Gates;

public class AND extends BasicGate {

    public AND(){}

    public AND(int... args) throws Exception
    {
        super(args);
    }

    public AND(boolean... args) throws Exception
    {
        super(args);
    }
    public boolean out()
    {
        return this.zeroes <= 0;
    }
}



