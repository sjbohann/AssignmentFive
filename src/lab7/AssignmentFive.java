/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 *
 * @author sjoec
 */
import java.util.*;
import java.io.*;
public class AssignmentFive {
    public static void main(String[] args) {
        AssignmentFive obj = new AssignmentFive();
    BinarySearchTree[] treeArray = new BinarySearchTree[26];
    for(int i = 0; i < treeArray.length; i++) {
        treeArray[i] = new BinarySearchTree<String>();
    }
    obj.readDictionary(treeArray);
    obj.readBook(treeArray);
    obj.printResults();
        
    }
    
    public long wordsFound = 0;
    public long wordsNotFound = 0;
    public long compsFound = 0;
    public long compsNotFound = 0;
    
    /**
     *
     * @param treeArray: array of Binary Search Trees to be loaded
     * requires: that random_dictionary.txt exists and is in the correct directory
     * ensures: that treeArray is loaded with the dictionary words, organized
     * using the first letter of each word.
     * 
     */
    public void readDictionary(BinarySearchTree[] treeArray) {
        File f = new File("random_dictionary.txt");
        try {
            int i = 0;
            Scanner inf = new Scanner(f);
            while(inf.hasNext()) {
                String s = inf.nextLine().toLowerCase();
                treeArray[s.charAt(0) - 97].insert(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param treeArray: array of Binary Search Trees to be searched
     * requires: oliver.txt exists and is in the correct directory
     * ensures: that correct words are found in the treeArray and counted.
     */
    public void readBook(BinarySearchTree[] treeArray) {
        try {
            int[] i = new int[1];
            char let;
            FileInputStream inf = new FileInputStream(new File("oliver.txt"));
            String str = "";
            int n = 0;
            while((n = inf.read()) != -1) {
                i[0] = 0;
                let = (char)n;
                if(Character.isLetter(let))
                    str += Character.toLowerCase(let);
                if ((Character.isWhitespace(let) || let == '-') && !str.isEmpty()){
                   if(treeArray[str.charAt(0) - 97].search(str,i)) {
                       wordsFound++;
                       compsFound += i[0];
                   } else {
                       wordsNotFound++;
                       compsNotFound += i[0];
                   }
                   str="";
                }
            }
            inf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     */
    public void printResults() {
        System.out.println("Number of words found: " + wordsFound);
        System.out.println("Number of words not found: " + wordsNotFound);
        System.out.printf("Average number of comparisons for words found: %6.2f\n ",(double)compsFound/wordsFound);
        System.out.printf("Average number of comparisons for words not found: %6.2f\n ",(double)compsNotFound/wordsNotFound);
    }
    
}
