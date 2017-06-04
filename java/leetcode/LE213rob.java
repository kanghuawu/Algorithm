package leetcode;

public class LE213rob {
	public int rob(int[] num) {
	    int[] numL = new int[num.length - 1];
	    int[] numR = new int[num.length - 1];
	    System.arraycopy(num, 0, numL, 0, num.length - 1);
	    System.arraycopy(num, 1, numR, 0, num.length - 1);
	    return Math.max(robline(numL), robline(numR));
	}
	public int robline(int[] num) {
	    int rob = 0; //max monney can get if rob current house
	    int notrob = 0; //max money can get if not rob current house
	    for(int i=0; i<num.length; i++) {
	        int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
	        notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
	        rob = currob;
	    }
	    return Math.max(rob, notrob);
	}
    public static void main(String[] args){
//		int[] num = {155,44,52,58,250,225,109,118,211,73,137,96,137,89,174,66,134,26,25,205,239,85,146,73,55,6,122,196,128,50,61,230,94,208,46,243,105,81,157,89,205,78,249,203,238,239,217,212,241,242,157,79,133,66,36,165};
		int[] num1 = {1,2,3,4,5};
		LE198rob test = new LE198rob();
		System.out.println(test.rob(num1));
	}
}
