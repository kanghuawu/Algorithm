package p23_baseball;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseballElimination {
    private final int numOfTeams;
    private final String[] teams;
    private final int[] win;
    private final int[] loss;
    private final int[] remain;
    private final int[][] graph;
    private final Map<String, Integer> find;
    private List<String> eliminated;
    private String currTeam;

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In in = new In(filename);
        numOfTeams = in.readInt();
        teams = new String[numOfTeams];
        win = new int[numOfTeams];
        loss = new int[numOfTeams];
        remain = new int[numOfTeams];
        graph = new int[numOfTeams][numOfTeams];
        find = new HashMap<>((int) (numOfTeams/0.75 + 1));

        int counter = 0;
        while (in.hasNextLine()) {
            teams[counter] = in.readString();
            find.put(teams[counter], counter);
            win[counter] = in.readInt();
            loss[counter] = in.readInt();
            remain[counter] = in.readInt();
            String[] line = in.readLine().trim().split("\\s+");
            for (int against = 0; against < line.length; against++) {
                graph[counter][against] = Integer.parseInt(line[against]);
            }
            counter++;
        }
    }

    // number of teams
    public int numberOfTeams() {
        return numOfTeams;
    }

    // all teams
    public Iterable<String> teams() {
        return Arrays.asList(teams);
    }

    // number of wins for given team
    public int wins(String team) {
        if (!find.containsKey(team)) throw new IllegalArgumentException();
        return win[find.get(team)];
    }

    // number of losses for given team
    public int losses(String team) {
        if (!find.containsKey(team)) throw new IllegalArgumentException();
        return loss[find.get(team)];
    }

    // number of remaining games for given team
    public int remaining(String team) {
        if (!find.containsKey(team)) throw new IllegalArgumentException();
        return remain[find.get(team)];
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        if (!find.containsKey(team1) || !find.containsKey(team2)) throw new IllegalArgumentException();
        return graph[find.get(team1)][find.get(team2)];
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        if (!find.containsKey(team)) throw new IllegalArgumentException();
        currTeam = team;
        int idx = find.get(team);
        int maxWin = win[idx] + remain[idx];
        eliminated = new ArrayList<>();
        for (int i = 0; i < numOfTeams; i++) {
            if (maxWin < win[i]) {
                eliminated.add(teams[i]);
                return true;
            }
        }

        int v = (numOfTeams - 1)*(numOfTeams - 2)/2 + numOfTeams + 2;
        FlowNetwork flowNetwork = new FlowNetwork(v);
        int s = v - 2;
        int t = v - 1;
        int gameVertex = numOfTeams;
        for (int i = 0; i < numOfTeams; i++) {
            if (i == idx) continue;
            // team vertices to t (sink)
            flowNetwork.addEdge(new FlowEdge(i, t, maxWin - win[i]));

            for (int j = i + 1; j < numOfTeams; j++) {
                if (j == idx) continue;

                // s (source) to game vertices
                flowNetwork.addEdge(new FlowEdge(s, gameVertex, graph[i][j]));

                // game vetices to team vertices
                flowNetwork.addEdge(new FlowEdge(gameVertex, i, Double.POSITIVE_INFINITY));
                flowNetwork.addEdge(new FlowEdge(gameVertex, j, Double.POSITIVE_INFINITY));
                gameVertex++;
            }
        }

        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, s, t);
        for (int i = 0; i < numOfTeams; i++) {
            if (i == idx) continue;
            if (fordFulkerson.inCut(i)) eliminated.add(teams[i]);
        }
        return !eliminated.isEmpty();
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        if (!find.containsKey(team)) throw new IllegalArgumentException();
        if (team.equals(currTeam) ) {
            if (eliminated == null || eliminated.isEmpty()) return null;
            return eliminated;
        }
        isEliminated(team);
        return certificateOfElimination(team);
    }

    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination(args[0]);
//        division.isEliminated("Philadelphia");
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}
