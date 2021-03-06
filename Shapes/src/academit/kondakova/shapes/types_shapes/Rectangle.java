package academit.kondakova.shapes.types_shapes;

public class Rectangle implements Shape {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getWidth() {
        return side1;
    }

    @Override
    public double getHeight() {
        return side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }

    @Override
    public String getShapeName() {
        return "Прямоугольник";
    }

    @Override
    public String toString() {
        return "Прямоугольник с шириной = " + side1 + " и длиной = " + side2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Rectangle r = (Rectangle) o;
        return side1 == r.side1 && side2 == r.side2;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime * hash + Double.hashCode(side1);
        hash = prime * hash + Double.hashCode(side2);
        return hash;
    }
}