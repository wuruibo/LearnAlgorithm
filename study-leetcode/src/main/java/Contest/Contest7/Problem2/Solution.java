package Contest.Contest7.Problem2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> hashMap= new HashMap<>();
        String[] result=new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name=names[i];
            String nextName;
            //以当前key为前缀的目前最大的次数
            if (hashMap.containsKey(name)) {
                int count=hashMap.get(name);
                nextName=getDuplicated(name,++count);
                //主要为了防止未加入的元素中有存在和nextName冲突的元素
                while (hashMap.containsKey(nextName)){
                    nextName=getDuplicated(name,++count);
                }
                hashMap.put(name,count);
                hashMap.put(nextName,0);
            }else {
                nextName=name;
                hashMap.put(name,0);
            }
            result[i]=nextName;
        }
        return result;
    }
    private String getDuplicated(String folder,int count){
        return folder+"("+count+")";
    }

    public static void main(String[] args) {
        String[] strings = {"pes","fifa","gta","pes(2019)"};
        new Solution().getFolderNames(strings);

        String[] strings1 = {"gta", "gta(1)", "gta", "avalon"};
        new Solution().getFolderNames(strings1);

        String[] strings2 = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        new Solution().getFolderNames(strings2);


        String[] strings3 = {"wano","wano","wano","wano"};
        new Solution().getFolderNames(strings3);

    }
}