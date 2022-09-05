package UIObjects;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class IONode extends MoveAbleUI {

    public Circle node;
    private BasicGateUI gate;
    public IONode()
    {
        this.node = new Circle(7);
        this.node.setFill(Color.WHITE);
        this.node.setStroke(Color.BLACK);
        this.node.setStrokeWidth(3);
        this.node.setSmooth(true);
    }

    public void move(double x, double y)
    {
        this.node.setCenterX(x);
        this.node.setCenterY(y);
    } 

    public void setRoot(Pane root)
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

    public void setClassName(String className)
    {
        this.node.getStyleClass().addAll(className);
    }

    public void setOnMouseDragged(EventHandler<MouseEvent> eventHandler)
    {
        this.node.setOnMouseDragged(eventHandler);
    }


    public void setOnMouseReleased(EventHandler<MouseEvent> eventHandler)
    {
        this.node.setOnMouseReleased(eventHandler);
    }



    public double getX()
    {
        return this.node.getCenterX();
    }
    public double getY()
    {
        return this.node.getCenterY();
    }

    public Point2D getPosition()
    {
        return new Point2D(this.node.getCenterX(), this.node.getCenterY());
    }


   
}
