import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    
    List<TreeNode> children;
    
    TreeNode(int val) {    this.val = val; }
    
    void addChild(TreeNode child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }
}

public class Google1 {
    private int helper(TreeNode parent, TreeNode node, int maxConPath) {
        if (node == null) {
            return maxConPath;
        }

        if (parent != null && node.val == parent.val + 1) {
            maxConPath++;
        } else {
            maxConPath = 1;
        }
        
        int max = maxConPath;
        
        System.out.println("max = " + max + "; node = " + node.val + "; parent :" + (parent == null ? "null" : parent.val)); 
        
        List<TreeNode> children = node.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                TreeNode child = children.get(i);
                int v = helper(node, child, maxConPath);
                if (v > max) {
                    max = v;
                }
            }
        }
        System.out.println("return : " + max);
        return max;
    }
    
    /**
     * Calculate most longest consecutive sequence in a tree
     * @param root
     * @return
     */
    public int mostConsecutivePath(TreeNode root) {
        return helper(null, root, 0);
    }
    
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        TreeNode l1_1 = new TreeNode(2);
        TreeNode l1_2 = new TreeNode(9);
        root.addChild(l1_1);
        root.addChild(l1_2);
        
        TreeNode l2_1 = new TreeNode(3);
        TreeNode l2_2 = new TreeNode(10);
        l1_1.addChild(l2_1);
        l1_2.addChild(l2_2);
        
        TreeNode l3_1 = new TreeNode(4);
        TreeNode l3_2 = new TreeNode(11);
        l2_1.addChild(l3_1);
        l2_2.addChild(l3_2);
        
        TreeNode l4_1 = new TreeNode(5);
        TreeNode l4_2 = new TreeNode(12);
        l3_1.addChild(l4_1);
        l3_2.addChild(l4_2);
        
        TreeNode l5_1 = new TreeNode(6);
        TreeNode l5_2 = new TreeNode(13);
        l4_1.addChild(l5_1);
        l4_2.addChild(l5_2);
        
        TreeNode l6_1 = new TreeNode(4);
        TreeNode l6_2 = new TreeNode(14);
        l5_1.addChild(l6_1);
        l5_2.addChild(l6_2);
        
        TreeNode l7_1 = new TreeNode(5);
        TreeNode l7_2 = new TreeNode(15);
        l6_1.addChild(l7_1);
        l6_2.addChild(l7_2);
        
        TreeNode l8_1 = new TreeNode(6);
        l7_1.addChild(l8_1);
        
        System.out.println(new Google1().mostConsecutivePath(root));
    }

}
