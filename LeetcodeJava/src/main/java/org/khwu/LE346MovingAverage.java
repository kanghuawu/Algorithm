package org.khwu;

import java.util.Deque;
import java.util.LinkedList;

public class LE346MovingAverage {
    //MY
//    private int size;
//    private Deque<Integer> deque;
//    /** Initialize your data structure here. */
//    public LE346MovingAverage(int size) {
//        this.size = size;
//        this.deque = new LinkedList<Integer>();
//    }
//
//    public double next(int val) {
//        if (this.deque.size() == this.size) {
//            deque.pop();
//        }
//        deque.add(val);
//        int sum = 0;
//        for (int num : deque) {
//            sum += num;
//        }
//        return (double) sum / this.deque.size();
//    }

    // MY
    private int size;
    private int sum;
    private Deque<Integer> deque;
    /** Initialize your data structure here. */
    public LE346MovingAverage(int size) {
        this.size = size;
        this.deque = new LinkedList<Integer>();
        this.sum = 0;
    }

    public double next(int val) {
        if (this.deque.size() == this.size) {
            this.sum -= deque.pop();
        }
        deque.add(val);
        this.sum += val;
        return (double) sum / this.deque.size();
    }

    public static void main(String[] args) {
        LE346MovingAverage obj = new LE346MovingAverage(5);
        double param_1 = obj.next(2);
        System.out.println(param_1);
        double param_2 = obj.next(5);
        System.out.println(param_2);
        double param_3 = obj.next(3);
        System.out.println(param_3);
        double param_4 = obj.next(6);
        System.out.println(param_4);
        double param_5 = obj.next(9);
        System.out.println(param_5);
        double param_6 = obj.next(8);
        System.out.println(param_6);
        double param_7 = obj.next(1);
        System.out.println(param_7);
    }
}
