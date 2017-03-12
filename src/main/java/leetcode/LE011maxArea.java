package leetcode;

public class LE011maxArea {
	public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5};
		LE011maxArea test = new LE011maxArea();
		System.out.println(test.maxArea(arr));
	}
}
