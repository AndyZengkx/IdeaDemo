package main.practice;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SolutionTree {
    public int ans = 0;

    public TreeNode build(int[] list, int i) {
        if (list[i] == 1001)
            return null;
        if (i < (list.length - 1 >>> 1))
            return new TreeNode(
                    list[i],
                    build(list, 2 * i + 1),
                    build(list, 2 * i + 2)
            );
        else
            return new TreeNode(
                    list[i],
                    null,
                    null
            );
    }

    public int getAns(TreeNode root) {
        int right = 0, left = 0, cur = 1, resLeft = 1, resRight = 1;
        if (root.left == null && root.right == null) return 1;
        if (root.left != null) {
            left = longestUnivaluePath(root.left);
            if (root.val == root.left.val) {
                cur += left;
                resLeft = left + 1;
            }
        }
        if (root.right != null) {
            right = longestUnivaluePath(root.right);
            if (root.val == root.right.val) {
                cur += right;
                resRight = right + 1;
            }
        }
        ans = Math.max(ans, cur);
        return Math.max(resLeft, resRight);
    }

    public int longestUnivaluePath(TreeNode root) {
        getAns(root);
        return ans;
    }
}

public class BinaryTreeDebugTest {
    public static void main(String... args) {
        var inputData = new int[]{1, 4, 5, 4, 4, 1001, 5};
        SolutionTree solve = new SolutionTree();
        TreeNode root = solve.build(inputData, 0);
        System.out.println(solve.longestUnivaluePath(root));
    }
}
