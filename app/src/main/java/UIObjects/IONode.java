package UIObjects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class IONode {
    public Rectangle node;
    

    public IONode()
    {
        this.node = new Rectangle(8, 8);
        this.node.setFill(Color.BLUE);
    }
    protected void update(double layoutX, double layoutY)
    {
        this.node.setX(layoutX);
        this.node.setY(layoutY);
    } 



}
