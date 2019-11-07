package org.khwu;

import java.util.Arrays;

public class FourQueen{
    // ref: https://www.youtube.com/watch?v=xouin83ebxE&app=desktop
	// ref: http://algorithms.tutorialhorizon.com/backtracking-n-queens-problem-better-solution/
	int N;
    int[] queens;
    public FourQueen(int N){
    	this.N = N;
        this.queens = new int[N];
    }

    private boolean isSafe(int x, int y){
        for(int row=0; row<x; row++){
            if(queens[row]==y || row-queens[row]==x-y || row+queens[row]==x+y)
                return false;
        }
        return true;
    }

    private void findSolution(){
    	findSolution(0);
    }

    private void findSolution(int x) {
    	if(x == N) {
            this.printSolution();
            return;
    	}
        for(int y=0; y<N; y++){
            if(isSafe(x, y)){
                queens[x] = y;
                findSolution(x+1);
//                System.out.println(x + " " + y);
            }
        }
    }

    private void printSolution(){
        for(int num : queens){
            char[] row = new char[N];
            Arrays.fill(row, 'X');
            row[num] = 'Q';
            System.out.println(row);
        }
        System.out.println();
    }

    public static void main(String[] args){
        FourQueen fq = new FourQueen(4);
        fq.findSolution();

    }
}
