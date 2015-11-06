package lab7;

import java.util.*;
import java.io.*;


public class TestBinarySearchTree {

  public static void main(String[] args) {

      Integer[] num = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};
      // Create an empty BinaryTree
      BinarySearchTree<Integer> tree = new BinarySearchTree<>(num);
     
      Scanner input = new Scanner(System.in);
      System.out.println("\nEnter an element to search");
      Integer key = input.nextInt();
      System.out.println("Number of leaves in this tree: " + tree.getNumberOfLeaves());
      System.out.println("Inorder predecessor: " + tree.inorderPredecessor(key));
      ArrayList<Integer> list = new ArrayList<>();
      list = tree.path(key);
      System.out.println("Path to element: ");
      for (int i = 0; i < list.size(); i++) {
          System.out.print(list.get(i) + " ");
          
      }
      System.out.println("");
      
      System.out.println("Preorder traversal of this tree: ");
      tree.preorder();
      System.out.println("");
      System.out.println("Postorder traversal of this tree: ");
      tree.postorder();
      System.out.println("");
      System.out.println("Inorder traversal of this tree: ");
      tree.inorder();
      System.out.println("");
      
      System.out.println("Left subtree of this element: ");
      ArrayList<Integer> list2 = tree.leftSubTree(key);
      for (int i = 0; i < list2.size(); i++) {
          System.out.print(list2.get(i) + " ");
          
      }
      System.out.println("");
      
      System.out.println("Right subtree of this element: ");
      ArrayList<Integer> list3 = tree.rightSubTree(key);
      for (int i = 0; i < list3.size(); i++) {
          System.out.print(list3.get(i) + " ");
          
      }
      System.out.println("");
      
      System.out.println("\nEnter an element to delete");
      key = input.nextInt();
      if (tree.delete(key))
          System.out.println("Deletion successful");
      else
          System.out.println("Element not in tree.");
      System.out.println("Inorder: ");
      tree.inorder();
      
      System.out.println("Enter element to add: ");
      key = input.nextInt();
      tree.insert(key);
      
      System.out.println("Inorder: ");
      tree.inorder();
      
      //complete the code as suggested in the Lab document.
     
  }
}

/*
Enter an element to search
73
Number of leaves in this tree: 7
Inorder predecessor: 67
Path to element: 
67 87 73 
Preorder traversal of this tree: 
67 55 43 39 34 40 48 53 59 66 87 73 81 77 84 91 92 95 
Postorder traversal of this tree: 
34 40 39 53 48 43 66 59 55 77 84 81 73 95 92 91 87 67 
Inorder traversal of this tree: 
34 39 40 43 48 53 55 59 66 67 73 77 81 84 87 91 92 95 
Left subtree of this element: 

Right subtree of this element: 
81 77 84 

Enter an element to delete
5
Element not in tree.
Inorder: 
34 39 40 43 48 53 55 59 66 67 73 77 81 84 87 91 92 95 Enter element to add: 
30
Inorder: 
30 34 39 40 43 48 53 55 59 66 67 73 77 81 84 87 91 92 95
*/