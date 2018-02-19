#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    // string reverseString(string s) {
    //     if(s.size() <= 1) return s;
    //     string left = reverseString(s.substr(0, s.size() / 2));
    //     string right = reverseString(s.substr(s.size() / 2));
    //     return right + left;
    // }

    string reverseString(string s) {
    	int i = 0;
    	int j = s.size() - 1;
    	char temp;
        while(i <= j){
        	temp = s[i];
        	s[i] = s[j];
        	s[j] = temp;
        	i++;
        	j--;
        }
        return s;
    }
};

int main(){
	string s = "abcde";
	Solution sol;
	std::cout << sol.reverseString(s) << std::endl;
	return 0;
}