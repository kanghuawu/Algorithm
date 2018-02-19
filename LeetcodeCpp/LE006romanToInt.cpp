#include <iostream>
#include <string>
#include <map>

using namespace std;

// class Solution {
// public:
// 	int singleRomToInt(char s){
// 	    int result = 0;
// 		switch(s){
// 			case 'I': 
// 			result = 1;
// 			break;
// 			case 'V': 
// 			result = 5;
// 			break;
// 			case 'X': 
// 			result = 10;
// 			break;
// 			case 'L': 
// 			result = 50;
// 			break;
// 			case 'C': 
// 			result = 100;
// 			break;
// 			case 'D': 
// 			result = 500;
// 			break;
// 			case 'M': 
// 			result = 1000;
// 			break;
// 		}
// 		return result;
// 	}
//     int romanToInt(string s) {
//         int result = 0;
//         for(int i = 0; i < s.size(); i++){
//         	if(i + 1 != s.size() && singleRomToInt(s.at(i)) < singleRomToInt(s.at(i + 1))){
//         		result -= singleRomToInt(s.at(i));
//         	}else{
//         		result += singleRomToInt(s.at(i));
//         	}
//         }
//         return result;
//     }
// };


class Solution {
public:
    int romanToInt(string s) {
    	map<char, int> RomToIntMap;
		RomToIntMap['I'] = 1;
		RomToIntMap['V'] = 5;
		RomToIntMap['X'] = 10;
		RomToIntMap['L'] = 50;
		RomToIntMap['C'] = 100;
		RomToIntMap['D'] = 500;
		RomToIntMap['M'] = 1000;
        int result = 0;
        for(int i = 0; i < s.size(); i++){
        	if(i + 1 != s.size() && RomToIntMap[s.at(i)] < RomToIntMap[s.at(i + 1)]){
        		result -= RomToIntMap[s.at(i)];
        	}else{
        		result += RomToIntMap[s.at(i)];
        	}
        }
        return result;
    }
};

int main(){
	Solution sol;
	cout << sol.romanToInt("X") << endl;;
}