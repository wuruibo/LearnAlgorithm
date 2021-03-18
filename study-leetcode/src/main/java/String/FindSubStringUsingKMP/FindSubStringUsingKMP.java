package String.FindSubStringUsingKMP;

/**
 * 通过kmp算法判断一个字符串中是否存在另一个子串
 * 字符串完全匹配
 * 贴个youtobe大牛的课程
 * Knuth–Morris–Pratt(KMP) Pattern Matching(Substring search)
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ&feature=youtu.be
 *
 * @author yqz
 * @autor yeqiaozhu.
 * @date 2019-05-05
 */
public class FindSubStringUsingKMP {

    public boolean subStringIs(String text,String pattern){
        //step1 生成pattern的数组,主要记录前后缀相同的位置，这样不用反复扫描text
        if(pattern ==null || pattern.length() ==0 || text ==null || text.length()==0){
            return false;
        }
        int[] indexs=new int[pattern.length()];
        for(int i=0,j=0;i<pattern.length();i++){
            if(j == 0 && i == 0){
                indexs[i]=0;
            }else {
                if(pattern.charAt(i) == pattern.charAt(j)){
                    indexs[i] = indexs[i-1]+1;
                    j++;
                }else {
                    while(j>=0){
                        if(j ==0){
                            indexs[i] = pattern.charAt(i) == pattern.charAt(j)?1:0;
                            break;
                        }else if(pattern.charAt(i) == pattern.charAt(j)){
                            indexs[i]= indexs[j]+1;
                            break;
                        }else {
                            j = indexs[j - 1];
                        }
                    }
                }
            }
        }
/*        for (int i = 0; i < indexs.length; i++) {
            System.out.print(indexs[i]);
        }*/
        //step2 通过生成的pattern的index数组辅助匹配子串是否在父串中存在
        for(int i=0,j=0;i<text.length();i++){
            //匹配到不相等的情况 1.如果j已经是0的话那就i++ 2.如果j不是0的话就j继续回溯根据index数组
            if(pattern.charAt(j) != text.charAt(i)){
                if(j==0){
                    continue;
                }else {
                    j=indexs[j-1];
                }
            }else {
                if(j == pattern.length()-1){
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FindSubStringUsingKMP().subStringIs("ababcaababcaabc" ,"ababcaabc"));
    }
}
