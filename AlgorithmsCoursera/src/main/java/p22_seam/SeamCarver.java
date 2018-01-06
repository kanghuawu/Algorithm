package p22_seam;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Stack;


public class SeamCarver {
    private static final double BORDER_ENERGY = 1000.00;
    private int[][] picture;
    private boolean isVertical;
    private int width;
    private int height;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw  new IllegalArgumentException();
        }
        width = picture.width();
        height = picture.height();

        this.picture = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                this.picture[row][col] = picture.getRGB(col, row);
            }
        }
        isVertical = true;
    }

    // current picture
    public Picture picture() {
        if (!isVertical) {
            transpose();
        }
        Picture newPicture = new Picture(width, height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                newPicture.setRGB(col, row, this.picture[col][row]);
            }
        }
        return newPicture;
    }

    // width of current picture
    public int width() {
        if (!isVertical) {
            transpose();
        }
        return width;
    }

    // height of current picture
    public int height() {
        if (!isVertical) {
            transpose();
        }
        return height;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            throw new IllegalArgumentException();
        }
        if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
            return BORDER_ENERGY;
        }

        int left = picture[y][x - 1];
        int right = picture[y][x + 1];
        int top = picture[y - 1][x];
        int bottom = picture[y + 1][x];
        double deltaX = getDeltaSquare(left, right);
        double deltaY = getDeltaSquare(top, bottom);;
        return Math.sqrt(deltaX + deltaY);
    }

    private double getDeltaSquare(int col1, int col2) {
        return Math.pow((double) (getRed(col1) - getRed(col2)), 2) +
                Math.pow((double) (getGreen(col1) - getGreen(col2)), 2) +
                Math.pow((double) (getBlue(col1) - getBlue(col2)), 2);
    }

    private int getRed(int color) {
        return (color >> 16) & 0xFF;
    }

    private int getGreen(int color) {
        return (color >> 8) & 0xFF;
    }

    private int getBlue(int color) {
        return (color >> 0) & 0xFF;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        if (isVertical) {
            transpose();
        }
        return findVerticalSeam();
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        if (!isVertical) {
            transpose();
        }
        int[][] edgeTo = new int[height][width];
        double[][] distTo = new double[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                distTo[row][col] = Double.MAX_VALUE;
            }
        }

        Stack<Integer> reversePost = topologicalSort(this.picture);
        for (int idx : reversePost) {
            relax(idx, edgeTo, distTo);
        }

        double min = Double.MIN_VALUE;
        int minCol = 0;
        for (int col = 0; col < width; col++) {
            if (min > distTo[height-1][col]) {
                min = distTo[height-1][col];
                minCol = col;
            }
        }

        int[] path = new int[height];
        for (int row = height-1; row >= 0; row--) {
            path[row] = minCol;
            minCol = edgeTo[row][minCol] / width;
        }
        return path;
    }

    private void relax(int idx, int[][] edgeTo, double[][] distTo) {
        int oriCol = idx % width;
        int oriRow = idx / width;
        for (int nxtCol = oriCol - 1; nxtCol < 1; nxtCol++) {
            int nxtRow = oriRow + 1;
            if (nxtCol < 0 || nxtCol >=width || nxtRow < 0 || nxtRow >= height) continue;
            if (distTo[nxtRow][nxtCol] > distTo[oriRow][oriCol] + energy(nxtCol, nxtRow)) {
                distTo[nxtRow][nxtCol] = distTo[oriRow][oriCol] + energy(nxtCol, nxtRow);
                edgeTo[nxtCol][nxtRow] = oriCol + oriRow * width;
            }
        }
    }

    private Stack<Integer> topologicalSort(int[][] picture) {
        int w = picture[0].length;
        int h = picture.length;
        Stack<Integer> reversePost = new Stack<>();
        boolean[] visited = new boolean[w*h];
        for (int col = 0; col < h; col++) {
            if (!visited[col]) {
                dfs(visited, col, reversePost);
            }
        }
        return reversePost;
    }

    private void dfs(boolean[] visited, int curr, Stack<Integer> reversePost) {
//        if (visited[curr]) return;

        visited[curr] = true;
        int x = curr % width;
        int y = curr / width;
        if (y + 1 < height) {
            for (int col = x - 1; col <= x + 1; col++) {
                if (col == -1 || col >= width) continue;
                int next = col + (y + 1) * width;
                if (!visited[next]) {
                    dfs(visited, curr, reversePost);
                }
            }
        }
        reversePost.push(curr);
    }


    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (!isVertical) {
            transpose();
        }
        removeVerticalSeam(seam);
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (isVertical) {
            transpose();
        }
        if (isValidSeam(seam, width, height)) {
            throw new IllegalArgumentException();
        }
        for (int row = 0; row < height; row++) {
            int col = seam[row];
            System.arraycopy(picture[row], col+1, picture[row], col, width - col + 1);
        }
    }

    private void transpose() {
        int[][] newPicture = new int[width][height];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                newPicture[col][row] = picture[row][col];
            }
        }
        this.picture = newPicture;
        int tmp = width;
        width = height;
        height = tmp;
        isVertical = !isVertical;
    }

    private boolean isValidSeam(int[] seam, int width, int height) {
        if (seam == null || seam.length != height) {
            return false;
        }
        for (int col : seam) {
            if (col < 0 || col >= width) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String filename = "/Users/khwu/Projects/Algorithm/AlgorithmsCoursera/src/main/java/p22_seam/test/chameleon.png";
        Picture picture = new Picture(filename);
        picture.show();
        StdOut.println(picture.getRGB(0, 0));
    }
}