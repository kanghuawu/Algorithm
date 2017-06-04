#include <iostream>
#include <string>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2);
};
ListNode* Solution::addTwoNumbers(ListNode* l1, ListNode* l2) {
	ListNode *dummy = new ListNode(0);
	ListNode *node;
	node = dummy;
	int newval;
	bool inc = false;
	while(l1 != NULL || l2 != NULL || inc){
		newval = inc ? 1 : 0;
		if(l1 != NULL){
			newval += l1->val;
			l1 = l1->next;
		}
		if(l2 != NULL){
			newval += l2->val;
			l2 = l2->next;
		}
		inc = newval >= 10 ? true : false;
		node->next = new ListNode(newval % 10);
		node = node->next;
	}
	node = NULL;
	return dummy->next;
}

void printList(ListNode* head){
	while(head != NULL){
		cout << head->val << " ";
		head = head->next;
	}
	cout << endl;
}
int main(){
	ListNode *l1 = new ListNode(1);
	ListNode *l2 = new ListNode(2);
	ListNode *l3 = new ListNode(3);
	ListNode *l4 = new ListNode(6);
	ListNode *l5 = new ListNode(9);
	l1->next = l2;
	l2->next = l3;
	l3->next = l4;
	l4->next = l5;
	ListNode *l11 = new ListNode(1);
	ListNode *l12 = new ListNode(2);
	ListNode *l13 = new ListNode(3);
	ListNode *l14 = new ListNode(4);
	l11->next = l12;
	l12->next = l13;
	l13->next = l14;
	// printList(l1);
	Solution sol;
	ListNode *test = sol.addTwoNumbers(l1, l11);
	printList(test);
	return 0;
}