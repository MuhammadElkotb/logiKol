package Gates;

import java.util.Set;

public class NAND extends AND {


    public boolean process(Set<BasicGate> processed)
    {
        if(processed == null) return this.value;

        if(processed.contains(this)){ return this.value; };
        if(this.in.size() < 2) {
            this.value = false;
            return false;
        }
        processed.add(this);
        this.value = !super.process(processed);
        return this.value;
    }
    
}
