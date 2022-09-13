package Controllers;

import java.util.HashSet;
import java.util.Set;

import Gates.BasicGate;
import javafx.scene.paint.Color;

public class Runner {


    private LogicalGraph logicalGraph = null;
    public Runner(LogicalGraph logicalGraph)
    {
        this.logicalGraph = logicalGraph;
    }


    public void run()
    {
        System.out.println(logicalGraph.getBufferNodes());
        Set<BasicGate> processed = new HashSet<>();
        for(BasicGate gate : logicalGraph.getBufferNodes())
        {
            if(!processed.contains(gate))
            {
                boolean value = gate.process(processed);
                processed.add(gate);
                Color color = Color.RED;
                if(value) color = Color.GREEN;
                logicalGraph.getGraph().getBackward(gate).getOutNode().node.setFill(color);
            }
            
        }
    }
    
}
