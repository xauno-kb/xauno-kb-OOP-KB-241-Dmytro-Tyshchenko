public class task2 {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(0, 4);
        Point p4 = new Point(4, 0);

        Segment s1 = new Segment(p1, p2);
        Segment s2 = new Segment(p3, p4);

        System.out.println("Length: " + s1.length());
        System.out.println("Middle: " + s1.middle());
        System.out.println("Crossing: " + s1.intersection(s2));
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

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start.x == end.x && start.y == end.y) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    public double length() {
        return Math.sqrt(Math.pow(end.x - start.x, 2) + Math.pow(end.y - start.y, 2));
    }

    public Point middle() {
        return new Point((start.x + end.x) / 2, (start.y + end.y) / 2);
    }

    public Point intersection(Segment another) {
        double x1 = this.start.x;
        double y1 = this.start.y;
        double x2 = this.end.x;
        double y2 = this.end.y;

        double x3 = another.start.x;
        double y3 = another.start.y;
        double x4 = another.end.x;
        double y4 = another.end.y;

        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (den == 0) {
            return null;
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / den;

        if (t >= 0 && t <= 1 && u >= 0 && u <= 1) {
            double ix = x1 + t * (x2 - x1);
            double iy = y1 + t * (y2 - y1);
            return new Point(ix, iy);
        }

        return null;
    }
}