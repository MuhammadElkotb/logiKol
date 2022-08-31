package UIObjects;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.event.Event;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import Gates.BasicGate;


public class InputNode extends BasicGateUI {

    public Circle circle;

    public InputNode(Group root, BasicGate input, IONode outNode, double centerX, double centerY)
    {
        super(root, input, outNode);

        this.circle = new Circle(centerX, centerY, 15);
        this.circle.setStroke(Color.BLACK);
        this.updateColor();

        this.outNode.move(this.circle.getCenterX() + this.circle.getRadius(), 
                    this.circle.getCenterY() - (this.outNode.node.getHeight() / 2));
        

        this.root.getChildren().add(this.circle);  

        this.circle.setOnMouseDragged(e -> {
            this.move(e.getSceneX(), e.getSceneY());
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
        if(this.gate.getValue() == false)
        {
            this.circle.setFill(Color.RED);
        }
        else
        {
            this.circle.setFill(Color.GREEN);
        }
    }


    public void setRoot(Group root)
    {
        this.root = root;
        root.getChildren().add(this.circle);
        this.outNode.setRoot(root);
    }
}
