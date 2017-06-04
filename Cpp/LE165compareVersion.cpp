/* strchr example */
#include  <iostream>
#include <stdio.h>
#include <string.h>
#include <algorithm>
using namespace std;

class Solution {
public:
    int compareVersion(string version1, string version2);
};

int Solution::compareVersion(string version1, string version2) {
    int len = 3;
    // max(count(version1.begin(), version1.end(), "."), count(version2.begin(), version2.end(), "."));
    int i=0;
    
    while(i<len)
    {
      int dot1=version1.find('.');
      int dot2=version2.find('.');
      if(dot1>version1.length()) version1+=".0"; dot1=version1.find('.');
      if(dot2>version2.length()) version2+=".0"; dot2=version2.find('.');

      int v1 = stoi(version1.substr(0, dot1));
      int v2 = stoi(version2.substr(0, dot2));
      
      if(v1>v2) return 1;
      if(v1<v2) return -1;
      version1=version1.substr(dot1+1);
      version2=version2.substr(dot2+1);
      i++;
    }
    return 0;
}

int main () {
    Solution sol;
    string a = "1.0.1";
    string b = "a.b.c";
    // cout << count(b.begin,b.end,".");
    // cout << sol.compareVersion(a, b) << endl;
    cout << "test" << endl;
    return 0;
}