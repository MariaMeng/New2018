package Algorithm;
import java.util.*;

/**
 * Created by apple on 10/10/18.
 */
public class subSetII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup_B(int[] a) {
        List<List<Integer>> res = new ArrayList<>();

        if (null == a || a.length == 0) return res;

        Arrays.sort(a);

        powerSet(res, new ArrayList<>(), a, 0);

        return res;
    }

    private static void powerSet(List<List<Integer>> res, List<Integer> cur, int [] a, int start) {

        res.add(new ArrayList<>(cur));

        for (int i = start; i < a.length; i++) {
            if(i > start && a[i] == a[i - 1]) continue;
            cur.add(a[i]);
            powerSet(res, cur, a, i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> list = subsetsWithDup(nums);
        System.out.println(list);
    }
}
