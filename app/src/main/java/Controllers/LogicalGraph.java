package Controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Gates.BasicGate;
import UIObjects.BasicGateUI;
import UIObjects.IONode;

public class LogicalGraph {

    private BiMap<BasicGateUI, BasicGate> graph;
    private Set<BasicGate> bufferNodes;

    public LogicalGraph()
    {
        this.graph = new BiMap<>();
        this.bufferNodes = new HashSet<>();
    }

    public void pairGate(BasicGateUI gateUI, BasicGate gate)
    {
        this.graph.put(gateUI, gate);
    }
    public void connect(IONode outNode, IONode inNode)
    {
        BasicGate outGate = this.graph.getForward(outNode.getGate());
        BasicGate inGate = this.graph.getForward(inNode.getGate());

        inGate.addIn(outGate);

    }

    public void addBufferNode(BasicGate gate)
    {
        this.bufferNodes.add(gate);
    }

    public Set<BasicGate> getBufferNodes()
    {
        return this.bufferNodes;
    }

    public BiMap<BasicGateUI, BasicGate> getGraph()
    {
        return this.graph;
    }

}
