package Date.Oct.Oct16th2019;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

/**
 * Created by apple on 10/17/19.
 */

class LFUCache {

    HashMap<Integer, Integer> val;
    HashMap<Integer, Integer> fre;
    TreeMap<Integer, LinkedHashSet<Integer>> scoreMap;
    int cap, counter;

    public LFUCache(int capacity) {
        val = new HashMap<>(capacity);
        fre = new HashMap<>(capacity);
        scoreMap = new TreeMap<>();
        cap = capacity;
    }

    public int get(int key) {
       Integer value = val.get(key);
       if (null == value) {
           return -1;
       }

       int freq = fre.get(key);
       fre.put(key, freq + 1);
       LinkedHashSet<Integer> scoreSet = scoreMap.get(freq);
       scoreSet.remove(key);
       if (scoreSet.size() == 0) {
           scoreMap.remove(freq);
       }

       LinkedHashSet<Integer> newSet = scoreMap.get(freq + 1);
       if (null != newSet) {
           newSet.add(key);
       } else {
           newSet = new LinkedHashSet<>();
           newSet.add(key);
           scoreMap.put(freq + 1, newSet);
       }

       return value;
    }


    public void put(int key, int value) {
        if (cap == 0) return ;
        Integer orinV = val.get(key);
        if (null != orinV) {
            val.put(key, value);
            int freq = fre.get(key);
            fre.put(key, freq + 1);

            LinkedHashSet<Integer> scoreSet = scoreMap.get(freq);
            scoreSet.remove(key);
            if (scoreSet.size() == 0) {
                scoreMap.remove(freq);
            }

            LinkedHashSet<Integer> newSet = scoreMap.get(freq + 1);
            if (null != newSet) {
                newSet.add(key);
            } else {
                newSet = new LinkedHashSet<>();
                newSet.add(key);
                scoreMap.put(freq + 1, newSet);
            }
        } else {
            if (counter == cap && counter != 0) {
                LinkedHashSet<Integer> set = scoreMap.firstEntry().getValue();
                int rmKey = set.iterator().next();
                set.remove(rmKey);
                val.remove(rmKey);
                fre.remove(rmKey);
                counter--;
            }

            val.put(key, value);
            fre.put(key, 1);

            LinkedHashSet<Integer> newSet = scoreMap.get(1);
            if (null != newSet) {
                newSet.add(key);
            } else {
                newSet = new LinkedHashSet<>();
                newSet.add(key);
                scoreMap.put(1, newSet);
            }
            counter++;
        }
    }
}
public class Leetcode460 {



    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        int res;
        cache.put(0, 0);
        res = cache.get(0);
        System.out.println(res);


    }
}
