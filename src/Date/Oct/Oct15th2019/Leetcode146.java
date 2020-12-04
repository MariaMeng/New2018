package Date.Oct.Oct15th2019;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 10/16/19.
 */

class LRUCache {


    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode pre;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        ListNode (){}
    }

    Map<Integer, ListNode> map;
    ListNode head, tail;
    int cap;
    int count;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cap = capacity;

        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);

        remove(node);

        add(node);
        return node.val;

    }

    public void add(ListNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;

    }

    public void remove(ListNode node) {


        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = null;
        node.pre = null;
    }


    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (null != node) {

            node.val = value;

            remove(node);
            add(node);
        } else {

            node = new ListNode(key, value);
            if (count < cap) {

                map.put(key, node);
                add(node);
                count++;

            } else {

                int pKey = tail.pre.key;
                remove(tail.pre);
                add(node);

                map.remove(pKey);
                map.put(key, node);
            }
        }
    }
}
public class Leetcode146 {



    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);

        cache.put(2, 1);
        int res = cache.get(2);

    }
}
