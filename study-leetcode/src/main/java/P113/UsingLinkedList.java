package P113;

import P104.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 直接使用linkedList便于插入，不需要重新排序
 * @autor yeqiaozhu.
 * @date 2019-10-17
 */
public class UsingLinkedList {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> result=new ArrayList<>();
        if (root.left==null && root.right==null && root.val==sum) {
            List<Integer> list=new LinkedList<>();
            list.add(root.val);
            result.add(list);
            return result;
        }
        List<List<Integer>> leftResult=pathSum(root.left,sum-root.val);
        List<List<Integer>> rightResult=pathSum(root.right,sum-root.val);

        rightResult.forEach(integers -> integers.add(0,root.val));
        leftResult.stream().forEach(integers -> {
            integers.add(0,root.val);
            rightResult.add(integers);
        });

        return rightResult;

    }
}
