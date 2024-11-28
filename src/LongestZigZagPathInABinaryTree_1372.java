public class LongestZigZagPathInABinaryTree_1372 {
	
	/**
	 * Definition for a binary tree node.
	 */
	static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	final int size = 1024 * 16;
	int[] path1 = new int[size];
	int[] path2 = new int[size];
	int len1 = -1, len2 = -1;
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	walkTree(root, p.val, q.val, path2, 0);
    	
    	int len = Math.min(len1, len2);
    	for (int idx = len - 1; idx >= 0; idx--) {
    		int a = path1[idx];
    		int b = path2[idx];
    		if (a == b) return new TreeNode(a);
    	}
    	
    	return null;
    }    
    
    void walkTree(TreeNode node, int p, int q, int path[], int pathLen) {
    	if (len1 != -1 && len2 != -1) return;
    	
    	int val = node.val;
    	path[pathLen++] = val;
    	
    	if (val == p || val == q) {
    		if (len1 == -1) storePath1(path, pathLen);
    		else {
                len2 = pathLen;
                return;
            }
    	}

    	if (node.left != null) walkTree(node.left, p, q, path, pathLen);
    	if (node.right != null) walkTree(node.right, p, q, path, pathLen);
    }
    
    void storePath1(int[] path, int pathLen) {
    	System.arraycopy(path, 0, path1, 0, pathLen);
		len1 = pathLen;
    }
    
    
    public static void main(String[] args) {
    	LongestZigZagPathInABinaryTree_1372 prog = new LongestZigZagPathInABinaryTree_1372();
		testCase3: {
			TreeNode t2 = new TreeNode(2);
			TreeNode t1 = new TreeNode(1); t1.left = t2;
			TreeNode res = prog.lowestCommonAncestor(t1, t1, t2);
			System.out.println(res.val);
		}
		
		testCase1: {
			TreeNode t5 = new TreeNode(5);
			TreeNode t1 = new TreeNode(1);
			TreeNode t3 = new TreeNode(3); t3.left = t5; t3.right = t1;
			TreeNode res = prog.lowestCommonAncestor(t3, t5, t1);
			System.out.println(res.val);
		}
	}
}
