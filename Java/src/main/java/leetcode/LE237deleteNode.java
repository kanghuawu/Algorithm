package leetcode;
import utility.ListNode;
public class LE237deleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String argp[]){
    	LE237deleteNode sol = new LE237deleteNode();
    	ListNode testList = ListNode.testList();
    	sol.deleteNode(testList.next.next.next);
    	while(testList != null){
    		System.out.print(testList.val);
    		testList = testList.next;
    	}
    	
    }
}
