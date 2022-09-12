package Controllers;

import java.util.HashSet;
import java.util.Set;

import Gates.BasicGate;
import UIObjects.BasicGateUI;
import UIObjects.IONode;
import javafx.scene.paint.Color;

public class LogicalGraph {

    private BiMap<BasicGateUI, BasicGate> graph;
    private Set<BasicGate> bufferNodes;
    private Set<BasicGate> inputNodes;
    private Runner runner;
    public LogicalGraph()
    {
        this.graph = new BiMap<>();
        this.bufferNodes = new HashSet<>();
        this.inputNodes = new HashSet<>();
    }

    public LogicalGraph(Runner runner)
    {
        this();
        this.runner = runner;
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

    public void removeGate(BasicGate gate)
    {
        BasicGateUI gateUI = this.graph.getBackward(gate);
        this.graph.deleteBackward(gate);
        this.graph.deleteForward(gateUI);
        this.bufferNodes.remove(gate);
    }

    public void removeGate(BasicGateUI gateUI)
    {
        BasicGate gate = this.graph.getForward(gateUI);
        this.graph.deleteBackward(gate);
        this.graph.deleteForward(gateUI);
        this.bufferNodes.remove(gate);

    }

    public void disconnect(IONode inNode, IONode outNode)
    {
        BasicGate outGate = this.graph.getForward(outNode.getGate());
        BasicGate inGate = this.graph.getForward(inNode.getGate());
        inGate.getIn().remove(outGate);
    }
    public void flipInputValue(BasicGateUI gateUI)
    {
        BasicGate gate = this.graph.getForward(gateUI);
        gate.update();
        boolean value = gate.process(null);
        Color color = Color.RED;
        if(value)
        {
            color = Color.GREEN;
        } 
        gateUI.getOutNode().node.setFill(color);
        this.runner.run();
    }

    public void addBufferNode(BasicGate gate)
    {
        this.bufferNodes.add(gate);
    }

    public void addInputGate(BasicGate gate)
    {
        this.inputNodes.add(gate);
    }
    public Set<BasicGate> getInputNodes()
    {
        return this.inputNodes;
    }

    public Set<BasicGate> getBufferNodes()
    {
        return this.bufferNodes;
    }

    public BiMap<BasicGateUI, BasicGate> getGraph()
    {
        return this.graph;
    }

    public void setRunner(Runner runner)
    {
        this.runner = runner;
    }

}
