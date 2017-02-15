package lab6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle extends Figure {
    private PointD a, b, c;
 
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super((x1+x2+x3)/3, (y1+y2+y3)/3);
        a = new PointD(x1, y1);
        b = new PointD(x2, y2);
        c = new PointD(x3, y3);
    }
 
    @Override
    public int lineCount() {
        return 3;
    }
 
    @Override
    public Line getLineByNumber(int lineNumber) {
        Line l = null;
        switch (lineNumber) {
            case 0: l = new Line(a, b); break;
            case 1: l = new Line(b, c); break;
            case 2: l = new Line(c, a); break;
        }
        return l;
 
    }
 
    @Override
    public void move(double deltaX, double deltaY) {
        super.move(deltaX, deltaY);
        a.move(deltaX, deltaY);
        b.move(deltaX, deltaY);
        c.move(deltaX, deltaY);
    }
    
    public void show(){
    	System.out.println("Coordinates:  " + "|a: " + a.getX() + " ; " + a.getY() + " |b: " + b.getX() + " ; " + b.getY() + " |c: " + c.getX() + " ; " + c.getY() + "| ");
    }
    
    public double getAB(){
    	double AB = 0;
    	AB = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    	return new BigDecimal(AB).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
    
    public double getAC(){
    	double AC = 0;
    	AC = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2));
    	return new BigDecimal(AC).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
    
    public double getBC(){
    	double BC = 0;
    	BC = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
    	return new BigDecimal(BC).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
    
    public double getPerimetr(){
    	double p = 0;
    	p = getAB() + getAC() + getBC();
    	return new BigDecimal(p).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
    
    public double getArea(){
    	double S = 0;
    	double p_div = getPerimetr()/2;
    	S = Math.sqrt(p_div * (p_div - getAB()) * (p_div - getAC()) * (p_div - getBC()));
    	return new BigDecimal(S).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}