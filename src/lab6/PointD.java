package lab6;

public class PointD {
    private double x, y;
 
    public PointD(double x, double y) {
        this.x = x;
        this.y = y;
    }
 
    public double getX() {
        return x;
    }
 
    public double getY() {
        return y;
    }
    public void move (double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
}
