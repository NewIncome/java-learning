/**
 * There are a number of people who will be attending ACM-ICPC World Finals.
 * Each of them may be well versed in a number of topics. Given a list of
 * topics known by each attendee, presented as binary strings, determine the
 * maximum number of topics a 2-person team can know. Each subject has a
 * column in the binary string, and a '1' means the subject is known while
 * '0' means it is not. Also determine the number of teams that know the
 * maximum number of topics. Return an integer array with two elements.
 * The first is the maximum number of topics known, and the second is the
 * number of teams that know that number of topics.
 * • Input
 *  ♦ string topic: a string of binary digits
 * • Returns
 *  ♦ int[2]: the maximum topics and the number of teams that know that many topics
 * • Constraints
 *  ♦ 2 <= n <= 500    ,  is the number of attendees
 *  ♦ 1 <= m <= 500    ,  is the number of topics
 * • Example
 *  ♦ topics=["10101","11110","00010"]   //[5,1]
 *   These are all possible teams that can be formed:
 *    Members Subjects
 *    (1,2)   [1,2,3,4,5]
 *    (1,3)   [1,3,4,5]
 *    (2,3)   [1,2,3,4]
 *   In this case, the first team will know all 5 subjects. They are the only team 
 *   that can be created that knows that many subjects, so  is returned.
 * • TestCases
 *  ♦ topics=["10101","11100","11010","00101"]   //[5,2]
 *  ♦ topics=["11101","10101","11001","10111","10000","01110"]   //[5,6]
 */
/*
 * Pseudocode
 * ○ vars: List<Integer> maxTopicsTeams
 * ○ Double Loop
 *   ○ skip if j == i
 *   ○ do binaryOp: team1 OR team2
 *   ○ if binaryOp
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ACM_ICPCTeam {

  public static void main(String[] args) {
    //System.out.println(acmTeam(new ArrayList<>(List.of("10101","11110","00010"))));
    //System.out.println(acmTeam(new ArrayList<>(List.of("10101","11100","11010","00101"))));
    System.out.println(acmTeam(new ArrayList<>(List.of("11101","10101","11001","10111","10000","01110"))));
    Arrays.asList(String, "string");
  }//end main
  public static List<Integer> acmTeam(List<String> topic) {
    //Asume all the stringValues are of same length
    List<Integer> maxTopicsTeams = new ArrayList<>(2);

    String teamOrOp;
    int teamOrOpOnes = 0;

    maxTopicsTeams.add(0);
    maxTopicsTeams.add(0);

    for (int i = 0; i < topic.size(); i++) {
      for (int j = 1; j < topic.size(); j++) {

        teamOrOp = Integer.toBinaryString(Integer.parseInt(topic.get(i), 2) | Integer.parseInt(topic.get(j), 2));
        teamOrOpOnes = teamOrOp.length() - teamOrOp.replace("1", "").length();
        System.out.println("i: " + i + ", j: " + j + ", teamOrOp: " + teamOrOp + ", teamOrOpOnes: " + teamOrOpOnes);
        if(teamOrOpOnes > maxTopicsTeams.get(0)) {

          //System.out.println("Inside IF > 0");
          maxTopicsTeams.set(0, teamOrOpOnes);  // reset maxTopicsKnown
          maxTopicsTeams.set(1, 1);    // reset teamCount

        } else if(teamOrOpOnes == maxTopicsTeams.get(0)) {

          //System.out.println("Inside IF == 0");
          maxTopicsTeams.set(1, maxTopicsTeams.get(1) + 1);   //increment teamCount

        }
      }
      topic.remove(0);
    }

    return maxTopicsTeams;
  }//end acmTeam

}
