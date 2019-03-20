package Test;

import java.util.*;
/**
 * Created by apple on 10/25/18.
 */
public class testReverseDigit {


    public static int findMaximumXOR(int[] nums) {
        // Write your code here
        int mask = 0;
        int max = 0;
        for(int i = 31; i >= 0; i--){
            Set<Integer> set = new HashSet<>();
            mask = mask | (1 << i);
            for(int num : nums) {
                set.add(num & mask);
            }
            int temp = max | (1 << i);
            for(int prefix : set) {
                if(set.contains(temp ^ prefix)) {
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {3, 10, 5, 25, 2, 8};
        int res = findMaximumXOR(data);
        System.out.println(res);
    }
}
