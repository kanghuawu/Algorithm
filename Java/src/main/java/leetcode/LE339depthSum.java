package leetcode;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class LE339depthSum {
//	public int depthSum(List<NestedInteger> nestedList) {
//        int re = 0;
//        for(NestedInteger item : nestedList ){
//            re += depthSumHelper(item, 1);
//        }
//        return re;
//    }
//    
//    public int depthSumHelper(NestedInteger item, int floor){
//        if(item.isInteger()){
//            return floor * item.getInteger();
//        }else{
//            int re = 0;
//            for(NestedInteger inneritem : item.getList()){
//                re += depthSumHelper(inneritem, floor + 1);
//            }
//            return re;
//        }
//    }
    
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    public int depthSum(List<NestedInteger> nestedList, int level) {
        int result = 0;
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result = result + (level * ni.getInteger());
            }else {
                result = result + depthSum(ni.getList(), level+1);
            }
        }
        return result;
    }
}
