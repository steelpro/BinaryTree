class Node {    
	 
     Node left, right;
     int data;  

     public Node() {    	 
         left = null;
         right = null;
         data = 0;
     }

     public Node(int n) {
         left = null;
         right = null;
         data = n;
     }

     public void setLeft(Node n) {
         left = n;
     }
     public void setRight(Node n) {
         right = n;
     }

     public Node getLeft() {
         return left;
     }
     public Node getRight() {
         return right;
     }

     public void setData(int d) {
         data = d;
     }
     public int getData() {
         return data;
     }    
     
     public boolean remove(int value, Node parent) {

         if (value < this.data) { //left side of tree stores values of smaller size
               if (left != null)
                     return left.remove(value, this);
               else
                     return false;
         } 
         
         else if (value > this.data) { //right side stores values of larger size
               if (right != null)
                     return right.remove(value, this);
               else
                     return false;
         } 
         
         else { //if values are equal
               if (left != null && right != null) {
                     this.data = right.minValue();
                     right.remove(this.data, this);
               } 
               else if (parent.left == this) 
                     parent.left = (left != null) ? left : right;
               
               else if (parent.right == this) 
                     parent.right = (left != null) ? left : right;
               
               return true;
         }
     }     
     
     public int minValue() {    	 
         if (left == null)
             return data;
         else
        	 return left.minValue();
     }
 }