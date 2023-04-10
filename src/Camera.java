import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Camera implements Drawable, MouseMotionListener, MouseListener {
    public double[][] coordinatePairs = new double[10][2];
    public double angle = 0;
    private double diameter = 20;
    private Color color;

    public Camera(double x, double y, Color color) {
        this.coordinatePairs[0][0] = x;
        this.coordinatePairs[0][1] = y;
        this.color = color;
    }

    public void DrawObject(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval((int)this.coordinatePairs[0][0] - (int)(diameter/2), (int)this.coordinatePairs[0][1] - (int)(diameter/2), (int)diameter, (int)diameter);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.coordinatePairs[0][0] = e.getX();
        this.coordinatePairs[0][1] = e.getY();
    }



    /*Getters*/
    public double getCoordinatePairs(int x, int y) {
        return coordinatePairs[x][y];
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            this.angle += 1;
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            this.angle -= 1;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
