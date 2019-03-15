package convex.hull;

public class Point implements Comparable<Point>{
    public int x;
    public int y;

    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x==o.x&&this.y==o.y)
            return 0;
        else
            return 1;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
