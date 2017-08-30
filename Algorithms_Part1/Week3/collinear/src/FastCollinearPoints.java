import java.lang.IllegalArgumentException;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


public class FastCollinearPoints {
    private final LineSegment[] segments;
    private final int LINE_SEGEMENT_POINT = 3;
    private int numberOfSegments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("Invalid input");

        Point[] pointsCp = points.clone();
        Arrays.sort(pointsCp);

        if (hasDuplicatesOrNull(pointsCp))
            throw new IllegalArgumentException("Found repeating points or null");
        
        segments = new LineSegment[pointsCp.length];
        numberOfSegments = 0;

        for (int i = 0; i < pointsCp.length - 3; i++) {
            Arrays.sort(pointsCp, pointsCp[i].slopeOrder());
            for (int first = 1, last = 2; last < pointsCp.length; last++) {
                // ref: https://github.com/AlexJoz/Algorithms--Java-/blob/master/Week3-Collinear%20Points/FastCollinearPoints.java
                while (last < pointsCp.length && pointsCp[0].slopeTo(pointsCp[first]) == pointsCp[0].slopeTo(pointsCp[last])) {
                    last++;
                }
                if (last - first >= LINE_SEGEMENT_POINT && pointsCp[0].compareTo(pointsCp[first]) < 0) {
                    segments[numberOfSegments] = new LineSegment(pointsCp[0], pointsCp[last - 1]);
                    numberOfSegments++;
                }
                first = last;
            }
            if (i != pointsCp.length - 4)
                Arrays.sort(pointsCp);
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return numberOfSegments;
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] res = new LineSegment[numberOfSegments];
        for (int i = 0; i < numberOfSegments; i++) {
            res[i] = segments[i];
        }
        return res;
    }

    private boolean hasDuplicatesOrNull(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i] == null || points[i].compareTo(points[i+1]) == 0)
                return true;
        }
        if (points[points.length - 1] == null)
            return true;
        return false;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}