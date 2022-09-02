package Controllers;

import javafx.scene.shape.Line;

public class ConnectLine {
    

    private Line[] lines;

    public ConnectLine()
    {
        lines = new Line[2];

        lines[0] = new Line();
        lines[1] = new Line();


        lines[0].setStrokeWidth(2);
        lines[1].setStrokeWidth(2);
    }

    public ConnectLine(double x1, double y1, double x2, double y2)
    {
        lines = new Line[2];

        lines[0] = new Line(x1, y1, x2, y1);
        lines[1] = new Line(x2, y1, x2, y2);


    }

    public void setLine(double x1, double y1, double x2, double y2)
    {
        lines[0].setStartX(x1);
        lines[0].setStartY(y1);
        lines[0].setEndX(x2);
        lines[0].setEndY(y1);

        lines[1].setStartX(x2);
        lines[1].setStartY(y1);
        lines[1].setEndX(x2);
        lines[1].setEndY(y2);
    }

    public double getStartX()
    {
        return lines[0].getStartX();
    }    

    public double getStartY()
    {
        return lines[0].getStartY();
    }

    public double getEndX()
    {
        return lines[1].getEndX();
    }

    public double getEndY()
    {
        return lines[1].getEndY();
    }


    public Line[] getLines()
    {
        return lines;
    }

    
}
