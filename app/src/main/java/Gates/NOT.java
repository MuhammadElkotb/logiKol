package Gates;

public class NOT {

    private final int maxNInput = 1;
    private final int minNInput = 1;
    private final int nInputs = 1;
    private int input = 0;
    public NOT in(int input) throws Exception
    {
        this.input = input;
        return this;

    }

    public NOT in(boolean input) throws Exception
    {
        return this.in(input ? 1 : 0);
    }
    public boolean out()
    {
        return (input == 1 ? false : true);
    }


    
}
