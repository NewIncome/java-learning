/**
 * An arcade game player wants to climb to the top of the leaderboard and track their ranking.
 * The game uses Dense Ranking, so its leaderboard works like this:
 *  + The player with the highest score is ranked number  on the leaderboard.
 *  + Players who have equal scores receive the same ranking number, and the next player(s) receive
 *    the immediately following ranking number.
 * • Example:
 *  ranked = [100,90,90,80]
 *  player = [70,80,105]
 * The ranked players will have ranks 1, 2, 2, and 3, respectively. If the player's scores are 70, 80
 * and 105, their rankings after each game are 4th, 3rd and 1st. Return [4,3,1].
 * 
 * • Needs_return:
 *  ♦ int[m]: the player's rank after each new score
 * 
 * • Constraints
 *  ♦ 1 <= n <= 2 x 10^5
 *  ♦ 1 <= m <= 2 x 10^5
 *  ♦ 0 <= ranked[i] <= 10^9 for 0 <= i < n
 *  ♦ 0 <= player[j] <= 10^9 for 0 <= j < m
 *  ♦ The existing leaderboard, ranked, is in descending order.
 *  ♦ The player's scores, player, are in ascending order.
 * 
 * • Subtask
 *   For 60% of the maximum score:
 *  ♦ 1 <= n <= 200
 *  ♦ 1 <= m <= 200
 * 
 * • Test Cases ()
 *  ♦ ranked = [100,50,40,40,20,10], player = [5,25,50,120]    //[6,4,2,1]  //;[1,2,3,3,4,5] [6,4,2,1]
 *  ♦ ranked = [100,90,90,80,75,60], player = [50,65,77,90,102]    //[6,5,4,2,1]
 */
/*
 * Pseudocode for result1()
 * - make variables: rankedNums[ranked.length], playerRanks[player.length]
 * - loop(start at i=1) through ranked arr and populate rankedNums arr with:
 *  - 1st one 1. And start from 2nd position
 *  - if ranked[i-1] == ranked[i] then rankedNums[i] = rankedNums[i-1] else rankedNums[i] = rankedNums[i-1] + 1
 * - then loop through player arr to populate playerRanks
 *  - ...missed...
 *  - if i == 0 && player[i] < ranked[ranked.length-i] then playerRanks[i] = rankedNums[ranked.length-i] - 1
 *  - else-if player[i] == ranked[ranked.length-i] then playerRanks[i] = rankedNums[ranked.length-i]
 * - return playerRanks
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ClimbingTheLeaderboard {

  public static void main(String[] args) {
    List<Integer> ranked1 = new ArrayList<>(Arrays.asList(100,90,90,80));
    List<Integer> player1 = new ArrayList<>(Arrays.asList(70,80,105));
    System.out.println(result2(ranked1, player1));
    System.out.println();

    List<Integer> ranked2 = new ArrayList<>(Arrays.asList(100,50,40,40,20,10));
    List<Integer> player2 = new ArrayList<>(Arrays.asList(5,25,50,120));
    System.out.println(result2(ranked2, player2));
    System.out.println();

    List<Integer> ranked3 = new ArrayList<>(Arrays.asList(100,90,90,80,75,60));
    List<Integer> player3 = new ArrayList<>(Arrays.asList(50,65,77,90,102));
    System.out.println(result2(ranked3, player3));
    System.out.println();
  }//end main

   public static List<Integer> result2(List<Integer> ranked, List<Integer> player) {
    ArrayList<Integer> leaderboard = (ArrayList<Integer>)ranked;
    ArrayList<Integer> playerScores = (ArrayList<Integer>)player;
    ArrayList<Integer> ranks = new ArrayList<Integer>();
    HashMap<Integer, Integer> rankings = new HashMap<>();   //<Scores, Rank>
    int rank = 1;

    for (int score : leaderboard) {
      if(rankings.containsKey(score) == false) {
        rankings.put(score, rank++);
      }
    }

    int initial = leaderboard.size() - 1;
    for (int score : playerScores) {
      for (int i = initial; i >= 0; i--) {
        System.out.println("score: " + score + ", i: " + i+ ", leaderboard.get(i): "
                            + leaderboard.get(i) + ", rankings.get(score): " + rankings.get(score)
                            + ", rankings: " + rankings);
        if(score >= leaderboard.get(i)) {
          rank = rankings.get(score);
          initial = i - 1;
        } else {
          break;
        }
      }
      ranks.add(rank);
    }
    return ranks;
   }//end result2

  public static List<Integer> result1(List<Integer> ranked, List<Integer> player) {  //passed(4/12)
    List<Integer> rankedNums = new ArrayList<>();
    List<Integer> playerRanks = new ArrayList<>();

    rankedNums.add(1);

    //to populate the rankedNums 
    for (int i = 1; i < ranked.size(); i++) {
      if(ranked.get(i-1) == ranked.get(i)) rankedNums.add(rankedNums.get(i-1));
      else rankedNums.add(rankedNums.get(i-1) + 1);
    }

    //to populate the player's ranks accordingly

    for (int i = 0; i < player.size(); i++) {
      for (int j = ranked.size()-1; j >=0; j--) {
        /* System.out.println("i: " + i + ", j: " + j + ", player.get(i):" + player.get(i) + " < "
                            + "ranked.get(j):" + ranked.get(j) + ", rankedNums: " + rankedNums); */
        if(player.get(i) == ranked.get(j)) {
          /* System.out.println("(was==)rankedNums.get(j) - 1: " + rankedNums.get(j)); */
          playerRanks.add(rankedNums.get(j));
          break;
        } else if(player.get(i) < ranked.get(j)) {
          /* System.out.println("(was<)rankedNums.get(j) - 1: " + (rankedNums.get(j) + 1)); */
          playerRanks.add(rankedNums.get(j) + 1);
          break;
        } else if(j == 0 && player.get(i) > ranked.get(j)) {
          /* System.out.println("(was>)rankedNums.get(j): " + (rankedNums.get(j))); */
          playerRanks.add(rankedNums.get(j));
          break;
        }
      }
    }

    return playerRanks;
  }//end result
}