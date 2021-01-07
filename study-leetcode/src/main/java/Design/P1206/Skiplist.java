package Design.P1206;

import java.util.ArrayList;
import java.util.List;

/**
 * Skiplist skiplist = new Skiplist();
 *
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 */
class Skiplist {

    class node {
        int val;
        node next, down;

        public node(int val, node next, node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }

    private node head;

    public Skiplist() {
        head = new node(-1, null, null);
    }

    public boolean search(int target) {
        node now = head;
        while (now != null) {
            while (now.next != null && now.next.val < target) {
                now = now.next;
            }
            if (now.next == null || now.next.val > target) {
                now = now.down;
            } else {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        List<node> list = new ArrayList<>();
        node now = head;
        while (now != null) {
            while (now.next != null && now.next.val < num) {
                now = now.next;
            }
            list.add(now);
            now = now.down;
        }

        node downNode = null;
        boolean insertUp = true;
        int index = list.size() - 1;

        while (insertUp && index >= 0) {
            node curInsert = list.get(index);
            list.remove(index--);
            curInsert.next = new node(num, curInsert.next, downNode);
            downNode = curInsert.next;
            int randint = (int) (1 + Math.random() * (10 - 1 + 1));
            //产生1-10的随机数（只要是偶数长度范围内的随机数即可）
            insertUp = (randint % 2 == 0 ? true : false);//50%的概率在上层插值
        }
        if (insertUp) {
            head = new node(-1, new node(num, null, downNode), head);
        }
    }

    public boolean erase(int num) {
        node now = head;
        boolean seen = false;
        while (now != null) {
            while (now.next != null && now.next.val < num) {
                now = now.next;
            }
            if (now.next != null && now.next.val <= num) {
                seen = true;
                now.next = now.next.next;
            }
            now = now.down;
        }
        return seen;
    }
}


/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */