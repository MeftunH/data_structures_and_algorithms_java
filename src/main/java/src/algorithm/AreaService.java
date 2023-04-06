package src.algorithm;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */
import java.util.List;

public class AreaService {

    public double calculateArea(List<Object>... shapes) {
        double area = 0;
        for (List<Object> shapeList : shapes) {
            for (Object shape : shapeList) {
                if (shape instanceof Rectangle) {
                    Rectangle rect = (Rectangle) shape;
                    area += (rect.getLength() * rect.getHeight());
                } else if (shape instanceof Circle) {
                    Circle circle = (Circle) shape;
                    area += circle.getRadius() * circle.getRadius() * Math.PI;
                } else {
                    throw new RuntimeException("Shape not supported");
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        // Example usage:
        Rectangle rect1 = new Rectangle(5, 10);
        Rectangle rect2 = new Rectangle(3, 7);
        Circle circle1 = new Circle(2);

        AreaService areaService = new AreaService();
        double totalArea = areaService.calculateArea(List.of(List.of(rect1, rect2), List.of(circle1)));
        System.out.println("Total area: " + totalArea);
    }
}

class Rectangle {
    private double length;
    private double height;

    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}