package leetcode;

public class LE278FirstBadVersion {
    public int firstBadVersion(int n) {
        int le = 0;
        int ri = n;
        while(ri != (le + 1)){
        	int mid = le + (ri - le) / 2;
//        	System.out.println(mid);
        	if(!isBadVersion(mid)){
        		ri = mid;
        	}else{
        		le = mid + 1;
        	}
        }
        return le;
    }
    public static boolean isBadVersion(int version){
    	if(version > 1) return false;
    	return true;
    }
    public static void main(String[] args){
    	LE278FirstBadVersion test = new LE278FirstBadVersion();
    	System.out.print(test.firstBadVersion(1));
    }
}
