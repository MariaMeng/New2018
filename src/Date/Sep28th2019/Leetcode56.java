package Date.Sep28th2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by apple on 9/28/19.
 */
public class Leetcode56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0 ; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (map.containsKey(s)) {
                map.put(s, map.get(s) - i - 1);
            } else {
                map.put(s, -i - 1);
            }

            if(map.containsKey(e)) {
                map.put(e, map.get(e) + i + 1);
            } else {
                map.put(e, i + 1);
            }
        }

        List<int[]> res = new ArrayList<>();
        int[] temp = new int[2];

        int sum = 0;
        int i = 0;
        boolean isInter = false;

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int p = entry.getKey();
            int value = entry.getValue();

            sum += value;

            if (i == 0) {
                if (sum == 0) {
                    res.add(new int[]{p, p});
                } else {
                    temp[0] = p;
                    isInter = true;
                }
            }

            else {
                if (sum == 0) {
                    if (!isInter) {
                        temp[0] = p;
                        temp[1] = p;

                    } else {
                        temp[1] = p;
                    }
                    res.add(new int[]{temp[0], temp[1]});
                    isInter = false;
                } else {
                    if (!isInter) {
                        temp[0] = p;
                        isInter = true;
                    }
                }
            }
            i++;
        }

        int[][] list = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            list[j][0] = res.get(j)[0];
            list[j][1] = res.get(j)[1];
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {0, 0}, {5, 5}};
        int[][] res = merge(intervals);

        for (int[] r: res) {
            System.out.println(r[0] + "," +  r[1]);
        }
    }

}
