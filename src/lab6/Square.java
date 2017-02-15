package lab6;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Square extends Figure {
    private PointD p1, p2, p3, p4;
 
    public Square(double x, double y, double size) {
        super(x, y);
        p1 = new PointD(x + size / 2, y + size / 2); //A
        p2 = new PointD(x + size / 2, y - size / 2); //B
        p3 = new PointD(x - size / 2, y - size / 2); //C
        p4 = new PointD(x - size / 2, y + size / 2); //D
        
    }
 
    @Override
    public int lineCount() {
        return 4;
    }
 
    @Override
    public Line getLineByNumber(int lineNumber) {
        Line l = null;
        switch (lineNumber) {
            case 0: l = new Line(p1, p2); break;
            case 1: l = new Line(p2, p3); break;
            case 2: l = new Line(p3, p4); break;
            case 3: l = new Line(p4, p1); break;
        }
        return l;
    }
 
    @Override
    public void move(double deltaX, double deltaY) {
        super.move(deltaX, deltaY);
        p1.move(deltaX, deltaY);
        p2.move(deltaX, deltaY);
        p3.move(deltaX, deltaY);
        p4.move(deltaX, deltaY);
    }
    
    public void show(){
    	System.out.println("A(" + p1.getX() + "; " + p1.getY() + ")");
    	System.out.println("B(" + p2.getX() + "; " + p2.getY() + ")");
    	System.out.println("C(" + p3.getX() + "; " + p3.getY() + ")");
    	System.out.println("D(" + p4.getX() + "; " + p4.getY() + ")");
    }
    
    public double getPerimetr(){
    	return getSize() * 4;
    }
    
    public double getSize(){
    	double size = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    	return new BigDecimal(size).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
    
    public double getArea(){
    	return getSize() * getSize();
    }
}
