import java.io.BufferedWriter;
import java.io.IOException;

class BinaryTree {

	 private Node root;
	 BufferedWriter file;
	 
     public BinaryTree(BufferedWriter fileIn) {
    	 file = fileIn;
    	 root = null;
     }

     public boolean isEmpty() {
         return root == null;
     }

     public void insert(int data) {

    	Node newNode = new Node(data);
    	
 		if (root == null) { //if tree is empty
 			root = newNode; //assign new node to root
 			return;
 		}
 		
 		Node current = root;
 		Node parent = null;
 		
 		while (true) {
			
 			parent = current;
 			
 			if (data < current.data) { //left side is smaller				
 				current = current.left;
 				
 				if (current == null){
 					parent.left = newNode;
 					return;
 				}			
 			}
 			else { //else its on the right side
 				current = current.right;
 				
 				if (current == null) {
 					parent.right = newNode;
 					return;
 				}
 			}
 		}
     }     
     
     public boolean delete(int data) {
    	 
    	 if (root == null) //cant delete if tree is empty
             return false;
    	 
    	 else {
             if (root.getData() == data) {
            	 
                   Node auxRoot = new Node(0);

                   auxRoot.setLeft(root);

                   boolean result = root.remove(data, auxRoot);
                   root = auxRoot.getLeft();
                   return result;

             } 
             else 
            	 return root.remove(data, null);           
    	 }
     }

     public int countNodes() {
         return countNodes(root);
     }
     
     private int countNodes(Node r) {

         if (r == null)
             return 0;
         
         else {
             int l = 1;
             
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             
             return l;
         }
     }

     public boolean search(int val) {
         return search(root, val);
     }

     private boolean search(Node r, int val) {

         if (r.getData() == val)
             return true;

         if (r.getLeft() != null)
             if (search(r.getLeft(), val))
                 return true;

         if (r.getRight() != null)
             if (search(r.getRight(), val))
                 return true;

         return false;         
     }
     
     public void preorder() throws IOException {
         preorder(root);
     }

     private void preorder(Node r) throws IOException {
 
         if (r != null) {
             System.out.print(r.getData() + " ");
             file.write(r.getData() + " ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     public void inorder() throws IOException {
         inorder(root);
     }

     private void inorder(Node r) throws IOException {

         if (r != null) {
             inorder(r.getLeft());
             System.out.print(r.getData() + " ");
             file.write(r.getData() + " ");
             inorder(r.getRight());
         }
     }  

     public void postorder() throws IOException {
         postorder(root);
     }

     private void postorder(Node r) throws IOException {
    	 
         if (r != null) {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() + " ");
             file.write(r.getData() + " ");
         }
     }     
 }
