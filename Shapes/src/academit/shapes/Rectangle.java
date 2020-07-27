package academit.shapes;

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

    public String returnShapeName(){
        return "Прямойгольник";
    }
}
