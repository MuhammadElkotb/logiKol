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

    public InputNode(IONode outNode, double centerX, double centerY)
    {
        super(outNode);

        this.circle = new Circle(centerX, centerY, 15);
        this.circle.setStroke(Color.RED);

        this.outNode.move(this.circle.getCenterX() + this.circle.getRadius(), 
                    this.circle.getCenterY() - (this.circle.getRadius() / 2));
        


        this.circle.setOnMouseDragged(e -> {
            this.move(e.getSceneX(), e.getSceneY());
        });

  
    }

    public void move(double centerX, double centerY)
    {
        this.circle.setCenterX(centerX);
        this.circle.setCenterY(centerY);
        this.outNode.move(centerX + this.circle.getRadius(), centerY - this.circle.getRadius() / 2);
    }



    public void setRoot(Group root)
    {
        this.root = root;
        root.getChildren().add(this.circle);
        this.outNode.setRoot(root);
    }

  
}
