package DFS;

import java.util.LinkedList;
import java.util.List;

/*
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Simple_257 {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> res = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        String track = "";
        dfs(root, track);
        return res;
    }

    private void dfs(TreeNode root, String track) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(track);
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                res.add(sb.toString());
            } else {
                sb.append("->");
                dfs(root.left, sb.toString());
                dfs(root.right, sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> res = new Simple_257().binaryTreePaths(root);
        System.out.println(res);
    }

}
