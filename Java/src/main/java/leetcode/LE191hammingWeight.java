package leetcode;

public class LE191HammingWeight {
	  // MY = ANS1
//    public int hammingWeight(int n) {
//        int result = 0;
//        int check = 1;
//        for(int i = 0; i < 32; i++){
//        	if((n & check) != 0){
//        		result++;
//        	}
//        	check <<= 1;
//        }
//        return result;
//    }
	
    //ANS2
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
    
    public static void main(String[] args){
    	LE191HammingWeight test = new LE191HammingWeight();
    	System.out.println(test.hammingWeight(11));
    }
}
