package academit.kondakova.shapes;

import academit.kondakova.shapes.typesShapes.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shapesArray = {new Square(3), new Triangle(1, 1, 2, 2, 3, 3),
                new Rectangle(2, 4), new Circle(2)};

        Shape shapeWithMaximumArea = ActionsOnShapes.findShapeWithMaximumArea(shapesArray);
        System.out.printf("Фигура с максимальной площадью - %s, площадь = %.2f%n",
                shapeWithMaximumArea.toString(), shapeWithMaximumArea.getArea());

        Shape shapeWithSecondLargestPerimeter = ActionsOnShapes.findShapeWithSecondLargestPerimeter(shapesArray);
        System.out.printf("Фигура со вторым по величине периметром - %s, периметр = %.2f%n",
                shapeWithSecondLargestPerimeter.getShapeName(), shapeWithSecondLargestPerimeter.getPerimeter());
    }
}