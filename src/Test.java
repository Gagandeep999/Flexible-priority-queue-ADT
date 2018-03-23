/*
Author : Gagandeep Singh
Date   : March 19, 2017
Purpose: main() method to verify the functionality of the Heap.
 */

public class Test {

    public static void main(String args[]){

        Heap<String, String> heap = new Heap<>("MIN");
        heap.insert("S","PineAPPLE");
        heap.insert("Q","Oranges");
        heap.insert("A","Peaches");
        System.out.println("Top element is :" + heap.top());
        heap.insert("C","Amrood");
        heap.insert("P","Banana");
        heap.insert("M","Grapes");
        heap.insert("B","Apple");

        heap.display();

//        heap.toggle();

//        heap.display();

        System.out.println("PreOrder Traversal:");

        heap.preOrder(0);

        System.out.println("PostOrder Traversal:");

        heap.postOrder(0);
    }
}
