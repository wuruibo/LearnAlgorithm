package Design.P379;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

class PhoneDirectory {
    /**
     * 二叉树备忘录
     */
    private Map<Integer,Phone> phoneMap= new TreeMap<>();

    private static class Phone{
        private Integer phoneNumber;
        private AtomicBoolean flag;

        public Phone(Integer phoneNumber, AtomicBoolean flag) {
            this.phoneNumber = phoneNumber;
            this.flag = flag;
        }

        public Integer getPhoneNumber() {
            return phoneNumber;
        }

        public AtomicBoolean getFlag() {
            return flag;
        }
    }

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            phoneMap.put(i,new Phone(i,new AtomicBoolean(true)));
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for (Map.Entry<Integer, Phone> integerPhoneEntry : phoneMap.entrySet()) {
            AtomicBoolean flag=integerPhoneEntry.getValue().getFlag();
            if (flag.compareAndSet(true,false)) {
                return integerPhoneEntry.getKey();
            }
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number>phoneMap.size()) {
            return false;
        }
        return phoneMap.get(number).getFlag().get();
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (number>phoneMap.size()) {
            return;
        }
        AtomicBoolean flag=phoneMap.get(number).getFlag();
        flag.compareAndSet(false,true);
    }

    public static void main(String[] args) {
        // 初始化电话目录，包括 3 个电话号码：0，1 和 2。
        PhoneDirectory directory = new PhoneDirectory(3);

        // 可以返回任意未分配的号码，这里我们假设它返回 0。
        System.out.println(directory.get());

        // 假设，函数返回 1。
        System.out.println(directory.get());

        // 号码 2 未分配，所以返回为 true。
        System.out.println(directory.check(2));

        // 返回 2，分配后，只剩一个号码未被分配。
        System.out.println(directory.get());

        // 此时，号码 2 已经被分配，所以返回 false。
        System.out.println(directory.check(2));

        // 释放号码 2，将该号码变回未分配状态。
        directory.release(2);

        // 号码 2 现在是未分配状态，所以返回 true。
        System.out.println(directory.check(2));

    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */