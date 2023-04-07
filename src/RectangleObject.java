import java.awt.*;

public class RectangleObject extends CollisionObject{

    private final double width;
    private final double height;
    private final Color color;
    private Graphics2D g2d;

    public RectangleObject(double x, double y, double width, double height, Color color) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }



    public void DrawObject(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect((int)this.coordinatePairs[0][0], (int)this.coordinatePairs[0][1], (int)width, (int) height);
    }

    /*Getters*/
    public Color getColor() {
        return color;
    }
    /*Setters*/
}
