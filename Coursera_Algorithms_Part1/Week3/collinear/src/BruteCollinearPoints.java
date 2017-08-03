import java.lang.IllegalArgumentException;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private final LineSegment[] segments;
    private int numberOfSegments;
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new java.lang.IllegalArgumentException("Invalid input");
        Point[] pointsCp = points.clone();
        segments = new LineSegment[pointsCp.length];
        numberOfSegments = 0;
        Arrays.sort(pointsCp);
        if (hasDuplicatesOrNull(pointsCp))
            throw new IllegalArgumentException("Found repeating points or null");
        for (int i = 0; i < pointsCp.length - 3; i++) {
            for (int j = i + 1; j < pointsCp.length - 2; j++) {
                for (int k = j + 1; k < pointsCp.length - 1; k++) {
                    for (int l = k + 1; l < pointsCp.length; l++) {

                        if (pointsCp[i].slopeTo(pointsCp[j]) == pointsCp[i].slopeTo(pointsCp[k]) && pointsCp[i].slopeTo(pointsCp[k]) == pointsCp[i].slopeTo(pointsCp[l])) {
                            segments[numberOfSegments] = new LineSegment(pointsCp[i], pointsCp[l]);
                            numberOfSegments++;
                        }
                    }
                }
            }
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}