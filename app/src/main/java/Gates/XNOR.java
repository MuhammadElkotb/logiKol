package Gates;

public class XNOR extends XOR {

    public boolean process()
    {
        if(this.in.size() < 2)
        {
            return false;
        }
        return !super.process();
    }
    
}
