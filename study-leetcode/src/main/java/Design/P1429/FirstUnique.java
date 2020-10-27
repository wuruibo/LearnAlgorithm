package Design.P1429;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 获取出现次数为1的元素
 */
class FirstUnique {
    Set<Integer> unique = new LinkedHashSet<>();
    Set<Integer> all = new HashSet<>();
    
    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if (unique.isEmpty()) {
            return -1;
        }
        return unique.iterator().next();
    }
    
    public void add(int value) {
        if (all.add(value)) {
            unique.add(value);
        } else {
            unique.remove(value);
        }
    }
}



/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */