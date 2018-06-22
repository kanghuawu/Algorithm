package org.khwu._825_friends_of_appropriate_ages;

public class LE825NumFriendRequests {
    public int numFriendRequests(int[] ages) {

        int[] bucket = new int[121];

        for (int i = 0; i < ages.length; i++) {
            bucket[ages[i]]++;
        }

        int[] acc = new int[121];
        for (int i = 1; i < 121; i++) {
            acc[i] = bucket[i] + acc[i-1];
        }

        int res = 0;
        for (int i = 15; i < 121; i++) {
            if (bucket[i] == 0) continue;
            res += (acc[i] - acc[i / 2 + 7]) * bucket[i] - bucket[i];
        }

        return res;
    }
}
