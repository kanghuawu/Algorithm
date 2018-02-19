package org.khwu;

public class LE165CompareVersion {
//	public static int compareVersion(String version1, String version2) {
	//6%
//		String[] s1 = version1.split("\\.");
//		String[] s2 = version2.split("\\.");
//		System.out.println(s1[0]);
//		System.out.println(s2[0]);
//		
//		int i=0;
//		while(s1.length>i || s2.length>i){
//			int v1=0, v2=0;
//			if(s1.length>i) v1=Integer.valueOf(s1[i]);
//			if(s2.length>i) v2=Integer.valueOf(s2[i]);
////			System.out.println(v1);
////			System.out.println(v2);
//			if(v1>v2) return 1;
//			if(v1<v2) return -1;
//			i++;
//		}
//		
//		return 0;
//	}
	
	public static int compareVersion(String version1, String version2) {
		//25%
	    String[] levels1 = version1.split("\\.");
	    String[] levels2 = version2.split("\\.");
	    
	    int length = Math.max(levels1.length, levels2.length);
	        for (int i=0; i<length; i++) {
	        	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
	        	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
	        	int compare = v1.compareTo(v2);
	        	if (compare != 0) {
	        		return compare;
	        	}
	        }
	    
	    return 0;
	    }
	
	
	public static void main(String[] args){
		String v1 = "1.0";
		String v2 = "11";
		System.out.println(compareVersion(v1, v2));
	}
}
