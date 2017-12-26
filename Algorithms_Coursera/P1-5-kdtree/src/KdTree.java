import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

public class KdTree {
    private static final boolean VERTICAL = true;
    private static final boolean HORIZONTAL = false;
    private int size;
    private Node root;
    
    // construct an empty set of points 
    public KdTree() {
        this.size = 0;
        this.root = null;
    }

    private static class Node {
        private Point2D p;
        private RectHV rect;
        private Node lb;
        private Node rt;
        public Node(Point2D p, RectHV rect) {
            this.p = p;
            this.rect = rect;
            this.lb = null;
            this.rt = null;
        }
    }

    // is the set empty? 
    public boolean isEmpty() {
        return this.size == 0;
    }

    // number of points in the set 
    public int size() {
        return this.size;
    }

    private int compare(Point2D p1, Point2D p2, boolean isVertical) {
        if (p1.equals(p2))
            return 0;
        if (isVertical) {
            if (Point2D.X_ORDER.compare(p2, p1) >= 0)
                return 1;
            else
                return -1;
        } else { 
            if (Point2D.Y_ORDER.compare(p2, p1) >= 0) 
                return 1;
            else
                return -1;
        }
    }

    private Node put(Node node, Point2D p, double xmin, double ymin, double xmax, double ymax, boolean isVertical) {
        if (node == null) {
            this.size++;
            return new Node(p, new RectHV(xmin, ymin, xmax, ymax));
        }
        
        int cmp = compare(node.p, p, isVertical);
        if (cmp < 0) {
            if (isVertical)
                node.lb = put(node.lb, p, xmin, ymin, node.p.x(), ymax, !isVertical);
            else
                node.lb = put(node.lb, p, xmin, ymin, xmax, node.p.y(), !isVertical);
        } else if (cmp > 0) {
            if (isVertical)
                node.rt = put(node.rt, p, node.p.x(), ymin, xmax, ymax, !isVertical);
            else
                node.rt = put(node.rt, p, xmin, node.p.y(), xmax, ymax, !isVertical);
        }
        return node;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) 
            throw new IllegalArgumentException();

        this.root = put(this.root, p, 0.0, 0.0, 1.0, 1.0, VERTICAL);
        
    }

    private Node get(Node node, Point2D p, boolean isVertical) {
        if (node == null) return null;
        int cmp = compare(node.p, p, isVertical);
        if (cmp < 0) {
            return get(node.lb, p, !isVertical);
        } else if (cmp > 0) {
            return get(node.rt, p, !isVertical);
        } else {
            return node;    
        }
    }

    // does the set contain point p? 
    public boolean contains(Point2D p) {
        if (p == null) 
            throw new IllegalArgumentException();
        return get(root, p, VERTICAL) != null;
    }

    // draw all points to standard draw 
    public void draw() {
        drawHelper(this.root, 0.0, 0.0, 1.0, 1.0, VERTICAL);
    }

    private void drawHelper(Node node, double xmin, double ymin, double xmax, double ymax, boolean isVertical) {
        if (node == null)
            return;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        node.p.draw();
        double x = node.p.x();
        double y = node.p.y();
        if (isVertical) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius();
            StdDraw.line(x, ymin, x, ymax);
            drawHelper(node.lb, xmin, ymin, x, ymax, !isVertical);
            drawHelper(node.rt, x, ymin, xmax, ymax, !isVertical);
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius();
            StdDraw.line(xmin, y, xmax, y);
            drawHelper(node.lb, xmin, ymin, xmax, y, !isVertical);
            drawHelper(node.rt, xmin, y, xmax, ymax, !isVertical);
        }
    }

    private void rangeHelper(Node node, RectHV rect, ArrayList<Point2D> list) {
        if (node == null) return;
        if (rect.contains(node.p)) {
            list.add(node.p);
            rangeHelper(node.lb, rect, list);
            rangeHelper(node.rt, rect, list);
        } else {
            if (node.lb != null && rect.intersects(node.lb.rect))
                rangeHelper(node.lb, rect, list);
            if (node.rt != null && rect.intersects(node.rt.rect))
                rangeHelper(node.rt, rect, list);
        }
    }

    // all points that are inside the rectangle (or on the boundary) 
    public Iterable<Point2D> range(RectHV rect) {
        ArrayList<Point2D> list = new ArrayList<Point2D>();
        rangeHelper(root, rect, list);
        return list;
    }

    // ref: http://www.programcreek.com/java-api-examples/index.php?source_dir=SpaceJam-master/SpaceGame/src/util/KdTree.java
    private Point2D nearestHelper(Node node, Point2D closest, Point2D p, boolean isVertical) {
        if (node == null) 
            return closest;

        double distToP = node.rect.distanceSquaredTo(p); 
        double closestDist = closest.distanceSquaredTo(p);

        if (distToP > closestDist) 
            return closest; 

        Point2D newClosest = closest;
        if (node.p.distanceSquaredTo(p) < closestDist) 
            newClosest = node.p;
        
        if (compare(node.p, p, isVertical) < 0) {
            newClosest = nearestHelper(node.lb, newClosest, p, !isVertical);
            newClosest = nearestHelper(node.rt, newClosest, p, !isVertical);
        } else {
            newClosest = nearestHelper(node.rt, newClosest, p, !isVertical);
            newClosest = nearestHelper(node.lb, newClosest, p, !isVertical);
        }
        return newClosest;    
    }

    // a nearest neighbor in the set to point p; null if the set is empty 
    public Point2D nearest(Point2D p) {
        if (this.size == 0 || p == null) return null;
        
        return nearestHelper(root, root.p, p, VERTICAL);
    }

    // unit testing of the methods (optional) 
    public static void main(String[] args) { 
        Point2D p1 = new Point2D(0.5, 0.5);
        Point2D p2 = new Point2D(0.4, 0.4);
        Point2D p3 = new Point2D(0.3, 0.3);
        Point2D p4 = new Point2D(0.2, 0.2);
        Point2D p5 = new Point2D(0.1, 0.1);
        Point2D p6 = new Point2D(0.6, 0.6);
        KdTree ktree = new KdTree();
        StdOut.println(ktree.contains(p1));
        StdOut.println(ktree.contains(p2));
        StdOut.println(ktree.contains(p3));
        StdOut.println(ktree.contains(p4));
        StdOut.println(ktree.contains(p5));
        StdOut.println(ktree.contains(p6));
        ktree.insert(p1);
        ktree.insert(p2);
        ktree.insert(p3);
        ktree.insert(p4);
        ktree.insert(p5);
        ktree.insert(p6);
        StdOut.println(ktree.contains(p1));
        StdOut.println(ktree.contains(p2));
        StdOut.println(ktree.contains(p3));
        StdOut.println(ktree.contains(p4));
        StdOut.println(ktree.contains(p5));
        StdOut.println(ktree.contains(p6));
        StdOut.println(ktree.nearest(new Point2D(0.5, 0.6)));
        // ktree.draw();
    }
}
