package UIObjects;
import Gates.Input;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.event.Event;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import org.checkerframework.checker.units.qual.C;

import Gates.BasicGate;
public class InputObject extends MoveAbleUIObject{

    public Circle circle;
    private Input input;
    private IONode outNode;
    private boolean drag = false;

    public InputObject(Parent root, Input input, double centerX, double centerY)
    {
        this.input = input;
        this.circle = new Circle(centerX, centerY, 15);
        this.circle.setStroke(Color.BLACK);
        this.updateColor();

        this.outNode = new IONode();
        this.outNode.move(this.circle.getCenterX() + this.circle.getRadius(), 
                    this.circle.getCenterY() - (this.outNode.node.getHeight() / 2));
        
        ((Group)root).getChildren().addAll(this.circle, this.outNode.node);  


        this.circle.setOnMouseDragged(e -> {
            this.move(e.getSceneX(), e.getSceneY());
        });

        this.circle.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                this.toggle();
            }
        });

    }

    public void move(double centerX, double centerY)
    {
        this.circle.setCenterX(centerX);
        this.circle.setCenterY(centerY);
        this.outNode.move(centerX + this.circle.getRadius(), centerY - this.outNode.node.getHeight() / 2);
    }

    public void updateColor()
    {
        if(this.input.getValue() == false)
        {
            this.circle.setFill(Color.RED);
        }
        else
        {
            this.circle.setFill(Color.GREEN);
        }
    }
    public void toggle()
    {
        this.input.toggle();
        this.updateColor();
    }
}
