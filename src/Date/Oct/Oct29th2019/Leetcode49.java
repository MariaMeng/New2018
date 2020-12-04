package Date.Oct.Oct29th2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by apple on 10/29/19.
 */
public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        int n = strs.length;
        for (int i = 0; i < n; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);

            String s = String.valueOf(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
