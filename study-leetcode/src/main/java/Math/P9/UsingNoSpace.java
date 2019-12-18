package Math.P9;

/**
 * @autor yeqiaozhu.
 * @date 2019-12-18
 */
public class UsingNoSpace {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int newX=0,oldX=x;

        while (x != 0) {
            newX=newX*10+x%10;
            x=x/10;
        }

        return oldX==newX;

    }

}
