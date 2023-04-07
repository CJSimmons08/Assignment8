abstract class CollisionObject implements Drawable{
    public double[][] coordinatePairs = new double[10][2];

    public CollisionObject(double x, double y){
        this.coordinatePairs[0][0] = x;
        this.coordinatePairs[0][1] = y;
    }
}
