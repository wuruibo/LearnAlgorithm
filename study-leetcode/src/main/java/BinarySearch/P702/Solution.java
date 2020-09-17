package BinarySearch.P702;


// This is ArrayReader's API interface.
// You should not implement it, or speculate about its implementation
interface ArrayReader {
    public int get(int index);
}

class Solution {
    public int search(ArrayReader reader, int target) {
        int start=0,end=Integer.MAX_VALUE;
        while (start <= end) {
            int mid=start+((end-start)>>1);
            if (reader.get(mid)>target) {
                end=mid-1;
            }else if(reader.get(mid)<target){
                start=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}