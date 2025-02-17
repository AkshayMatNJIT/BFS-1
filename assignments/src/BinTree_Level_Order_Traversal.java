import java.util.*;

public class BinTree_Level_Order_Traversal {

    // Approach: Use Queue to add elements in particular list at each level. Create a new list on every level.
    // Time: O(n)
    // Space: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());

            int lvl_length = queue.size();
            for (int i = 0; i<lvl_length; i++) {

                TreeNode node = queue.remove();

                levels.get(level).add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }