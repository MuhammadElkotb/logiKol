package Gates;

public abstract class BasicGate {
    

    protected int nInputs = 2;
    protected int[] input;


    protected final int minNInput = 2;
    protected final int maxNInput = 20;

    protected int ones = 0;
    protected int zeroes = 0;

    public BasicGate (){}

    public BasicGate(int... args) throws Exception
    {
        this.in(args);
    }

    public BasicGate(boolean... args) throws Exception
    {
        this.in(args);
    }



    public BasicGate in(int... args) throws Exception
    {
        if(this.maxNInput >= args.length && this.minNInput <= args.length)
        {
            this.nInputs = args.length;
        }
        else
        {
            throw new Exception("Number of Inputs are out of range");
        }
        input = new int[this.nInputs];
        int ctr = 0;
        ones = 0;
        zeroes = 0;
        for(int arg : args)
        {
            ones += arg;
            zeroes += (arg == 0 ? 1 : 0);
            input[ctr++] = arg;
        }
        return this;
    }
    public BasicGate in(boolean... args) throws Exception
    {
        int[] temp = new int[args.length];

        int ctr = 0;
        for(boolean arg : args)
        {
            int tempArg = arg ? 1 : 0;
            temp[ctr++] = tempArg;
        }
        return this.in(temp);

    }

    public abstract boolean out();
    

}



