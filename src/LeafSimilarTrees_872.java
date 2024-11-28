import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees_872 {

	public static class TreeNode {
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
	
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<TreeNode> l1 = new ArrayList<>();
		findLeaves(root1, l1);
		
		ArrayList<TreeNode> l2 = new ArrayList<>();
		findLeaves(root2, l2);
		
		if (l1.size() != l2.size()) return false;
		for (int i = 0; i < l1.size(); i++) {
			int v1 = l1.get(i).val;
			int v2 = l2.get(i).val;
			if (v1 != v2) 
				return false;
		}
		
		return true;
    }
	
	void findLeaves(TreeNode root, List<TreeNode> leaves) {
		if (root == null) return;
		
		if (root.left == null && root.right == null) {
			leaves.add(root);
			return;
		}
		
		if (root.left != null) findLeaves(root.left, leaves);
		if (root.right != null) findLeaves(root.right, leaves);
	}
	
}
