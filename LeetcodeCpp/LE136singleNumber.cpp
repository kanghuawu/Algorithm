#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
    	int single = 0;
        for(int i = 0; i < nums.size(); i++){
        	single ^= nums.at(i);
        }
    	return single;
    }

};

int main(){
	int arr[] = {1, 1, 2, 2, 3};
	vector<int> nums(&arr[0], &arr[0] + 5);
	Solution sol;
	std::cout << sol.singleNumber(nums) << std::endl;
	return 0;
}