package convex.hull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jarvis {
    public static void main(String[] args) {
        Point[] points;

        Random random = new Random();

        Stream<Point> pointStream = Stream.generate(() -> {
            int random1 = random.nextInt(100);
            int random2 = random.nextInt(100);
            return new Point(random1, random2);
        }).distinct().limit(8);
        List<Point> initialPointList = pointStream.
                collect(Collectors.toList());
        List<Point> processedPointList = new ArrayList<>();

        System.out.println(initialPointList);

        //поиск 1ой точки, минимальная точка по x

        int xmin = 100;
        Point min = null;

        for (Point point : initialPointList) {
            if (point.x < xmin) {
                xmin = point.x;
                min = point;
            }
        }
        initialPointList.remove(min);
        initialPointList.add(min);
        processedPointList.add(min);

        System.out.println("Initial list " + initialPointList);
        System.out.println("Processed list " + processedPointList);

        //crossProduct(processedPointList.get(0),initialPointList.get(0),initialPointList.get(1));

        while (true)
        //for (Point point: initialPointList)
        {
            Point right = initialPointList.get(0);
            for (Point point2 : initialPointList) {
                double current = crossProduct(processedPointList.get(processedPointList.size() - 1), right, point2);
                if (current < 0) {
                    right = point2;
                }
            }
            if (right == processedPointList.get(0)) break;
            else {
                processedPointList.add(right);
                initialPointList.remove(right);
            }
            System.out.println("Initial list " + initialPointList);
            System.out.println("Processed list " + processedPointList);
        }
        processedPointList.remove(min);

        System.out.println("Initial list " + initialPointList);
        System.out.println("Processed list " + processedPointList);

    }

    public static double crossProduct(Point point1, Point point2, Point point3) {
        return (point2.x - point1.x) * (point3.y - point2.y) -
                (point3.x - point2.x) * (point2.y - point1.y);
        //System.out.println(res);
        //return res>0;
    }
}