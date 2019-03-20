package Cache;

import java.util.*;

/**
 * Created by apple on 10/15/18.
 */
public class LFUCache {
    class ListNode {
        int key;
        int value;
        int count;
        int seq;
        public ListNode (int key, int value, int count, int seq) {
            this.key = key;
            this.value = value;
            this.count = count;
            this.seq = seq;
        }
    }
    PriorityQueue<ListNode> pq ;
    HashMap<Integer, ListNode> map;
    int capacity, size, seq;

    /*
    * @param capacity: An integer
    */public LFUCache(int capacity) {
        // do intialization if necessary
        pq = new PriorityQueue<>(capacity, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.count != o2.count)
                    return o1.count - o2.count;
                else
                    return o1.seq - o2.seq;
            }
        });
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        seq++;
        if (map.containsKey(key)) {
            map.get(key).count++;
            map.get(key).value = value;
            map.get(key).seq = seq;
            pq.remove(map.get(key));
            pq.add(map.get(key));
        } else if (size < capacity){
            size++;
            ListNode node = new ListNode(key, value, 1, seq);
            map.put(key, node);
            pq.add(node);
        } else {
            ListNode rm = pq.poll();
            map.remove(rm.key);
            ListNode node = new ListNode(key, value, 1, seq);
            map.put(key, node);
            pq.add(node);
        }

    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        seq++;
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        node.count++;
        node.seq = seq;
        pq.remove(node);
        pq.add(node);
        return node.value;
    }
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);
        ArrayList<Integer> list = new ArrayList<>();
        lfu.set(1, 10);
        lfu.set(2, 20);
        lfu.set(3, 30);
        list.add(lfu.get(1));
        lfu.set(4, 40);
        list.add(lfu.get(4));
        list.add(lfu.get(3));
        list.add(lfu.get(2));
        list.add(lfu.get(1));
        lfu.set(5, 50);
        list.add(lfu.get(1));
        list.add(lfu.get(2));
        list.add(lfu.get(3));
        list.add(lfu.get(4));
        list.add(lfu.get(5));
        System.out.println(list);
    }
}
