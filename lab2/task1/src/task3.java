public class task3 {
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(2, 3);

        Triangle triangle = new Triangle(a, b, c);

        System.out.println("Area: " + triangle.area());
        System.out.println("Centroid: " + triangle.centroid());
    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}

class Triangle {
    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        double area = Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0;
        
        if (area <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0;
    }

    public Point centroid() {
        double cx = (a.x + b.x + c.x) / 3.0;
        double cy = (a.y + b.y + c.y) / 3.0;
        return new Point(cx, cy);
    }
}