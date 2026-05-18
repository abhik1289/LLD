
import java.util.HashMap;

interface Shape {
    void draw(int x, int y);
}

class Circle implements Shape {

    private String color; // intrinsic state

    public Circle(String color) {
        this.color = color;

        System.out.println(
                "Creating circle of color: " + color);
    }

    @Override
    public void draw(int x, int y) {

        System.out.println(
                "Drawing " + color +
                        " circle at (" + x + "," + y + ")");
    }
}

class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {

        Shape circle = circleMap.get(color);

        if (circle == null) {

            circle = new Circle(color);

            circleMap.put(color, circle);
        }

        return circle;
    }
}

public class Flyweight {
    private static final String[] colors = {
            "Red",
            "Green",
            "Blue"
    };

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Shape circle = ShapeFactory.getCircle(
                    colors[i % 3]);

            circle.draw(i * 10, i * 20);
        }
    }
}
