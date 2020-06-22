package Contest.Contest6.Problem2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String[] getFolderNames(String[] names) {
        Set<String> set= new HashSet<>();
        String[] result=new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name=names[i];

            int count=0;
            String folder=name;
            while (!set.add(name)) {
                name=getDuplicated(folder,++count);
            }

            result[i]=name;
        }
        return result;
    }
    private String getDuplicated(String folder,int count){
        return folder+"("+count+")";
    }

    public static void main(String[] args) {
        String[] strings = {""};
        new Solution().getFolderNames(strings);

        String[] strings1 = {"gta", "gta(1)", "gta", "avalon"};
        new Solution().getFolderNames(strings1);

        String[] strings2 = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        new Solution().getFolderNames(strings2);


        String[] strings3 = {"wano","wano","wano","wano"};
        new Solution().getFolderNames(strings3);
    }
}