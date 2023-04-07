import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleObject extends CollisionObject{

    private double diameter, x, y;
    private final Color color;

    public CircleObject(double x, double y, double diameter, Color color) {
        super(x, y);
        this.diameter = diameter;
        this.color = color;
    }

    public void DrawObject(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval((int)this.coordinatePairs[0][0], (int)this.coordinatePairs[0][1], (int)diameter, (int)diameter);
    }

}
