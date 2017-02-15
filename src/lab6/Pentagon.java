package lab6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pentagon extends Figure {
	private PointD p1, p2, p3, p4, p5;

	public Pentagon(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
		super((x1+x2+x3+x4+x5)/5, (y1+y2+y3+y4+y5)/5);
        p1 = new PointD(x1, y1); //A
        p2 = new PointD(x2, y2); //B
        p3 = new PointD(x3, y3); //C
        p4 = new PointD(x4, y4); //D
        p5 = new PointD(x5, y5); //E
	}

	@Override
	public int lineCount() {
		return 5;
	}

	@Override
	public Line getLineByNumber(int lineNumber) {
        Line l = null;
        switch (lineNumber) {
            case 0: l = new Line(p1, p2); break;
            case 1: l = new Line(p2, p3); break;
            case 2: l = new Line(p3, p4); break;
            case 3: l = new Line(p4, p5); break;
            case 4: l = new Line(p5, p1); break;
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
        p5.move(deltaX, deltaY);
    }
    
    public void show(){
    	System.out.println("A(" + p1.getX() + "; " + p1.getY() + ")");
    	System.out.println("B(" + p2.getX() + "; " + p2.getY() + ")");
    	System.out.println("C(" + p3.getX() + "; " + p3.getY() + ")");
    	System.out.println("D(" + p4.getX() + "; " + p4.getY() + ")");
    	System.out.println("E(" + p5.getX() + "; " + p5.getY() + ")");
    }
    
    public double[] getSizes(){
    	double[] sizes = new double[5];
    	sizes[0] = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    	sizes[1] = Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2));
    	sizes[2] = Math.sqrt(Math.pow(p4.getX() - p3.getX(), 2) + Math.pow(p4.getY() - p3.getY(), 2));
    	sizes[3] = Math.sqrt(Math.pow(p5.getX() - p4.getX(), 2) + Math.pow(p5.getY() - p4.getY(), 2));
    	sizes[4] = Math.sqrt(Math.pow(p5.getX() - p1.getX(), 2) + Math.pow(p5.getY() - p1.getY(), 2));
    	return sizes;
    }
    
    public double getPerimetr(){
    	double p = 0;
    	for (int i = 0; i < 5; i++) {
			p += getSizes()[i];
		}
    	return new BigDecimal(p).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
    
    public void showSizes(){
    	System.out.println(Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2)));
    	System.out.println(Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2)));
    	System.out.println(Math.sqrt(Math.pow(p4.getX() - p3.getX(), 2) + Math.pow(p4.getY() - p3.getY(), 2)));
    	System.out.println(Math.sqrt(Math.pow(p5.getX() - p4.getX(), 2) + Math.pow(p5.getY() - p4.getY(), 2)));
    	System.out.println(Math.sqrt(Math.pow(p5.getX() - p1.getX(), 2) + Math.pow(p5.getY() - p1.getY(), 2)));
    }
}
