package leetcode;

public class LE303NumArray {
//	private int[] nums;
//    public LE303NumArray(int[] nums) {
//    	for(int i = 1; i < nums.length; i++)
//            nums[i] += nums[i - 1];
//        
//        this.nums = nums;
//    }
//
//	public int sumRange(int i, int j) {
//	    if(i == 0) return nums[j];
//	    
//	    return nums[j] - nums[i - 1];
//	}
	
	//Approach 2
//	private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
//
//	public LE303NumArray(int[] nums) {
//	    for (int i = 0; i < nums.length; i++) {
//	        int sum = 0;
//	        for (int j = i; j < nums.length; j++) {
//	            sum += nums[j];
//	            map.put(Pair.create(i, j), sum);
//	        }
//	    }
//	}
//
//	public int sumRange(int i, int j) {
//	    return map.get(Pair.create(i, j));
//	}
	
	//Approach 3
	private int[] sum;
	public LE303NumArray(int[] nums) {
	    sum = new int[nums.length + 1];
	    for (int i = 0; i < nums.length; i++) {
	        sum[i + 1] = sum[i] + nums[i];
	    }
	}

	public int sumRange(int i, int j) {
	    return sum[j + 1] - sum[i];
	}
	
	public static void main(String[] args){
		int[] num = {8,5,2,6,0,15};
		LE303NumArray test = new LE303NumArray(num);
		System.out.println(test.sumRange(1, 5));
	}
    
}
