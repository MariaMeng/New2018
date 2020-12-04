package Date.Nov.Nov10th2019;

import java.util.*;

/**
 * Created by apple on 11/10/19.
 */
public class Leetcode332 {

    public static List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) return new ArrayList<String>();

        List<String> res = new ArrayList<>();
        Map<String, List<String>> adj = new HashMap<>();

        for (List<String> ti: tickets) {
            String src = ti.get(0);
            String dst = ti.get(1);

            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(dst);
        }

        helper("JFK", adj, res);
        return res;
    }

    public static void helper(String src, Map<String, List<String>> adj, List<String> res) {
        List<String> list = adj.get(src);

        if (list != null) {
            Collections.sort(list);

            while (list.size() != 0) {
                String str = list.get(0);
                list.remove(0);
                helper(str, adj, res);

            }
        }
        res.add(0, src);
    }

    public static void main(String[] args) {

        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("JFK", "SFO"));
        list.add(Arrays.asList("JFK", "CTL"));
        list.add(Arrays.asList("SFO", "JFK"));
        list.add(Arrays.asList("CTL", "BLY"));
        list.add(Arrays.asList("BLY", "JFK"));

        List<String> res = findItinerary(list);
        System.out.println(res);
    }
}
