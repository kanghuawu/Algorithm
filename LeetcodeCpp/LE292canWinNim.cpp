
#include <iostream>

class Solution {
public:
    bool canWinNim(int n) {
        return n & 3;
    }
};

int main(){
	int n = 4;
	Solution sol;
	std::cout << std::boolalpha << sol.canWinNim(n) << std::endl;
	return 0;
}
