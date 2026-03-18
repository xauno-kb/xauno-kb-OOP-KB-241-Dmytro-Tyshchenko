public class task1 {
    public static void main(String[] args) {
        Line line1 = new Line(1, 1);
        Line line2 = new Line(-1, 3);

        System.out.println(line1.intersection(line2));
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
        return "(" + (int)x + ";" + (int)y + ")";
    }
}

class Line {
    double k;
    double b;

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if (this.k == other.k) {
            return null;
        }

        double x = (other.b - this.b) / (this.k - other.k);
        double y = this.k * x + this.b;

        return new Point(x, y);
    }
}