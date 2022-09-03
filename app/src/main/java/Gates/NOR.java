package Gates;

public class NOR extends OR{

    public boolean process()
    {
        return !super.process();
    }
    
}
