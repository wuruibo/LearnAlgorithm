package Contest.Contest20.Problem1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reformatDate(String date) {
        Map<String,String> monthMap= new HashMap<>();
        String[] months={"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < months.length; i++) {
            String number=i<9?"0"+(i+1):""+(i+1);
            monthMap.put(months[i],number);
        }
        StringBuilder result=new StringBuilder();
        String[] dateString=date.split(" ");
        result.append(dateString[2]).append("-");
        result.append(monthMap.get(dateString[1])).append("-");
        String day=dateString[0].substring(0, dateString[0].length()-2);
        day=day.length()==1?"0"+day:day;
        result.append(day);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reformatDate("20th Oct 2052"));
        System.out.println(new Solution().reformatDate("6th Jun 1933"));
        System.out.println(new Solution().reformatDate("26th May 1960"));
    }
}