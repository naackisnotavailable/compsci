package interface_practice;

public interface Shape {
    int getArea();
    int getPerimeter();
    String type = "This is a Shape";
}

class Rectangle implements Shape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getArea() {
        return (int) (Math.PI * radius * radius);
    }

    public int getPerimeter() {
        return (int) (2 * Math.PI * radius);
    }
}