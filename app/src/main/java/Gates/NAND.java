package Gates;

public class NAND extends AND {

    public boolean process()
    {
        if(this.in.size() < 2) {
            return false;
        }
        return !super.process();
    }
    
}
