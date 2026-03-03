/**
 * Given a sequence of integers a, a triplet (a[i],a[j],a[k]) is beautiful if:
 * • i < j < k
 * • a[j] - a[i] == a[k] - a[j] == d
 * Given an increasing sequenc of integers and the value of , count the number
 * of beautiful triplets in the sequence.
 * • Input
 *  - int d: the value to match
 *  - int arr[n]: the sequence, sorted ascending
 * • Returns
 *  - int: the number of beautiful triplets
 * • Example
 *  - d = 1, arr = [2,2,3,4,5]  //3
 * • TestCase
 *  - d = 3, arr = [1,2,4,5,7,8,10]  //3
 */
/*
   Pseudocode
   ○ Conditions:  i < j < k
                  a[j] - a[i] == a[k] - a[j] == d
   ○ Option #1:  O(n^3) , triple for loop
 */
import java.util.List;

public class BeautifulTriplets {

  public static void main(String[] args) {
  }

  //Time Limit Exceeded, passed (6/11)
  public static int beautifulTriplets(int d, List<Integer> arr) {
    int numberBT = 0;

    for (int i = 0; i < arr.size()-2; i++) {
      for (int j = i+1; j < arr.size()-1; j++) {
        if(arr.get(j) - arr.get(i) > d) break;  //condition to not check the whole array
        for (int k = j+1; k < arr.size(); k++) {
          if(arr.get(i) < arr.get(j) &&
             arr.get(j) < arr.get(k) &&
             arr.get(j) - arr.get(i) == arr.get(k) - arr.get(j) &&
             arr.get(k) - arr.get(j) == d) {
            numberBT += 1;
          }
        }
      }
    }

    return numberBT;
  }

}
