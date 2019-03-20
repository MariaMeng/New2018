package Cache;

import java.util.Deque;
import java.util.LinkedList;
import java.util.*;

/**
 * Created by apple on 10/15/18.
 */
public class LRUCache {

    class ListNode{
        public int key;
        public int val;
        public ListNode next;
        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private ListNode dummy,tail;
    private int capacity, size;
    private Map<Integer,ListNode> map;

    private void moveToTail(int key){
        ListNode pre = map.get(key);
        ListNode cur = pre.next;
        if(cur == tail) {
            return;
        }
        pre.next = pre.next.next;
        tail.next =  cur;
        cur.next = null;
        if(pre.next != null){
            map.put(pre.next.key, pre);
        }
        map.put(cur.key,tail);
        tail = cur;
    }



    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        dummy = new ListNode(0,0);
        tail = dummy;
        this.capacity = capacity;
        size =0;
        map = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)){
            return -1;
        }
        moveToTail(key);


        return tail.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(get(key) != -1){
            ListNode pre = map.get(key);
            pre.next.val = value;
            return;
        }
        if(size < capacity){
            ListNode newNode = new ListNode(key,value);
            tail.next = newNode;
            map.put(key,tail);
            tail = newNode;

            size++;
            return;
        }
        ListNode first = dummy.next;
        map.remove(first.key);
        first.key = key;
        first.val = value;
        map.put(key, dummy);

        moveToTail(key);

    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        List<Integer> list = new ArrayList<>();
        lru.set(2, 1);
        list.add(lru.get(2));
        lru.set(3, 2);
        list.add(lru.get(2));
        list.add(lru.get(3));
        System.out.println(list);
    }
}
