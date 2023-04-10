import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JPanel;

/**
 * Displays and updates the logic for the top-down raymarcher.
 */
public class RaymarcherPanel extends JPanel { 
    
    /**
     * We need to keep a reference to the parent swing app for sizing and 
     * other bookkeeping.
     */
    private final RaymarcherRunner raymarcherRunner;
    public List<CollisionObject> shapes;


    private Camera camera;

    public void populateList(){
        RectangleObject rectangle1 = new RectangleObject(15, 15, 50, 75, Color.BLUE);
        RectangleObject rectangle2 = new RectangleObject(200, 200, 75, 50, Color.GREEN);
        CircleObject circle1 = new CircleObject(400, 400, 60, Color.BLACK);
        CircleObject circle2 = new CircleObject(150, 500, 35, Color.CYAN);
        shapes.add(rectangle1);
        shapes.add(rectangle2);
        shapes.add(circle1);
        shapes.add(circle2);
    }


//    public void drawShapes(){
//        for (int i = 0; i < shapes.size(); i++) {
//            Graphics2D g2d = new Graphics2D();
//            shapes.get(i).DrawObject(g2d);
//        }
//    }
    
    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.shapes = new ArrayList<>();
        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getWidth(),
                this.raymarcherRunner.getFrame().getHeight()));
        this.camera = new Camera(0, 0, Color.RED);
        addMouseMotionListener(camera);
        addMouseListener(camera);
    }

    ArrayList<March> march(){
        ArrayList<March> marches = new ArrayList<>();
        double[] originPoint = new double[]{camera.getCoordinatePairs(0, 0), camera.getCoordinatePairs(0, 1)};
        double smallestDistance = Double.POSITIVE_INFINITY;
        while(smallestDistance > 0.01){
            smallestDistance = Double.POSITIVE_INFINITY;
            for (int i = 0; i < shapes.size(); i++) {
                double distance = (shapes.get(i).computeDistance(originPoint[0], originPoint[1]));
                if(distance < smallestDistance){
                    smallestDistance = distance;
                }
            }
            March m = new March(originPoint[0], originPoint[1], originPoint[0] + (smallestDistance * Math.cos(Math.toRadians(camera.getAngle()))), originPoint[1] + (smallestDistance * Math.sin(Math.toRadians(camera.getAngle()))));
            marches.add(m);
            originPoint[0] = originPoint[0] + (smallestDistance * Math.cos(Math.toRadians(camera.getAngle())));
            originPoint[1] = originPoint[1] + (smallestDistance * Math.sin(Math.toRadians(camera.getAngle())));
            if(originPoint[0] >= 1280){
                break;
            }
            if(originPoint[1] >= 640){
                break;
            }
        }
        return marches;
    }


    
    @Override
    public void paintComponent(Graphics g) {
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int i = 0; i < shapes.size(); i++) {
            Graphics2D g2d = (Graphics2D) g;
            shapes.get(i).DrawObject(g2d);
        }
        Graphics2D g2d = (Graphics2D) g;
        camera.DrawObject(g2d);

        ArrayList<March> m = march();

        for (March march : m){
            Graphics2D g2d2 = (Graphics2D) g;
            march.Draw(g2d2);
        }


//        double smallestDistance = Double.POSITIVE_INFINITY;
//        for (int i = 0; i < shapes.size(); i++) {
//            double distance = (shapes.get(i).computeDistance(camera.getCoordinatePairs(0, 0), camera.getCoordinatePairs(0 , 1))) * 2;
//            if(distance < smallestDistance){
//                smallestDistance = distance;
//            }
//        }
//        Graphics2D g2d2 = (Graphics2D) g;
//        g2d2.drawOval((int) ((int)camera.getCoordinatePairs(0, 0) - (smallestDistance/2)), (int) ((int)camera.getCoordinatePairs(0, 1) - (smallestDistance/2)), (int) smallestDistance, (int) smallestDistance);

        //g2d2.drawOval((int) ((int)camera.getCoordinatePairs(0, 0)), (int) ((int)camera.getCoordinatePairs(0, 1)), (int) smallestRadius, (int) smallestRadius);

    }
}
