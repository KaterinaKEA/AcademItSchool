package academit.kondakova.shapes;

import academit.kondakova.shapes.typesShapes.Shape;

import java.util.Arrays;

public class ActionsOnShapes {
    public static Shape findShapeWithMaximumArea(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new AreaComparator());
        return shapesArray[shapesArray.length - 1];
    }

    public static Shape findShapeWithSecondLargestPerimeter(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new PerimeterComparator());
        return shapesArray[shapesArray.length - 2];
    }
}