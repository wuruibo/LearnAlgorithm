
package Design;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer,Integer>{
    private Integer capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    public int get(int key) {
        return super.get(key)==null?-1:super.get(key);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    /**
     * 重写方法
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size()<=this.capacity?false:true;
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));        // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));        // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}