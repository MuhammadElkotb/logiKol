package Controllers;

import Providers.GateProvider;
import Providers.UIGateProvider;
import javafx.scene.layout.Pane;

public class GateCreator {
    private GateMounter gateMounter;
    private UIGateProvider uiGateProvider;
    private GateProvider gateProvider;
    public GateCreator(GateMounter gateMounter, UIGateProvider uiGateProvider, GateProvider gateProvider)
    {
        this.gateMounter = gateMounter;
        this.gateProvider = gateProvider;
        this.uiGateProvider = uiGateProvider;
    }
    public void createGate(String gate, Pane root, double x, double y)
    {
        System.out.println(gate);
        try {
            gateMounter.mouneGate(gate, root, uiGateProvider.buildGate(gate), gateProvider.buildGate(gate), x, y);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
