import java.awt.*;
import java.awt.geom.Point2D;

public class March implements Drawable {

    public double[][] coordinatePairs = new double[10][2];
    private double radius, diameter;

    public March(double x1, double y1, double x2, double y2){
        this.coordinatePairs[0][0] = x1;
        this.coordinatePairs[0][1] = y1;
        this.coordinatePairs[1][0] = x2;
        this.coordinatePairs[1][1] = y2;
        this.radius = Point2D.distance(x1, y1, x2, y2);
        this.diameter = radius * 2;
    }

    public void Draw(Graphics2D g){
        DrawLine(g);
        DrawObject(g);
    }


    public void DrawLine(Graphics2D g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine((int)this.coordinatePairs[0][0], (int)this.coordinatePairs[0][1], (int)this.coordinatePairs[1][0], (int)this.coordinatePairs[1][1]);
    }

    public void DrawObject(Graphics2D g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval((int)((int)this.coordinatePairs[0][0] - radius), (int)((int)this.coordinatePairs[0][1] - radius), (int)this.diameter, (int)this.diameter);
    }

    public double computeDistance(double cameraX, double cameraY) {
        return 0;
    }
}
