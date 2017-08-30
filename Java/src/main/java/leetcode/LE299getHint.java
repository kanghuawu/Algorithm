package leetcode;

public class LE299GetHint {
//	public String getHint(String secret, String guess) {
//        int len = secret.length();
//		int[] secretarr = new int[10];
//		int[] guessarr = new int[10];
//		int bull = 0, cow = 0;
//		for (int i = 0; i < len; ++i) {
//			if (secret.charAt(i) == guess.charAt(i)) {
//				++bull;
//			} else {
//				++secretarr[secret.charAt(i) - '0'];
//				++guessarr[guess.charAt(i) - '0'];
//			}
//		}
//		for (int i = 0; i < 10; ++i) {
//			cow += Math.min(secretarr[i], guessarr[i]);
//		}
//		return "" + bull + "A" + cow + "B";
//    }
	
	public String getHint(String secret, String guess) {
        int len = secret.length();
		int[] secretarr = new int[10];
		int[] guessarr = new int[10];
		int bull = 0, cow = 0;
		for (int i = 0; i < len; ++i) {
			if (secret.charAt(i) == guess.charAt(i)) {
				++bull;
			} else {
				++secretarr[secret.charAt(i) - '0'];
				++guessarr[guess.charAt(i) - '0'];
			}
		}
		for (int i = 0; i < 10; ++i) {
			cow += Math.min(secretarr[i], guessarr[i]);
		}
		return "" + bull + "A" + cow + "B";
    }
	
//	public String getHint(String secret, String guess) {
//		int A = 0;
//		HashMap<Character, Integer> secretmap = new HashMap<Character, Integer>();
//		HashMap<Character, Integer> guessmap = new HashMap();
//        for(int i=0; i < secret.length(); i++){
//        	if(secret.charAt(i) == guess.charAt(i)){
//        		A++;
//        	}else{
//        		if(!secretmap.containsKey(secret.charAt(i))){
//        			secretmap.put(secret.charAt(i), 1);
//        		}else{
//        			secretmap.put(secret.charAt(i), secretmap.get(secret.charAt(i))+1);
//        		}
//        		if(!guessmap.containsKey(guess.charAt(i))){
//        			guessmap.put(guess.charAt(i), 1);
//        		}else{
//        			guessmap.put(guess.charAt(i), guessmap.get(guess.charAt(i))+1);
//        		}
//        	}
//        }
//        int B = 0;
//        for(char ch : guessmap.keySet()){
//        	if(secretmap.containsKey(ch)){
//        		B += Math.min(guessmap.get(ch), secretmap.get(ch));
//        	}
//        }
//        String result = String.valueOf(A) + "A" + String.valueOf(B) + "B";
//        return result; 
//    }
	
	public static void main(String arg[]){
		LE299GetHint test = new LE299GetHint();
		String secret = "1123";
		String guess = "0111";
		System.out.println(test.getHint(secret, guess));
	}
}
