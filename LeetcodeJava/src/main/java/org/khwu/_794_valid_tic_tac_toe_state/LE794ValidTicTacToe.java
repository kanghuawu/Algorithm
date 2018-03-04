package org.khwu._794_valid_tic_tac_toe_state;

public class LE794ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {

        boolean[] won = new boolean[2];

        for (int j = 0; j < 3; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(board[i].charAt(j));
            }
            if (sb.toString().equals("XXX")) won[0] = true;
            if (sb.toString().equals("OOO")) won[1] = true;
        }

        cross(won, board);

        int[] steps = new int[2];
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("XXX")) won[0] = true;
            if (board[i].equals("OOO")) won[1] = true;
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') steps[0]++;
                else if (board[i].charAt(j) == 'O') steps[1]++;
            }
        }
        // System.out.println(Arrays.toString(won));
        // System.out.println(Arrays.toString(steps));
        if (!(steps[0] == steps[1] || steps[0] == steps[1] + 1)) return false;
        if (won[0] && steps[0] != steps[1] + 1) return false;
        if (won[1] && steps[0] != steps[1]) return false;
        return true;
    }

    private void cross(boolean[] won, String[] board) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(board[0].charAt(0));
        sb1.append(board[1].charAt(1));
        sb1.append(board[2].charAt(2));
        String s1 = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(board[0].charAt(2));
        sb2.append(board[1].charAt(1));
        sb2.append(board[2].charAt(0));
        String s2 = sb2.toString();
        if (s1.equals("XXX") || s2.equals("XXX")) won[0] = true;
        if (s1.equals("OOO") || s2.equals("OOO")) won[1] = true;
    }
}
