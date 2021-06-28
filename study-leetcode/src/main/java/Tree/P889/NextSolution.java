package Tree.P889;

import CommonUtils.TreeNode;

import java.util.Arrays;

/**
 * @author yeqiaozhu.
 * @date 5/8/21
 */
public class NextSolution {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre==null || pre.length==0){
            return null;
        }
        //前序遍历根->左子树->右子树 后序遍历左子树->右子树->根
        //最左侧节点为根
        TreeNode root=new TreeNode(pre[0]);
        //pre[1]为左子树的根节点 找到post对应的节点的索引
        int index=-1;
        for (int i = 0; i < post.length-1; i++) {
            if(post[i]==pre[1]){
                index=i;
            }
        }
        //构造左子树数组和右子树数组
        int[] preLeft= Arrays.copyOfRange(pre, 1, index+2);
        int[] preRight=Arrays.copyOfRange(pre, index+2, pre.length);
        int[] postLeft=Arrays.copyOfRange(post, 0, index+1);
        int[] postRight=Arrays.copyOfRange(post, index+1, post.length-1);
        TreeNode left=constructFromPrePost(preLeft, postLeft);
        TreeNode right=constructFromPrePost(preRight, postRight);
        root.left=left;
        root.right=right;
        return root;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1}));
    }
}
