package lab7;


import java.io.*;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

  protected TreeNode<E> root;
  protected int size = 0;

  /** Create a default binary tree */
  public BinarySearchTree() { }

  /** Create a binary tree from an array of objects */
  public BinarySearchTree(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]);
  }

  /** Returns true if the element is in the tree */
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return true; // Element is found
    }
    return false;
  }
  
  public boolean search(E e, int[] array) {
      int counter = 0;
      TreeNode<E> current = root;
      while (current != null) {
          counter++;
          if (e.compareTo(current.element) < 0) {
              current = current.left;
          }
          else if (e.compareTo(current.element) > 0) {
              current = current.right;
          }
          else {
              array[0] = counter;
              return true;
          }
      }
      array[0] = counter;
      return false;
  }


  /** Insert element o into the binary tree
   * Return true if the element is inserted successfully. 
   *  Uses an iterative algorithm
   */
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); // Create a new root
    else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        }
        else
          return false; // Duplicate node not inserted
          
      // Create the new node and attach it to the parent node
      if (e.compareTo(parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }
    size++;
    return true; // Element inserted
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<E>(e);
  }

  /** Inorder traversal from the root*/
  public void inorder() {
    inorder(root);
  }

  /** Inorder traversal from a subtree */
  protected void inorder(TreeNode<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }

   
  /** Postorder traversal from the root */
  public void postorder() {
    postorder(root);
  }

  /** Postorder traversal from a subtree */
  protected void postorder(TreeNode<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  /** Preorder traversal from the root */
  public void preorder() {
    preorder(root);
  }

  /** Preorder traversal from a subtree */
  protected void preorder(TreeNode<E> root) {
    if (root == null) return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  /** Inner class tree node */
  public static class TreeNode<E extends Comparable<E>> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E e) {
      element = e;
    }
  }

  /** Get the number of nodes in the tree */
  public int getSize() {
    return size;
  }

  /** Returns the root of the tree */
  public TreeNode getRoot() {
    return root;
  }
   
    /** Returns an ArrayList containing elements in the path from the root leading to the specified element, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> path(E e){
        java.util.ArrayList<E> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root
        //implement the code here as in search method.
        while (current != null) {
            list.add(current.element);
            if (e.compareTo(current.element) < 0) 
                current = current.left;
            else if (e.compareTo(current.element) > 0) 
                current = current.right;
            else 
                break;
        }
        return list; // Return an array of elements
  }
  
    
    /* Returns the number of leaf nodes in this tree, returns 0 if tree is empty*/
    public int getNumberOfLeaves(){
    //left for you to implement in Lab 7
        return getNumberOfLeaves(root);
    }
    protected int getNumberOfLeaves(TreeNode current) {
        if (current == null)
            return 0;
        else if (current.left == null && current.right == null)
            return 1;
        else
            return getNumberOfLeaves(current.left) + getNumberOfLeaves(current.right);
    }
    
    /* Returns an ArrayList containing all elements in preorder of the specified element’s left sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> leftSubTree(E e){
     java.util.ArrayList<E> list = new java.util.ArrayList<>();
     TreeNode<E> current = root;
     while (current != null) {
         if(e.compareTo(current.element) < 0) 
             current = current.left;
         else if (e.compareTo(current.element) > 0)
             current = current.right;
         else {
             preorder(current.left, list);
             break;
         }
     }
     return list;
    }
    
    protected void preorder(TreeNode current, ArrayList<E> list) {
        if (current == null) 
            return;
        list.add((E) current.element);
        preorder(current.left, list);
        preorder(current.right, list);
    }
    /* Returns an ArrayList containing all elements in preorder of the specified element’s right sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> rightSubTree(E e){
    //left for you to implement in Lab 7
        java.util.ArrayList<E> list = new java.util.ArrayList<>();
     TreeNode<E> current = root;
     while (current != null) {
         if(e.compareTo(current.element) < 0) 
             current = current.left;
         else if (e.compareTo(current.element) > 0)
             current = current.right;
         else {
             preorder(current.right, list);
             break;
         }
     }
     return list;
    }
    
    /* Returns the inorder predecessor of the specified element, returns null if tree is empty or element 'e' is not in the tree. */
    public E inorderPredecessor(E e){
    //left for you to implement in Lab 7
        TreeNode<E> current = root;
        TreeNode<E> parent = null;
        while (current != null) {
         if(e.compareTo(current.element) < 0) {
             current = current.left;
         } else if (e.compareTo(current.element) > 0) {
             parent = current;
             current = current.right;
         } else {
            TreeNode<E> rightMost = current.left;
            if (rightMost == null)
                return parent.element;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            return rightMost.element;
         }
     }
        return null;
    }
    
    
  /** Delete an element from the binary tree.
   * Return true if the element is deleted successfully
   * Return false if the element is not in the tree */
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; // Element is in the tree pointed by current
    }
    if (current == null)
      return false; // Element is not in the tree
    // Case 1: current has no left children
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
         root = current.right;
      }
      else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    else {
      // Case 2 & 3: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }
      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;
      
      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost == current
        parentOfRightMost.left = rightMost.left;
    }
    size--;
    return true; // Element inserted
  }
  
  /** Obtain an iterator. Use inorder. */
  public java.util.Iterator iterator() {
    return inorderIterator();
  }

  /** Obtain an inorder iterator */
  public java.util.Iterator inorderIterator() {
    return new InorderIterator();
  }

  // Inner class InorderIterator
  class InorderIterator implements java.util.Iterator {
    // Store the elements in a list
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    private int current = 0; // Point to the current element in list

    public InorderIterator() {
      inorder(); // Traverse binary tree and store elements in list
    }

    /** Inorder traversal from the root*/
    private void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    private void inorder(TreeNode<E> root) {
      if (root == null)return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    /** Next element for traversing? */
    public boolean hasNext() {
      if (current < list.size())
        return true;
      return false;
    }

    /** Get the current element and move cursor to the next */
    public Object next() {
      return list.get(current++);
    }

    /** Remove the current element and refresh the list */
    public void remove() {
      delete(list.get(current)); // Delete the current element
      list.clear(); // Clear the list
      inorder(); // Rebuild the list
    }
  }

  /** Remove all elements from the tree */
  public void clear() {
    root = null;
    size = 0;
  }
}
