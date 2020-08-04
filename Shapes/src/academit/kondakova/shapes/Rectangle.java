package academit.kondakova.shapes;

public class Rectangle implements Shape {
    private double firstSide;
    private double secondSide;

    public Rectangle(double firstSide, double secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public double getWidth() {
        return Math.max(firstSide, secondSide);
    }

    @Override
    public double getHeight() {
        return Math.min(firstSide, secondSide);
    }

    @Override
    public double getArea() {
        return firstSide * secondSide;
    }

    @Override
    public double getPerimeter() {
        return 2 * (firstSide + secondSide);
    }

    @Override
    public String returnShapeName() {
        return "Прямойгольник";
    }

    @Override
    public String toString() {
        return this.firstSide + ", " + this.secondSide;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        if (o == null || o.getClass() != getClass()) return false;

        Rectangle r = (Rectangle) o;
        return firstSide == r.firstSide && secondSide == r.secondSide;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime * hash + Double.hashCode(firstSide);
        hash = prime * hash + Double.hashCode(secondSide);
        return hash;
    }
}