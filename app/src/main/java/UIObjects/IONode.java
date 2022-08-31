package UIObjects;

import javafx.scene.Parent;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class IONode extends MoveAbleUI{
    public Rectangle node;
    private Line lineFromNode = null;
    private boolean dragging = false;
    private BasicGateUI gate;

    public IONode(Group root)
    {

        super(root);

        this.node = new Rectangle(8, 8);
        this.node.setFill(Color.BLUE);
        this.node.setStroke(Color.BLACK);

        this.node.setOnMouseDragged(e -> {

            if(lineFromNode == null)
            {
                lineFromNode = new Line();
                this.root.getChildren().add(lineFromNode);
                
            }
            lineFromNode.setStartX(node.getX());
            lineFromNode.setStartY(node.getY());

            lineFromNode.setEndX(e.getSceneX());
            lineFromNode.setEndY(e.getSceneY());

            this.dragging = true;

        });

        this.node.setOnMouseReleased(e -> {
            if(this.dragging)
            {
                this.root.getChildren().remove(lineFromNode);
                lineFromNode = null;
                this.dragging = false;
            }
        });

        root.getChildren().add(this.node);
    }

    public void move(double x, double y)
    {
        this.node.setX(x);
        this.node.setY(y);
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
}
