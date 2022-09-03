package Gates;

public class NAND extends AND {

    public boolean process()
    {
        return !super.process();
    }
    
}
