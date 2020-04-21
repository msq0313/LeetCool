package Basic;

import java.util.Stack;

public class TreePreOrder {

    //节点结构
    static class TreeNode
    {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value)
        {
            this.value = value;
        }
    }

    //以数组形式生成一棵完全二叉树
    public static void main(String[] args)
    {
        TreeNode[] node = new TreeNode[10];
        for(int i = 0; i < 10; i++)
        {
            node[i] = new TreeNode(i);
        }
        for(int i = 0; i < 10; i++)
        {
            if(i*2+1 < 10)
                node[i].left = node[i*2+1];
            if(i*2+2 < 10)
                node[i].right = node[i*2+2];
        }

        preOrderRe(node[0]);
    }

    //递归实现
    public static void preOrderRe(TreeNode biTree)
    {
        System.out.println(biTree.value);
        TreeNode leftTree = biTree.left;
        if(leftTree != null)
        {
            preOrderRe(leftTree);
        }
        TreeNode rightTree = biTree.right;
        if(rightTree != null)
        {
            preOrderRe(rightTree);
        }
    }

    //非递归实现
    public static void preOrder(TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                System.out.println(biTree.value);
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }
}