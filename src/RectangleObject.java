import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

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

    public double computeDistance(double cameraX, double cameraY){
        List<Double> lines = new ArrayList<>();
        Line2D L1 = new Line2D.Double(this.coordinatePairs[0][0], this.coordinatePairs[0][1], this.coordinatePairs[0][0], (this.coordinatePairs[0][1] + height));
        Line2D L2 = new Line2D.Double(this.coordinatePairs[0][0], (this.coordinatePairs[0][1] + height), (this.coordinatePairs[0][0] + width), (this.coordinatePairs[0][1] + height));
        Line2D L3 = new Line2D.Double((this.coordinatePairs[0][0] + width), (this.coordinatePairs[0][1] + height), (this.coordinatePairs[0][0] + width), this.coordinatePairs[0][1]);
        Line2D L4 = new Line2D.Double(this.coordinatePairs[0][0], this.coordinatePairs[0][1], (this.coordinatePairs[0][0] + width), this.coordinatePairs[0][1]);
        Double L1Double = L1.ptSegDist(cameraX, cameraY);
        Double L2Double = L2.ptSegDist(cameraX, cameraY);
        Double L3Double = L3.ptSegDist(cameraX, cameraY);
        Double L4Double = L4.ptSegDist(cameraX, cameraY);
        lines.add(L1Double);
        lines.add(L2Double);
        lines.add(L3Double);
        lines.add(L4Double);
        Double distance = L1Double;

//        for(int j = 0; j < lines.size(); j++){
//            System.out.printf("%d: %.2f\n", j, lines.get(j));
//        }


        for(int i = 0; i < lines.size(); i++){
            if (lines.get(i) < distance){
                distance = lines.get(i);
            }
        }
//        System.out.printf("Distance: %.2f\n", distance);
        return distance;
    }

    /*Getters*/
    public Color getColor() {
        return color;
    }
    /*Setters*/
}
