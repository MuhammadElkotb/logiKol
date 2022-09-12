package Gates;

import java.util.List;
import java.util.Set;

public interface BasicGate {
    public boolean process(Set<BasicGate> processed);
    public void setIn(BasicGate... args);
    public List<BasicGate> getIn();
    public void addIn(BasicGate gate);
    public void removeIn(BasicGate gate);
    public void update();
}
