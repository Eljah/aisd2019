package convex.hull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jarvis {
    public static void main(String[] args) {
        Point[] points;

        Random random=new Random();

        Stream<Point> pointStream=Stream.generate(()->{int random1=random.nextInt(100);int random2=random.nextInt(100);return new Point(random1,random2);}).distinct().limit(10);
        List<Point> pointList=pointStream.
                collect(Collectors.toList());

        System.out.println(pointList);
    }
}