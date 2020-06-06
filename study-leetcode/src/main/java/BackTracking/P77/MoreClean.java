package BackTracking.P77;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2019-12-03
 */
public class MoreClean {
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n<k) k=n;
        backTracking(new ArrayList<>(),1,n,k);

        return result;
    }
    public void backTracking(List<Integer> temp,int start,int end,int target){
        if (temp.size()==target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= end; i++) {
            temp.add(i);
            backTracking(temp,i+1,end,target);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        new MoreClean().combine(4,2);
        new MoreClean().combine(4,4);
        new MoreClean().combine(4,5);
    }
}
