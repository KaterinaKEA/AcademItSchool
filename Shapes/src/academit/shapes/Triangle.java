package academit.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x1 = x2;
        this.y1 = y2;
        this.x1 = x3;
        this.y1 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getArea() {
        return 0.5 * getHeight() * getWidth();
    }

    @Override
    public double getPerimeter() {
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double c = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        return a + b + c;
    }

    @Override
    public String returnShapeName() {
        return "Треугольник";
    }

    @Override
    public String toString() {
        return this.x1 + ", " + this.y1 + ", " + this.x2 + ", " + this.y2 + ", " + this.x3 + ", " + this.y3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        if (o == null || o.getClass() != getClass()) return false;

        Triangle t = (Triangle) o;
        return x1 == t.x1 && y1 == t.y1 && x2 == t.x2 && y2 == t.y2 && x3 == t.x3 && y3 == t.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}
