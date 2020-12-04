package Date.Mar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mengxiang
 * @date 20/3/29
 */
class UndergroundSystem {

    class CheckIn {
        String stationName; //进站名称
        int time; // 进站时间戳

        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    Map<Integer, CheckIn> in; // key: 用户id, value: 进站中的 车站名称和 时间戳
    Map<String, Map<String, List<Integer>>> map; // key: 进站名称， key: 出站名称 value: 耗时
    public UndergroundSystem() {
        in = new HashMap<>();
        map = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        // 1. in中记录入站时间和 地铁站名称
        CheckIn checkin = in.get(id);
        if (checkin == null) {
            checkin = new CheckIn(stationName, t);
            in.put(id, checkin);
        } else {
            checkin.time = t;
            checkin.stationName = stationName;
        }

    }

    public void checkOut(int id, String stationName, int t) {
        // 1. 在in中查询入站的信息
        CheckIn checkin = in.get(id);
        if (checkin == null) return;
        String inStation = checkin.stationName;
        int start = checkin.time;

        int duration = t - start;
        if (duration <= 0) return;
        // 2. 更新耗时
        Map<String, List<Integer>> out = map.get(inStation);
        if (out == null) {
            out = new HashMap<>();
            map.put(inStation, out);
        }
        List<Integer> list = out.get(stationName);
        if (list == null) {
            list = new ArrayList<>();
            out.put(stationName, list);
        }

        list.add(duration);

    }

    public double getAverageTime(String startStation, String endStation) {
        // 1. 获取耗时序列：
        Map<String, List<Integer>> out = map.get(startStation);
        if (out == null) {
            return 0;
        }
        List<Integer> list = out.get(endStation);
        if (list == null || list.size() == 0) {
            return 0;
        }
        double res  =0;
        for (int t: list) {
            res += t;
        }
        res = res / list.size();
        return res;
    }
}
public class Leetcode5370 {


}
