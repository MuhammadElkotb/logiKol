package Gates;

import java.util.Set;

public class XNOR extends XOR {

    public boolean process(Set<BasicGate> processed)
    {
        if(processed == null) return this.value;

        if(processed.contains(this)) { return this.value;}
        if(this.in.size() < 2)
        {
            this.value = false;
            processed.add(this);
            return false;
        }
        processed.add(this);
        this.value = !super.process(processed);
        return this.value;
    }
    
}
