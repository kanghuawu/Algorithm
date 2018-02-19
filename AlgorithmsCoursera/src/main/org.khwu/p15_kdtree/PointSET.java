package p15_kdtree;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

public class PointSET {
    private final SET<Point2D> pointList;
    // construct an empty set of points 
    public PointSET() {
        this.pointList = new SET<Point2D>();
    }
    
    // is the set empty? 
    public boolean isEmpty() {
        return this.pointList.isEmpty();
    }

    // number of points in the set 
    public int size() {
        return this.pointList.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null)
            throw new IllegalArgumentException();
        this.pointList.add(p);
    }

    // does the set contain point p? 
    public boolean contains(Point2D p) {
        return this.pointList.contains(p);
    }

    // draw all points to standard draw 
    public void draw() {
        for (Point2D pt : pointList) {
            pt.draw();
        }
    }

    // all points that are inside the rectangle (or on the boundary) 
    public Iterable<Point2D> range(RectHV rect) {
        SET<Point2D> insideRec = new SET<Point2D>();
        for (Point2D pt : this.pointList) 
            if (rect.contains(pt)) 
                insideRec.add(pt);
        return insideRec;
    }

    // a nearest neighbor in the set to point p; null if the set is empty 
    public Point2D nearest(Point2D p) {
        if (this.pointList.isEmpty()) return null;
        double nearestDist = 1.0;
        Point2D nearestPt = null;
        for (Point2D pt : this.pointList) {
            double dist = pt.distanceTo(p);
            if (dist < nearestDist) {
                nearestPt = pt;
                nearestDist = dist;
            }
        }
        return nearestPt;
    }

    // unit testing of the methods (optional) 
    public static void main(String[] args) {
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.4, 0.4);
        Point2D p3 = new Point2D(0.3, 0.3);
        Point2D p4 = new Point2D(0.2, 0.2);
        Point2D p5 = new Point2D(0.1, 0.1);
        Point2D p6 = new Point2D(0.6, 0.6);
        PointSET ptset = new PointSET();
        StdOut.println(ptset.contains(p1));
        StdOut.println(ptset.contains(p2));
        StdOut.println(ptset.contains(p3));
        StdOut.println(ptset.contains(p4));
        StdOut.println(ptset.contains(p5));
        StdOut.println(ptset.contains(p6));
        ptset.insert(p1);
        ptset.insert(p2);
        ptset.insert(p3);
        ptset.insert(p4);
        ptset.insert(p5);
        ptset.insert(p6);
        StdOut.println(ptset.contains(p1));
        StdOut.println(ptset.contains(p2));
        StdOut.println(ptset.contains(p3));
        StdOut.println(ptset.contains(p4));
        StdOut.println(ptset.contains(p5));
        StdOut.println(ptset.contains(p6));
    }
}
