package UIObjects;

import javafx.scene.Parent;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class IONode extends MoveAbleUI {

    public Circle node;
    private Line lineFromNode = null;
    private boolean dragging = false;
    private BasicGateUI gate;

    public IONode()
    {


        this.node = new Circle(7);
        this.node.setFill(Color.WHITE);
        this.node.setStroke(Color.BLACK);
        this.node.setStrokeWidth(3);

        /*this.node.setOnMouseDragged(e -> {

            if(lineFromNode == null)
            {
                lineFromNode = new Line();
                lineFromNode.setStrokeWidth(2.5);
                
            }
            lineFromNode.setStartX(node.getCenterX());
            lineFromNode.setStartY(node.getCenterY());

            lineFromNode.setEndX(e.getSceneX());
            lineFromNode.setEndY(e.getSceneY());

            this.dragging = true;

        });*/

        /*this.node.setOnMouseReleased(e -> {
            if(this.dragging)
            {
                this.root.getChildren().remove(lineFromNode);
                lineFromNode = null;
                this.dragging = false;
            }
        });*/

    }

    public void move(double x, double y)
    {
        this.node.setCenterX(x);
        this.node.setCenterY(y);
    } 

    public void setRoot(Group root)
    {
        this.root = root;
        this.root.getChildren().add(this.node);
    }


    public void setGate(BasicGateUI gate)
    {
        this.gate = gate;
    }

    public BasicGateUI getGate()
    {
        return this.gate;
    }

    public double getHeight()
    {
        return this.node.getRadius() * 2;
    }

    public double getWidth()
    {
        return this.node.getRadius() * 2;
    }
   
}
