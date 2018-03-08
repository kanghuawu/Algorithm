package org.khwu._380_insert_delete_getrandom_o1;

import java.util.*;

public class RandomizedSet {

    private Random rand;
    private Map<Integer, Integer> dic;
    private List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        rand = new Random();
        dic = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dic.containsKey((val))) return false;
        dic.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!dic.containsKey(val)) return false;
        int i = dic.get(val);
        int num = nums.get(nums.size()-1);
        nums.set(i, num);
        dic.put(num, i);

        nums.remove(nums.size()-1);
        dic.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int i = rand.nextInt(nums.size());
        return nums.get(i);
    }
}
