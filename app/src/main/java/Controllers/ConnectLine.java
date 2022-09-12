package Controllers;

import java.util.HashSet;
import java.util.Set;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class ConnectLine {
    

    private Line[] lines;

    private Circle tempCircle;
    private Set<ConnectCircle> connectionCircles;
    private ConnectCircle connectCircle;
    private boolean equalX = false;
    private boolean mainLine = true;


    public ConnectLine()
    {
        this(false, true);
    }
    public ConnectLine(boolean equalX, boolean mainLine)
    {

        lines = new Line[2];
        this.equalX = equalX;
        this.mainLine = mainLine;

        this.tempCircle = new Circle(6.5);
        lines[0] = new Line();
        lines[1] = new Line();

        if(equalX == false)
        {
            lines[0].setOnMouseMoved(e -> {
                this.tempCircle.setCenterX(e.getX());
                this.tempCircle.setCenterY(this.lines[0].getEndY());
                this.tempCircle.setVisible(true);
            });
            
            lines[1].setOnMouseMoved(e -> {
                this.tempCircle.setCenterX(this.lines[1].getEndX());
                this.tempCircle.setCenterY(e.getY());
                this.tempCircle.setVisible(true);
            });
        }
        else
        {
            lines[0].setOnMouseMoved(e -> {
                this.tempCircle.setCenterX(this.lines[0].getEndX());
                this.tempCircle.setCenterY(e.getY());
                this.tempCircle.setVisible(true);
            });
            
            lines[1].setOnMouseMoved(e -> {
                this.tempCircle.setCenterX(e.getX());
                this.tempCircle.setCenterY(this.lines[1].getEndY());
                this.tempCircle.setVisible(true);
            });
        }
        

        lines[0].setOnMouseExited(e -> {
            this.tempCircle.setVisible(false);

        });

        lines[1].setOnMouseExited(e -> {
            this.tempCircle.setVisible(false);

        });


        lines[0].setStrokeWidth(3);
        lines[1].setStrokeWidth(3);

        this.connectionCircles = new HashSet<>();
    }

    public ConnectLine(double x1, double y1, double x2, double y2)
    {
        lines = new Line[2];

        lines[0] = new Line(x1, y1, x2, y1);
        lines[1] = new Line(x2, y1, x2, y2);

        
        lines[0].setStrokeWidth(2.5);
        lines[1].setStrokeWidth(2.5);

    }

    public void setLine(double x1, double y1, double x2, double y2)
    {
        if(this.equalX)
        {
            if(this.connectCircle != null)
            {
                x1 = this.connectCircle.getCircle().getCenterX();
                y1 = this.connectCircle.getCircle().getCenterY();
            }

            lines[0].setStartX(x1);
            lines[0].setStartY(y1);
            lines[0].setEndX(x1);
            lines[0].setEndY(y2);

            lines[1].setStartX(x1);
            lines[1].setStartY(y2);
            lines[1].setEndX(x2);
            lines[1].setEndY(y2);

        }
        else
        {
            if(this.connectCircle != null)
            {
                x1 = this.connectCircle.getCircle().getCenterX();
                y1 = this.connectCircle.getCircle().getCenterY();
            }
            lines[0].setStartX(x1);
            lines[0].setStartY(y1);
            lines[0].setEndX(x2);
            lines[0].setEndY(y1);

            lines[1].setStartX(x2);
            lines[1].setStartY(y1);
            lines[1].setEndX(x2);
            lines[1].setEndY(y2);
        }

        
        
        for(ConnectCircle circle : this.connectionCircles)
        {
            circle.update();
        }
    }

    public void setLine(double x2, double y2)
    {

        if(this.equalX)
        {

            double x1 = this.connectCircle.getCircle().getCenterX();
            double y1 = this.connectCircle.getCircle().getCenterY();

            lines[0].setStartX(x1);
            lines[0].setStartY(y1);
            lines[0].setEndX(x1);
            lines[0].setEndY(y2);

            lines[1].setStartX(x1);
            lines[1].setStartY(y2);
            lines[1].setEndX(x2);
            lines[1].setEndY(y2);
        }
        else
        {   
            
            double x1 = this.connectCircle.getCircle().getCenterX();
            double y1 = this.connectCircle.getCircle().getCenterY();

            lines[0].setStartX(x1);
            lines[0].setStartY(y1);
            lines[0].setEndX(x2);
            lines[0].setEndY(y1);

            lines[1].setStartX(x2);
            lines[1].setStartY(y1);
            lines[1].setEndX(x2);
            lines[1].setEndY(y2);
        }
      
        
        for(ConnectCircle circle : this.connectionCircles)
        {
            circle.update();
        }
    }

    public void setOnMouseClicked(EventHandler<MouseEvent> event)
    {
        this.lines[0].setOnMouseClicked(event);
        this.lines[1].setOnMouseClicked(event);
    }

    public void setOnMouseDragged(EventHandler<MouseEvent> event)
    {
        this.lines[0].setOnMouseDragged(event);
        this.lines[1].setOnMouseDragged(event);
    }

    public void setOnMouseReleased(EventHandler<MouseEvent> event)
    {
        this.lines[0].setOnMouseReleased(event);
        this.lines[1].setOnMouseReleased(event);

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

    public Set<ConnectCircle> getConnectionCircles()
    {
        return this.connectionCircles;
    }

    /*public void addConnectionCircle(int line, double x, double y)
    {
        ConnectCircle circle = new ConnectCircle(this.lines[line], x, y);
        this.connectionCircles.add(circle);
        ((Pane)lines[0].getParent()).getChildren().add(circle.circle);
    }*/
   

   

    public boolean circleAttached()
    {
        return this.connectCircle != null;
    }

    public void setConnectionCircle(ConnectCircle connectCircle)
    {
        this.equalX = !connectCircle.isLineVertical();
        this.connectCircle = connectCircle;
    }

    public ConnectCircle getConnectionCircle()
    {
        return this.connectCircle;
    }


    public void showTempCircle()
    {
        this.tempCircle.setVisible(true);
    }
    
    public void hideTempCircle()
    {
        this.tempCircle.setVisible(false);
    }
 
    public Circle getTempConnectCircle()
    {
        return this.tempCircle;
    }
    public void setEqualXLine(boolean equalX)
    {
        this.equalX = equalX;
    }

    public boolean isMainLine()
    {
        return this.mainLine;
    }
    
}
