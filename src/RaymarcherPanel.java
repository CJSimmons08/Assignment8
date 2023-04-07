import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

    public void populateList(){
        RectangleObject rectangle1 = new RectangleObject(15, 15, 50, 50, Color.BLUE);
        RectangleObject rectangle2 = new RectangleObject(40, 60, 75, 75, Color.GREEN);
        CircleObject circle1 = new CircleObject(200, 100, 50, Color.RED);
        CircleObject circle2 = new CircleObject(150, 150, 35, Color.CYAN);
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
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getHeight(), 
                this.raymarcherRunner.getFrame().getHeight()));
    }


    
    @Override
    public void paintComponent(Graphics g) {
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int i = 0; i < shapes.size(); i++) {
            Graphics2D g2d = (Graphics2D) g;
            shapes.get(i).DrawObject(g2d);
        }
    }
}
