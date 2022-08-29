package Gates;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


public final class CompoundGate extends BasicGateMultiIn {



    private String name;
    private List<BasicGate> gates;
    private Map<Integer, BasicGate> gatesNamesMap;
    private Map<Integer, List<Integer>> gatesGraph;

    public CompoundGate(String name)
    {
        this.name = name;
        this.gates = new ArrayList<BasicGate>();
        this.gatesNamesMap = new HashMap<Integer, BasicGate>();
        this.gatesGraph = new HashMap<Integer, List<Integer>>();
    }
    public void addGate(BasicGate gate)
    {
        this.gates.add(gate);
    }

    public void addAllGates(BasicGate... args)
    {
        this.gates.addAll(Arrays.asList(args));
        int ctr = 1;
        for(BasicGate arg : args) 
        {
            this.gatesNamesMap.put(ctr++, arg);
        }
    }
    @Override
    public boolean process() {
        return false;
    }

    public boolean getValue()
    {
        return false;
    }

   



    
    
}