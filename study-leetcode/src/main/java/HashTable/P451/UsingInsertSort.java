package HashTable.P451;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 不采用treeMap重新排序
 * 采用插入排序
 *
 * @autor yeqiaozhu.
 * @date 2020-01-16
 */
public class UsingInsertSort {
    public String frequencySort(String s) {
        Map<Character,Integer> result=Solution.countMap(s);

        List<Map.Entry<Character,Integer>> temp= new LinkedList<>();
        Iterator<Map.Entry<Character,Integer>> iterator=result.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character,Integer> entry=iterator.next();
            temp.add(insertSort(temp,entry),entry);
        }

        StringBuilder stringBuilder=new StringBuilder();
        for (Map.Entry<Character, Integer> entry : temp) {
            for (Integer integer = 0; integer < entry.getValue(); integer++) {
                stringBuilder.append(entry.getKey());
            }
        }
        return stringBuilder.toString();

    }
    public int insertSort(List<Map.Entry<Character,Integer>> temp,Map.Entry<Character,Integer> insertObject){
        //用二分的方式找到index位置
        int start=0,end=temp.size()-1;
        while (start<=end){
            int mid=start+(end-start)/2;

            if (insertObject.getKey()>= temp.get(mid).getKey()) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new UsingInsertSort().frequencySort("tree"));
        System.out.println(new UsingInsertSort().frequencySort("a"));
        System.out.println(new UsingInsertSort().frequencySort("cccaaa"));
        System.out.println(new UsingInsertSort().frequencySort("Aabb"));
    }
}
