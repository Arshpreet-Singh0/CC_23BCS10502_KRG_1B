import java.util.*;

public class 43A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> teamGoals = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String team = sc.next();
            teamGoals.put(team, teamGoals.getOrDefault(team, 0) + 1);
        }
        
        int maxGoals = 0;
        String winningTeam = "";
        for (Map.Entry<String, Integer> entry : teamGoals.entrySet()) {
            if (entry.getValue() > maxGoals) {
                maxGoals = entry.getValue();
                winningTeam = entry.getKey();
            }
        }
        System.out.println(winningTeam);
    }
}