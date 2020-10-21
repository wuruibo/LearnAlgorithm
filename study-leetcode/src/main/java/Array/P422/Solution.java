package Array.P422;

import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        char [][]arr = new char[words.size()][words.size()];
        for(int i=0; i<words.size(); i++){
            char []temp = words.get(i).toCharArray();
            //如果列数大于行数直接返回false
            if(temp.length > words.size()) {
                return false;
            }
            for(int j=0; j<temp.length; j++){
                arr[i][j] = temp[j];
            }
        }
        for(int i=0; i<words.size(); i++){
            for(int j=0; j<i; j++){
                if(arr[i][j] != arr[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
