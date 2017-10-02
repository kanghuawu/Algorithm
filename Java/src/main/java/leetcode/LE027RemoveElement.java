package leetcode;

public class LE027RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int num : nums) {
            if (num != val)
                nums[len++] = num;
        }
        return len;
    }
}
