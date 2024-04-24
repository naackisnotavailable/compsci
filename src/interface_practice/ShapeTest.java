package interface_practice;

public class ShapeTest {
    public static void main(String[] args) {
        testRectangle();
    }

    public static void testRectangle() {
        Rectangle rectangle = new Rectangle(5, 3);

        int expectedArea = 15;
        int actualArea = rectangle.getArea();
        System.out.println("Area: " + actualArea);
        System.out.println("Expected Area: " + expectedArea);
        System.out.println("Area Test Passed: " + (actualArea == expectedArea));

        int expectedPerimeter = 16;
        int actualPerimeter = rectangle.getPerimeter();
        System.out.println("Perimeter: " + actualPerimeter);
        System.out.println("Expected Perimeter: " + expectedPerimeter);
        System.out.println("Perimeter Test Passed: " + (actualPerimeter == expectedPerimeter));
    }
}