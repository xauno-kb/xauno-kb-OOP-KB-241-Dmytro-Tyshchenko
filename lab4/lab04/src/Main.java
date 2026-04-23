public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(0, 3);
        Point p4 = new Point(4, 3);

        Figure triangle = new Triangle(p1, p2, p3);
        System.out.println(triangle.toString());
        System.out.println("Square: " + triangle.area());
        System.out.println("Centroid: " + triangle.centroid().x + ", " + triangle.centroid().y);

        Figure quad = new Quadrilateral(p1, p2, p4, p3);
        System.out.println(quad.toString());
        System.out.println("Square: " + quad.area());
        
        Figure circle = new Circle(p1, 5.0);
        System.out.println(circle.toString());
        System.out.println("Square: " + circle.area());
    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

abstract class Figure {
    public abstract double area();
    public abstract Point centroid();
    public abstract String toString();
}

class Triangle extends Figure {
    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (area() <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
    }

    public Point centroid() {
        return new Point((a.x + b.x + c.x) / 3.0, (a.y + b.y + c.y) / 3.0);
    }

    public String toString() {
        return "Triangle[A(" + a.x + "," + a.y + ") B(" + b.x + "," + b.y + ") C(" + c.x + "," + c.y + ")]";
    }
}

class Quadrilateral extends Figure {
    Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (area() <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double areaABC = Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
        double areaACD = Math.abs((a.x * (c.y - d.y) + c.x * (d.y - a.y) + d.x * (a.y - c.y)) / 2.0);
        return areaABC + areaACD;
    }

    public Point centroid() {
        double area1 = Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
        double cx1 = (a.x + b.x + c.x) / 3.0;
        double cy1 = (a.y + b.y + c.y) / 3.0;

        double area2 = Math.abs((a.x * (c.y - d.y) + c.x * (d.y - a.y) + d.x * (a.y - c.y)) / 2.0);
        double cx2 = (a.x + c.x + d.x) / 3.0;
        double cy2 = (a.y + c.y + d.y) / 3.0;

        double totalArea = area1 + area2;
        double finalX = (cx1 * area1 + cx2 * area2) / totalArea;
        double finalY = (cy1 * area1 + cy2 * area2) / totalArea;

        return new Point(finalX, finalY);
    }

    public String toString() {
        return "Quadrilateral[A(" + a.x + "," + a.y + ") B(" + b.x + "," + b.y + ") C(" + c.x + "," + c.y + ") D(" + d.x + "," + d.y + ")]";
    }
}

class Circle extends Figure {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public Point centroid() {
        return new Point(center.x, center.y);
    }

    public String toString() {
        return "Circle[(" + center.x + "," + center.y + ") " + radius + "]";
    }
}