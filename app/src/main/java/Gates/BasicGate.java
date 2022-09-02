package Gates;

import java.util.List;

public interface BasicGate {
    public boolean process();
   // public boolean getValue();
    public void setIn(BasicGate... args);
    public List<BasicGate> getIn();
    public void addIn(BasicGate gate);
    public void setValue(boolean value);
}
