package Contest.Contest21.Problem1;

class Solution {
    public double average(int[] salary) {
        int small=salary[0],big=salary[0];
        double count=0;
        for (int i = 0; i < salary.length; i++) {
            if (salary[i]<small) {
                small=salary[i];
            }
            if (salary[i]>big) {
                big=salary[i];
            }
            count+=salary[i];
        }
        return (count-small-big)/(salary.length-2)*1.0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().average(new int[]{48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000, 33000, 28000, 4000, 54000, 67000, 6000, 1000, 11000}));
    }
}