package Controllers;

import Gates.BasicGate;
import UIObjects.BasicGateUI;
import javafx.scene.layout.Pane;


public class GateMounter {

    private InputHandler inputHandler = null;
    private IOConnectionsController ioConnectionsController = null;
    private LogicalGraph logicalGraph = null;

    
    public GateMounter(InputHandler inputHandler, IOConnectionsController ioConnectionsController, LogicalGraph logicalGraph)
    {
        this.inputHandler = inputHandler;
        this.ioConnectionsController = ioConnectionsController;
        this.logicalGraph = logicalGraph;

    }
   
    
    public void moveGateUI(BasicGateUI gate, double x, double y)
    {
        gate.move(x, y);
        gate.getOutNode().move(x + gate.getWidth(), y + gate.getHeight() / 2 + 0.3);
    } 

    public void mouneGate(String gateId, Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        if(gateId.toLowerCase().equals("g-and")) this.mountBasicMultiInGateUI(root, gateUI, gate, x, y);
        if(gateId.toLowerCase().equals("g-or")) this.mountBasicMultiInGateUI(root, gateUI, gate, x, y);
        if(gateId.toLowerCase().equals("g-not")) this.mountBasicSingleInGateUI(root, gateUI, gate, x, y);
        if(gateId.toLowerCase().equals("g-in")) this.mountInNode(root, gateUI, gate, x, y);
        if(gateId.toLowerCase().equals("g-xor")) this.mountBasicMultiInGateUI(root, gateUI, gate, x, y);
        if(gateId.toLowerCase().equals("g-nand")) this.mountBasicMultiInGateUI(root, gateUI, gate, x, y);
        if(gateId.toLowerCase().equals("g-nor")) this.mountBasicMultiInGateUI(root, gateUI, gate, x, y);
        if(gateId.toLowerCase().equals("g-out")) this.mountBufferNode(root, gateUI, gate, x, y);
        
    }
    private void mountBasicMultiInGateUI(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x + gateUI.getWidth(), y + gateUI.getHeight() / 2 + 0.3);
        
        gateUI.getInNodes()[0].move(x, y + 14);
        gateUI.getInNodes()[1].move(x, y + gateUI.getHeight() - 15);

        this.ioConnectionsController.addOutNode(gateUI.getOutNode());
        this.ioConnectionsController.addInNode(gateUI.getInNodes()[0]);
        this.ioConnectionsController.addInNode(gateUI.getInNodes()[1]);
        this.inputHandler.handleBasicGateMultiInInput(this.ioConnectionsController, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);
    }
    private void mountBasicSingleInGateUI(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x + gateUI.getWidth(), y + gateUI.getHeight() / 2 + 0.3);

        gateUI.getInNodes()[0].move(x, y + gateUI.getHeight() / 2);
        this.ioConnectionsController.addOutNode(gateUI.getOutNode());
        this.ioConnectionsController.addInNode(gateUI.getInNodes()[0]);
        this.inputHandler.handleBasicSingleInInput(this.ioConnectionsController, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);


    }
    private void mountBufferNode(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x, y);
        this.ioConnectionsController.addIoNode(gateUI.getOutNode());
        this.inputHandler.handleBufferNode(this.ioConnectionsController, this.logicalGraph, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);
        this.logicalGraph.addBufferNode(gate);

    }
    private void mountInNode(Pane root, BasicGateUI gateUI, BasicGate gate, double x, double y)
    {
        gateUI.setRoot(root);
        gateUI.move(x, y);
        gateUI.getOutNode().move(x, y);
        this.ioConnectionsController.addOutNode(gateUI.getOutNode());
        this.inputHandler.handleBufferNode(ioConnectionsController, this.logicalGraph, gateUI);
        this.logicalGraph.pairGate(gateUI, gate);
        this.logicalGraph.addInputGate(gate);
        
    }
}
