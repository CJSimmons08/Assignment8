import java.awt.*;

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
        g2d.fillOval((int)this.coordinatePairs[0][0] - (int)(diameter/2), (int)this.coordinatePairs[0][1] - (int)(diameter/2), (int)diameter, (int)diameter);
    }


    public double computeDistance(double cameraX, double cameraY){
        return Math.sqrt(Math.pow((cameraX - this.coordinatePairs[0][0]), 2) + Math.pow((cameraY - this.coordinatePairs[0][1]), 2)) - (diameter/2);
    }

    /*Getters*/
    public double getCoordinatePairs(int x, int y) {
        return coordinatePairs[x][y];
    }
}
