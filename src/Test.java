/*
Author : Gagandeep Singh
Date   : March 19, 2017
Purpose: main() method to verify the functionality of the Heap.
 */

public class Test {

    public static void main(String args[]){

        Heap<String, String> heap = new Heap<>("MIN");
        heap.insert("BS","PineAPPLE");
        heap.insert("BQ","Oranges");
        heap.insert("BA","Peaches");
        System.out.println("Top element is :" + heap.top());
        heap.insert("BC","Amrood");
        heap.insert("BP","Banana");
        heap.insert("BM","Grapes");
        heap.insert("AB","Apple");

        heap.display();

        heap.toggle();

        heap.display();

//        System.out.println("PreOrder Traversal:");

//        heap.preOrder(0);
    }
}
