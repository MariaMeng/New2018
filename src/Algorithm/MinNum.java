package Algorithm;
import java.util.*;

/**
 * Created by apple on 10/30/18.
 */
public class MinNum {
    public static String minNumber(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;

        String[] tmp = new String[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String O1 = o1 + o2;
                String O2 = o2 + o1;
                return O1.compareTo(O2);
            }
        });


        StringBuilder sb = new StringBuilder();
        for (String t : tmp) {
            sb.append(t);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] num = {3,32,321};
        System.out.println(minNumber(num));


        StringBuilder sb = new StringBuilder();
        sb.append(0);
        sb.append(0);
        sb.append(0);
        sb.append(1);
        System.out.println(sb.toString());
        sb.delete(0, 3);
        System.out.println(sb.toString());
        ArrayList<Integer> list = new ArrayList<>();
        list.size();

    }

}
