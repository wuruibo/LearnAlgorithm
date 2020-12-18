package Array.P941;

class Solution {
    public boolean validMountainarrrray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int i = 0;
        int j = n - 1;
        while (i + 1 < n && arr [i] < arr[i+1]) {
            i++;
        }
        while (j - 1 >= 0 && arr [j] < arr[j-1]) {
            j--;
        }
        if (i == j && i != 0 && j != n - 1) {
            return true;
        }
        return false;
    }
}