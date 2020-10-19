package Contest.Contest34.Problem4;

import java.util.ArrayList;
import java.util.List;

class Fancy {
    private List<Integer> list;
    private final static Integer mod=1000000007;
    public Fancy() {
        list=new ArrayList<>();
    }

    public void append(int val) {
        list.add(val);
    }

    public void addAll(int inc) {
        for (int i = 0; i < list.size(); i++) {
            Integer integer=list.get(i);
            list.set(i,(integer+inc)%mod);
        }
    }

    public void multAll(int m) {
        for (int i = 0; i < list.size(); i++) {
            Integer integer=list.get(i);
            list.set(i,(integer*m)%mod);
        }
    }

    public int getIndex(int idx) {
        return idx<list.size()?list.get(idx):-1;
    }

    public static void main(String[] args) {
        Fancy fancy = new Fancy();
        fancy.append(2);   // 奇妙序列：[2]
        fancy.addAll(3);   // 奇妙序列：[2+3] -> [5]
        fancy.append(7);   // 奇妙序列：[5, 7]
        fancy.multAll(2);  // 奇妙序列：[5*2, 7*2] -> [10, 14]
        fancy.getIndex(0); // 返回 10
        fancy.addAll(3);   // 奇妙序列：[10+3, 14+3] -> [13, 17]
        fancy.append(10);  // 奇妙序列：[13, 17, 10]
        fancy.multAll(2);  // 奇妙序列：[13*2, 17*2, 10*2] -> [26, 34, 20]
        fancy.getIndex(0); // 返回 26
        fancy.getIndex(1); // 返回 34
        fancy.getIndex(2); // 返回 20
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */