package UIObjects;
import Gates.Input;
import javafx.scene.Parent;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import org.checkerframework.checker.units.qual.C;

import Gates.BasicGate;
public class InputObject {
    public Circle circle;
    private BasicGate input;
    private IONode outNode;
    public InputObject(Parent root, BasicGate input, double centerX, double centerY)
    {
        this.input = input;
        this.circle = new Circle(centerX, centerY, 15);
        if(this.input.getValue() == false)
        {
            this.circle.setFill(Color.RED);
        }
        else
        {
            this.circle.setFill(Color.GREEN);
        }

        this.outNode = new IONode();
        this.outNode.move(this.circle.getCenterX() + this.circle.getRadius(), 
                    this.circle.getCenterY() - (this.outNode.node.getHeight() / 2));
        
        ((Group)root).getChildren().addAll(this.circle, this.outNode.node);  



    }

    public void move(double centerX, double centerY)
    {
        this.circle.setCenterX(centerX);
        this.circle.setCenterY(centerY);
        this.outNode.move(centerX + this.circle.getRadius(), centerY - this.outNode.node.getHeight() / 2);
    }
}
