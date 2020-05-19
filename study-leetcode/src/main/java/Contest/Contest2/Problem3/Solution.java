package Contest.Contest2.Problem3;

import java.util.*;

/**
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of favorites companies for the ith person (indexed from 0).
 *
 * Return the indices of people whose list of favorite companies is not a subset of any other list of favorites companies. You must return the indices in increasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * Output: [0,1,4]
 * Explanation:
 * Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the person with index 0.
 * Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] and favoriteCompanies[1]=["google","microsoft"].
 * Other lists of favorite companies are not a subset of another list, therefore, the answer is [0,1,4].
 * Example 2:
 *
 * Input: favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * Output: [0,1]
 * Explanation: In this case favoriteCompanies[2]=["facebook","google"] is a subset of favoriteCompanies[0]=["leetcode","google","facebook"], therefore, the answer is [0,1].
 * Example 3:
 *
 * Input: favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * Output: [0,1,2,3]
 */
class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> companies= new ArrayList<>();
        for (List<String> favoriteCompany : favoriteCompanies) {
            Set<String> set= new HashSet<>();
            for (String s : favoriteCompany) {
                set.add(s);
            }
            companies.add(set);
        }
        //循环
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
            List<String> param=favoriteCompanies.get(i);
            Boolean flag=false;
            for (int j = 0; j < companies.size(); j++) {
                if (j!=i && subSet(param,companies.get(j))) {
                    flag=true;
                    break;
                }
            }
            if (!flag) result.add(i);
        }

        return result;

    }
    private Boolean subSet(List<String> param,Set<String> parent ){
        if (param.size()>parent.size()) return false;
        for (String s : param) {
            if (!parent.contains(s)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] strings={{"leetcode","google","facebook"},{"google","microsoft"},{"google","facebook"},{"google"},{"amazon"}};
        List<List<String>> request=new ArrayList<>();
        for (String[] string : strings) {
            request.add(Arrays.asList(string));
        }
        System.out.println(new Solution().peopleIndexes(request).toString());

        String[][] strings1={{"leetcode","google","facebook"},{"leetcode","amazon"},{"facebook","google"}};
        List<List<String>> request1=new ArrayList<>();
        for (String[] string : strings1) {
            request1.add(Arrays.asList(string));
        }
        System.out.println(new Solution().peopleIndexes(request1).toString());

        String[][] strings2={};
        List<List<String>> request2=new ArrayList<>();
        for (String[] string : strings2) {
            request2.add(Arrays.asList(string));
        }
        System.out.println(new Solution().peopleIndexes(request2).toString());
    }
}