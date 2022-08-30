package UIObjects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class IONode extends MoveAbleUIObject{
    public Rectangle node;

    public IONode()
    {
        this.node = new Rectangle(8, 8);
        this.node.setFill(Color.BLUE);
        this.node.setStroke(Color.BLACK);
    }
    public void move(double x, double y)
    {
        this.node.setX(x);
        this.node.setY(y);
    } 



}
