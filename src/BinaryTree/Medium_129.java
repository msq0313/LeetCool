package BinaryTree;

import java.util.ArrayList;

/*
129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class Medium_129 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    int res;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> track = new ArrayList<>();
        dfs(root, track);
        return res;
    }

    public void dfs(TreeNode root, ArrayList<Integer> track) {
        if (root.left == null && root.right == null) {
            res += root.val;
            int n = 10;
            for (int i = track.size() - 1; i >= 0; i--) {
                res += track.get(i) * n;
                n *= 10;
            }
        }
        track.add(root.val);
        if (root.left != null) {
            dfs(root.left, track);
        }
        if (root.right != null) {
            dfs(root.right, track);
        }
        track.remove(track.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new Medium_129().sumNumbers(root));
    }

}