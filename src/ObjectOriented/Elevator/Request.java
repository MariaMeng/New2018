package ObjectOriented.Elevator;
import java.util.*;

/**
 * Created by apple on 10/25/18.
 */
public class Request {
    private static volatile Request instance;
    private TreeSet<Integer> set;
    private Request () {
        set = new TreeSet<>();
    }

    public static Request getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Request();
                }
            }
        }
        return instance;
    }
    public void addRequest(int floor) {
        set.add(floor);
    }
    public void removeRequest(int floor) {
        set.remove(floor);
    }
    public int getNextFloor(int curFloor, int dir) {
        if (set.isEmpty() || dir == 0) return curFloor;
        if (dir > 0)
            return set.higher(curFloor);
        else
            return set.lower(curFloor);
    }

}
