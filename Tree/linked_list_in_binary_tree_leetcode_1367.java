public class linked_list_in_binary_tree_leetcode_1367{
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null)
            return false;
        return dfs(root,head)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }
    
    public boolean dfs(TreeNode root,ListNode head){
        if(head==null)
            return true;
        else if(root==null)
            return false;
        else
            return (root.val==head.val) && (dfs(root.left,head.next) || dfs(root.right,head.next));
    }

}