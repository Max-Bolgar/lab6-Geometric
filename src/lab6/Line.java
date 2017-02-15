package lab6;

public class Line {
    private PointD p1, p2;
 
    public Line(PointD p1, PointD p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
 
    public PointD getP1() {
        return p1;
    }
 
    public PointD getP2() {
        return p2;
    }
    public void move (double deltaX, double deltaY) {
        p1.move(p1.getX() + deltaX, p2.getY() + deltaY);
        p2.move(p2.getX() + deltaX, p2.getY() + deltaY);
    }
}