package leetcode;

public class LE011MaxArea {
    public int maxArea(int[] height) {
    	// MY
        int len = height.length;
        int i = 0;
        int j = len - 1;
        int max = 0;
        while(i < j){
            // System.out.println(i + ": " + height[i] + "/" + j + ": " + height[j]);
            int temp = (j - i) * Math.min(height[i], height[j]);
            if(temp > max)
                max = temp;
            if(height[i] > height[j])
                j--;
            else
                i++;
        }
        return max;
    }
}
