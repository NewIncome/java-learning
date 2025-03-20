/* Java program to compare the performance of 
 * different loop types for 
 * iterating over a large list
 */
import java.io.*;
import java.util.*;

class Geeks 
{
    public static void main(String[] args) 
    {

        List<Integer> list = new ArrayList<>();
        long startTime;
        long endTime;

        // Adding 1 million integers to the list
        for (int i = 0; i < 1000000; i++) 
        {
            list.add(i);
        }

        // Type 1: Using a for-each loop
        startTime = Calendar.getInstance().getTimeInMillis();
        for (int i : list) 
        {
            // Looping over each element
            int a = i;
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("For each loop :: " + (endTime - startTime) + " ms");

        // Type 2: Using list.size() in the loop condition (with precomputation)
        startTime = Calendar.getInstance().getTimeInMillis();
        int size = list.size();
        for (int j = 0; j < size; j++) 
        {
            // Accessing list elements using index
            int a = list.get(j);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Using collection.size() (precomputed) :: " + 
        (endTime - startTime) + " ms");

        // Type 3: Calculating the collection size before the loop (already optimized)
        startTime = Calendar.getInstance().getTimeInMillis();
        for (int j = 0; j < size; j++) 
        {
            // Accessing list elements using index
            int a = list.get(j);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("By calculating collection.size() first :: " + 
        (endTime - startTime) + " ms");

        // Type 4: Iterating the list in reverse order
        startTime = Calendar.getInstance().getTimeInMillis();
        for (int j = size - 1; j >= 0; j--) {
            // Accessing list elements in reverse
            int a = list.get(j);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Using [int j = size - 1; j >= 0; j--] (precomputed) :: " +
        (endTime - startTime) + " ms");
    }
}
