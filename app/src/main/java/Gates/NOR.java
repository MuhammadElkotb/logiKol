package Gates;

public class NOR extends OR{

    public boolean process()
    {
        if(this.in.size() < 2) {
            return false;
        }
        return !super.process();
    }
    
}
