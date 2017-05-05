import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* Zachary Betters
 * Project 9
 * CIS 211
 * 4/24/17 
 */

public class Driver {
	
	public static BinaryTree tree;
	
	public static void main(String[] args) throws IOException {     
		 storeFile();
		 showMenu();	
    }
	
	public static void storeFile() throws IOException {
		
		BufferedWriter numList = new BufferedWriter(new FileWriter("p9in-Zachary.txt"));
	    	
 		for (int i = 1; i <= 20; i++) {			
 			int ran = (int) (Math.random() * (100 - 1)) + 1;
 			numList.write(ran + "\r\n");
 		}             
 		
 		numList.close();
	}
	
	public static void showMenu() throws IOException {
		
		//prepare file to write to
		BufferedWriter fileOut = new BufferedWriter(new FileWriter("p9out-Zachary.txt"));
 		fileOut.write("Project 9 result output by Zachary Betters\r\n");
 		
 		@SuppressWarnings("resource")
 		Scanner scan = new Scanner(System.in);
         
 		//create binary tree to store integers
        tree = new BinaryTree(fileOut); 
         
        //import generated file
        Scanner numIn = new Scanner(new File("p9in-Zachary.txt"));     

        System.out.print("The generated input:\t");
        fileOut.write("The generated input:\t");
        
        //write out numbers generated from storeFile() method
        numIn.useDelimiter("\t|\r\n");
        while (numIn.hasNext()) {    
         	int num = numIn.nextInt();
        	tree.insert(num);
        	
         	System.out.print(num + " ");
        	fileOut.write(num + " ");        	
        }         
        numIn.close();
            
        //print and write orders (pre, in, and post)
        printOrders(fileOut);
        
        boolean cont = true;        
         
        while (cont) {
        	
        	//display menu, repeated until 6 is pressed
            System.out.println("\n\nChoose the following:\n");
            
            System.out.println("1 - Add a number into the tree");
            System.out.println("2 - Delete a number from the tree");
            System.out.println("3 - Preorder Traversal");
            System.out.println("4 - Inorder Traversal");
            System.out.println("5 - Postorder Traversal");
            System.out.println("6 - Exit");

            int choice = scan.nextInt();            

            switch (choice) {

 	           case 1: 
 	                System.out.println("Enter integer to insert: ");
 	                
 	                int newNum = scan.nextInt();
 	                tree.insert( newNum ); 
 	                
 	                fileOut.write("Add " + newNum);
 	                printOrders(fileOut);
 	                break;                          
 	
 	           case 2: 
 	                System.out.println("Enter integer to delete");
 	                
 	                int numDel = scan.nextInt();
 	                
 	                fileOut.write("Delete " + numDel);
 	                if (!tree.delete(numDel)) { //if no number found to delete
 	                	System.out.println("** Number is not found **");  
 	                	fileOut.write("\r\n** Number is not found **");
 	                }
 	                else
 	                	printOrders(fileOut);
 	                
 	                break;                                          
 	
 	           case 3: 
 	                System.out.print("\nPreorder traversal: "); tree.preorder();
 	                break;     
 	
 	           case 4: 
 	                System.out.print("\nInorder traversal: "); tree.inorder();
 	                break;  
 	            
 	           case 5:
 	            	System.out.print("\nPostorder traversal: "); tree.postorder(); 
 	            	break;
 	            
 	           case 6: 
 	            	System.out.println("Stopping...");
 	            	cont = false;
 	            	break;
 	            	
 	           default: 
 	                System.out.println("Incorrect option\n ");
 	                break;   
             }
         }        
         fileOut.close();
	}
	
	public static void printOrders(BufferedWriter fileOut) throws IOException {
		
		fileOut.write("\r\n\r\nPreorder traversal:\t"); System.out.print("\n\nPre order:\t"); 
        tree.preorder();
	        
        fileOut.write("\r\nInorder traversal:\t"); System.out.print("\nIn order:\t"); 
        tree.inorder();
	        
        fileOut.write("\r\nPostorder traversal:\t"); System.out.print("\nPost order:\t"); 
        tree.postorder(); 
        fileOut.write("\r\n\r\n");
	}
}