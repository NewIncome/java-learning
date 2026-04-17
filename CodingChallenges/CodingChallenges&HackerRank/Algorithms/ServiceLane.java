import java.util.ArrayList;
import java.util.List;

public class ServiceLane {

  public static List<Integer> serviceLane(int n, List<Integer> width, List<List<Integer>> cases) {
    // Write your code here
        //0. variable, List<> maxWidthVehicles
        //1. get case1 entry = i-1, exit = [j-1] index value
        //2. return the min value in the range, for each case
        //3. return the maxWidthVehicles
        List<Integer> maxWidthVehicles = new ArrayList<>();
        System.out.println(width);
        for(List<Integer> cs : cases) {
            maxWidthVehicles.add(getMin(width, cs.get(0), cs.get(1)));
        }
        return maxWidthVehicles;
    }
    
    public static int getMin(List<Integer> width, int a, int b) {
        int minValue = Integer.MAX_VALUE;
        //System.out.println("sublist("+a+","+b+"): " + width.subList(a, b));
        for(int i : width.subList(a, b+1))
            minValue = Math.min(minValue, i);
        
        return minValue;
    }

}
