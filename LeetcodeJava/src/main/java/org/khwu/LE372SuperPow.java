package org.khwu;


public class LE372SuperPow {
	// MYMY
//	public int superPow(int a, int[] b) {
//		a %= 1337;
//		int result = 1;
//		for(int i = 0; i < b.length; i++){
//			result = (int) (Math.pow(result, 3) % 1337 * Math.pow(result, 3) % 1337 * Math.pow(result, 4) % 1337 * Math.pow(a, b[i]/2) % 1337 * Math.pow(a, b[i]/2) % 1337 * Math.pow(a, b[i] - b[i]/2 -b[i]/2) % 1337);
//		}
//		return result;
//    }
	
	// eurler
//	public int superPow(int a, int[] b) {
//	    if (a % 1337 == 0) return 0;
//	    int p = 0;
//	    for (int i : b) p = (p * 10 + i) % 1140;
//	    if (p == 0) p += 1440;
//	    return power(a, p, 1337);
//	}
//	public int power(int a, int n, int mod) {
//	    a %= mod;
//	    int ret = 1;
//	    while (n != 0) {
//	        if ((n & 1) != 0) ret = ret * a % mod;
//	        a = a * a % mod;
//	        n >>= 1;
//	    }
//	    return ret;
//	}
	
	//
//	int DIV = 1337;
//    
//    List<Integer> findLoop(int a){
//        List<Integer> index = new ArrayList<>();
//        boolean[] set = new boolean[DIV];
//        int rem = a % DIV;
//        int i = 0;
//        while ( ! set[rem] ) {
//            set[rem]=true;
//            index.add(rem);
//            rem = (rem*a) % DIV;
//            System.out.println(i + ", " + set[rem] + ", " + rem);
////            System.out.println(rem);
//            i++;
//        }
//        return index;
//    }
//    
//    int modBy(int[] b, int m){
//        int rem = 0;
//        for (int i=0; i < b.length; i++) {
//            rem = (rem*10+b[i]) % m;
//        }
////        System.out.println(rem);
//        return rem;
//    }
//
//    public int superPow(int a, int[] b) {
//        if (a==0 || a==DIV || b==null || b.length == 0) return 0;
//        if (a==1) return 1;
//        if (a > DIV) return superPow( a % DIV, b);
//        List<Integer> index = findLoop(a);
//        int loopsize = index.size();
//        int rem = modBy(b, loopsize);
//        rem = rem==0? loopsize: rem;
//        return index.get(rem-1);
//    }
	
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }
    
    private int superPow(int a, int[] b, int length, int k) {
        if (length == 1) {
            return powMod(a, b[0], k);
        }
        
        return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
    }
    
    
    //x^y mod k
    private int powMod(int x, int y, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < y; i++) {
            pow = (pow * x) % k;
        }
        return pow; 
    }
    
	public static void main(String[] arg){
		LE372SuperPow test = new LE372SuperPow();
		int a = 2;
//		double t = MAX_VALUE;
		int[] b = {1,2,3,4,5};
//		System.out.println(t);
		System.out.println(test.superPow(a, b));
	}
}
