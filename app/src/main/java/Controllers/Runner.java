package Controllers;

import Gates.BasicGate;
import javafx.scene.paint.Color;

public class Runner {


    private static Runner instance = null;
    private LogicalGraph logicalGraph = null;

    private Runner(LogicalGraph logicalGraph)
    {
        this.logicalGraph = logicalGraph;
    }

    public static Runner getInstance(LogicalGraph logicalGraph)
    {
        if(instance == null) instance = new Runner(logicalGraph);
        return instance;
    }
    public void run()
    {
        System.out.println("run");
        for(BasicGate gate : logicalGraph.getBufferNodes())
        {
            System.out.println("xrunwandansdnasdsd");
            boolean value = gate.process();
            Color color = Color.RED;
            if(value) color = Color.GREEN;
            logicalGraph.getGraph().getBackward(gate).getOutNode().node.setFill(color);
        }
    }
    
}
