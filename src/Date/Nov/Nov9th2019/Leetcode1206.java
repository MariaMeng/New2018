package Date.Nov.Nov9th2019;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by apple on 11/9/19.
 */
class Skiplist1 {

    private SkipListEntry head;  // First Entry of the top level
    private SkipListEntry tail;
    private Integer levels;

    static class RandomGenerator{

        private static Random random = new Random();

        public static boolean getRandomBoolean(float probability){
            return random.nextFloat() < probability;
        }
    }

    //SkipListEntry as a Set Entry
    class SkipListEntry{
        Integer value;

        SkipListEntry up;
        SkipListEntry down;
        SkipListEntry left;
        SkipListEntry right;

        // constructor
        public SkipListEntry(Integer value) {
            this.value = value;
        }

        //Getter
        public Integer getValue(){
            return this.value;
        }

    }

    private static void insertEntryAfterHorizontally(SkipListEntry source, SkipListEntry target){
        target.left = source;
        target.right = source.right;
        source.right.left = target;
        source.right = target;
    }
    private static void insertEntryAfterVertically(SkipListEntry source, SkipListEntry target){
        source.down = target;
        target.up = source;
    }


    // constructor
    public Skiplist1() {

        head = new SkipListEntry(null);
        tail = new SkipListEntry(null);

        head.right = tail;
        tail.left = head;

        levels = 0;
    }

    private SkipListEntry findEntry(Integer value, SkipListEntry startEntry){

        // iterate through the linkedlist of current Level .
        SkipListEntry cur= startEntry;
        while(cur.right.getValue() != null && cur.right.getValue() <= value){
            cur = cur.right;
        }


        // if lower layer exists, find the entry at lower layer
        if(cur.down != null){
            return findEntry(value, cur.down);
        }


        return cur;
    }

    /**
     * slipList 新增一层
     */
    private void createEmptyLevel() {

        SkipListEntry newHeader = new SkipListEntry(null);
        SkipListEntry newTail = new SkipListEntry(null);

        newHeader.right = newTail;
        newTail.left = newHeader;

        //Create connections
        insertEntryAfterVertically(newHeader,this.head);
        insertEntryAfterVertically(newTail,this.tail);


        //Update head and tail
        this.head = newHeader;
        this.tail = newTail;

        this.levels += 1;

    }

    /**
     * 搜索 target, 判断是否查找到
     * @param target
     * @return
     */
    public boolean search(int target) {

        SkipListEntry searchingResult = findEntry(target, this.head);

        if(searchingResult.getValue() == null || searchingResult.getValue() != target){
            return false;
        }

        return true;
    }

    public void add(int num) {

        // 查找原跳表中 小于等于该元素的值的节点
        SkipListEntry searchingResult = findEntry(num, this.head);

        SkipListEntry newEntry = new SkipListEntry(num);

        insertEntryAfterHorizontally(searchingResult, newEntry);

        int curLevel = 1;
        // add redundant values by flipping coins
        while(RandomGenerator.getRandomBoolean(0.5f)){

            // if the curLevel exceeds the range, create a new level
            if(curLevel > this.levels){
                createEmptyLevel();
            }

            // find the entry that has the same value at the upper layer
            while(searchingResult.up == null){
                searchingResult = searchingResult.left; //error
            }

            // find the insertion position at previous layer
            searchingResult = searchingResult.up;

            // insert duplicates
            SkipListEntry newEntryDuplicate = new SkipListEntry(num);

            // connections with the current layer
            insertEntryAfterHorizontally(searchingResult, newEntryDuplicate);
            // connections with previous result
            insertEntryAfterVertically(newEntryDuplicate,newEntry);

            newEntry = newEntryDuplicate;

            curLevel +=1;
        }
    }

    public boolean erase(int num) {

        SkipListEntry searchingResult = findEntry(num,this.head);
        SkipListEntry higherEntry = null;

        if(searchingResult.getValue() == null || searchingResult.getValue() != num){
            return false;
        }

        while(searchingResult != null){
            higherEntry = searchingResult.up;
            // remove the result at current layer
            searchingResult.left.right = searchingResult.right;
            searchingResult.right.left = searchingResult.left;
            // move to higher level Entry.
            searchingResult = higherEntry;
        }
        return true;
    }
}


class Skiplist {
    int MAX_LEVEL = 10;
    class SkipNode {
        int val;
        int level;
        SkipNode[] next;
        SkipNode (int val, int level) {
            this.val = val;
            this.level = level;
            next = new SkipNode[level + 1];
        }
    }

    SkipNode head;
    int ListLevel;
    Skiplist() {
        head = new SkipNode(Integer.MIN_VALUE, MAX_LEVEL);
        ListLevel = 0;
    }

    /**
     * 随机定义当前节点的高度（如果大于跳表高度，跳表高度自增）
     * @return
     */
    int getLevel() {
        int lev = 0;
        Random random = new Random();
        while (lev < MAX_LEVEL && lev <= ListLevel && random.nextFloat() < 0.5) {
            ++lev;
        }

        if (ListLevel < lev) ++ListLevel;
        return lev;
    }

    /**
     * search for the target value
     * @param target
     * @return
     */
    boolean search(int target) {
        SkipNode sn = head;
        int l1 = ListLevel;

        while (l1 >= 0) {
            while (sn.next[l1] != null && sn.next[l1].val <= target) sn = sn.next[l1];
            --l1;
        }

        if (sn.val == target) return true;
        return false;
    }

    void add(int num) {
        SkipNode sn = head;
        // return the random level of the new node
        int lev = getLevel();
        // get the current skiplist level
        int l1 = ListLevel;
        SkipNode nsn = new SkipNode(num, lev);
        while (l1 >= 0) {

            while (sn.next[l1] != null && sn.next[l1].val <= num) sn = sn.next[l1];
            // below the new node level ,insert the new node in each layer
            if (l1 <= lev) {
                nsn.next[l1] = sn.next[l1];
                sn.next[l1] = nsn;
            }
            --l1;
        }
    }

    boolean erase(int num) {
//        if (!search(num)) return false;

        SkipNode sn = head;
        SkipNode dsn = null;
        // get the list level
        int l1 = ListLevel;

        while (l1 >= 0) {
            while(sn.next[l1] != null && sn.next[l1].val < num) sn = sn.next[l1];


            if (l1 == 0) {
                if (sn.next[l1].val != num) return false;
                dsn = sn.next[l1];
            }

            // 删除当前layer的节点
            if (sn.next[l1] != null && sn.next[l1].val == num) {
                sn.next[l1] = sn.next[l1].next[l1];
            }

            --l1;
        }

        // 如果被删除的节点在最高层
        if (dsn.level == ListLevel) {
            if (head.next[ListLevel] == null) --ListLevel;
        }
        return true;
    }
}

public class Leetcode1206 {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
    }
}
