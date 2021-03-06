/**
 * 
 */
package github.com.ErnestL1n;
import java.util.*;
/**
 * @author https://github.com/ErnestL1n
 *
 */
//Leetcode.701
class TreeNode{
	int value;
	TreeNode leftchild;
	TreeNode rightchild;
	TreeNode(){};
	TreeNode(int value){
		this.value=value;
	}
	TreeNode(int value,TreeNode leftchild,TreeNode rightchild){
		this.value=value;
		this.leftchild=leftchild;
		this.rightchild=rightchild;
	}
}
public class Insert_into_a_Binary_Search_Tree {

	/**
	 * @param args
	 */
	public static TreeNode BuildTree(Integer[] nodes) {
		if(nodes==null||nodes.length==0)return null;
		Queue<TreeNode> treenodequeue=new LinkedList<>();
		Queue<Integer> integerqueue=new LinkedList<>();
		for(int i=1;i<nodes.length;i++)integerqueue.offer(nodes[i]);
		TreeNode root=new TreeNode(nodes[0]);
		treenodequeue.offer(root);
		System.out.println("I am root ,value is "+root.value);
		while(!integerqueue.isEmpty()) {
			Integer leftvalue=integerqueue.isEmpty()?null:integerqueue.poll();
			Integer rightvalue=integerqueue.isEmpty()?null:integerqueue.poll();
			TreeNode current=treenodequeue.poll();
			if(leftvalue!=null) {
				TreeNode left=new TreeNode(leftvalue);
				current.leftchild=left;
				treenodequeue.offer(left);
				System.out.println("I am leftchild  of value "+current.value+" , my value is "+left.value);
			}
			if(rightvalue!=null) {
				TreeNode right=new TreeNode(rightvalue);
				current.rightchild=right;
				treenodequeue.offer(right);
				System.out.println("I am rightchild of value "+current.value+" , my value is "+right.value);
			}
		}
		return root;
	}
	
	public static int TreeSize(TreeNode root) {
		if(root==null)return 0;
		return 1+TreeSize(root.leftchild)+TreeSize(root.rightchild);
	}
	
	public static void PrintRebuildTree(TreeNode root) {
		if(root==null)return;
		Queue<TreeNode> treenodequeue=new LinkedList<>();
		int getTreeSize=TreeSize(root);
		treenodequeue.offer(root);
		System.out.println("I am root ,value is "+root.value);
		getTreeSize--;
		while(getTreeSize!=0) {
			TreeNode current=treenodequeue.poll();
			if(current.leftchild!=null) {
				treenodequeue.offer(current.leftchild);
				System.out.println("I am leftchild  of value "+current.value+" , my value is "+current.leftchild.value);
				getTreeSize--;
			}
			if(current.rightchild!=null) {
				treenodequeue.offer(current.rightchild);
				System.out.println("I am rightchild of value "+current.value+" , my value is "+current.rightchild.value);
				getTreeSize--;
			}
		}
		
	}
	
	
	public static TreeNode insertIntoBST(TreeNode root, int val) {
		//empty tree,new node be the root
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        if(val<root.value)root.leftchild=insertIntoBST(root.leftchild,val);
        else if(val>root.value)root.rightchild=insertIntoBST(root.rightchild,val);
        
        return root;
    }
	
	
	public static void main(String[] args) {
		Integer[] nodes=new Integer[] {4,2,7,1,3,null,null};
		int insertvalue=5;
		System.out.println("We are distinct nodes with different values (Original Tree)");
		TreeNode root=BuildTree(nodes);
		TreeNode newroot=insertIntoBST(root,insertvalue);
		System.out.println("\nTree after insertion (insertvalue:"+insertvalue+")");
		PrintRebuildTree(newroot);
	
	}

}
