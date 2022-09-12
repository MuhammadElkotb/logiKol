package Controllers;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class ConnectCircle {

    private Circle circle;
    private double lineRatio;
    private Line line;
    private boolean vertical = false;
    private int lineNumber;
    
    public ConnectCircle(Line line, int lineNumber, double x, double y)
    {
        this.circle = new Circle(x, y, 6.5);
        this.line = line;
        this.lineNumber = lineNumber;
        
        if(line.getStartX() == line.getEndX())
        {
            this.vertical = true;
            double lineLength = line.getEndY() - line.getStartY();
            this.lineRatio = (y - line.getStartY()) / lineLength;


        }
        if(line.getStartY() == line.getEndY())
        {
            this.vertical = false;
            double lineLength = line.getEndX() - line.getStartX();
            this.lineRatio = (x - line.getStartX()) / lineLength;
        
        }

    }

    public void update()
    {

        if(line.getStartX() == line.getEndX())
        {
            this.circle.setCenterY(lineRatio * (line.getEndY() - line.getStartY()) + line.getStartY());
            this.circle.setCenterX(line.getStartX());

        

        }
        if(line.getStartY() == line.getEndY())
        {
            this.circle.setCenterX(lineRatio * (line.getEndX() - line.getStartX()) + line.getStartX());
            this.circle.setCenterY(line.getStartY());

          
        }

    }

    protected void setLineRatio()
    {

    }

    public Circle getCircle()
    {
        return this.circle;
    }

    public int getLineNumber()
    {
        return this.lineNumber;
    }

    public boolean isLineVertical()
    {
        return this.vertical;
    }

}
