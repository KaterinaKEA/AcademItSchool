package academit.kondakova.shapes;

import java.util.Arrays;

public class ActionsOnShapes {
    public static Shape findShapeWithMaximumArea(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new SortByArea());
        return shapesArray[shapesArray.length - 1];
    }

    public static Shape findShapeWithSecondLargestPerimeter(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new SortByPerimeter());
        return shapesArray[shapesArray.length - 2];
    }
}