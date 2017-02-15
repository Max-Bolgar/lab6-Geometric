package lab6;

public abstract class Figure {
 
 
    private PointD center;
 
    public Figure(PointD center) {
        this.center = center;
    }
 
    public Figure(double x, double y) {
        center = new PointD(x, y);
    }
 
    public void move(double deltaX, double deltaY)  {
        center.move(deltaX, deltaY);
    }
    public abstract int lineCount();
    public abstract Line getLineByNumber(int lineNumber);
 
    public boolean testIntersection(Figure otherFig){
        int ourLineCount = lineCount();
        int otherLineCount = otherFig.lineCount();
        for (int i = 0; i < ourLineCount; i++) {
            Line line = this.getLineByNumber(i);
            double a1 = line.getP2().getY()-line.getP1().getY();
            double b1 = line.getP1().getX()-line.getP2().getX();
            double c1 = a1 * line.getP1().getX() + b1 * line.getP1().getY();
 
            for (int j = 0; j < otherLineCount; j++) {
                Line otherLine = otherFig.getLineByNumber(j);
                double a2 = otherLine.getP2().getY()-otherLine.getP1().getY();
                double b2 = otherLine.getP1().getX()-otherLine.getP2().getX();
                double c2 = a2 * otherLine.getP1().getX() + b2 * otherLine.getP1().getY();
                double det = a1*b2 - a2*b1;
                if (det == 0) {
                    // no intersection;
                } else {
                    // iX & iY - intersection point coordinate;
                    double iX = (b2*c1 - b1 * c2) / det;
                    double iY = (a1*c2 - a2 * c1) / det;
                    if (Double.min(line.getP1().getX(),line.getP2().getX()) <= iX 
                            && iX <= Double.max(line.getP1().getX(),line.getP2().getX())
                            && Double.min(line.getP1().getY(),line.getP2().getY()) <= iY
                            && iY <= Double.max(line.getP1().getY(),line.getP2().getY())
                            && Double.min(otherLine.getP1().getX(),otherLine.getP2().getX()) <= iX
                            && iX <= Double.max(otherLine.getP1().getX(),otherLine.getP2().getX())
                            && Double.min(otherLine.getP1().getY(),otherLine.getP2().getY()) <= iY
                            && iY <= Double.max(otherLine.getP1().getY(),otherLine.getP2().getY()))
                        return true;
                }
            }
        }
        return false;
    }
 
}
 