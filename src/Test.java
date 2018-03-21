/*
Author : Gagandeep Singh
Date   : March 19, 2017
Purpose: main() method to verify the functionality of the Heap.
 */

public class Test {

    public static void main(String args[]){

//        Integer a = 5;
//        Integer b = 3;
//        System.out.println("5.compareTo(3) returns: "+a.compareTo(b));
//        System.out.println("3.compareTo(5) returns: "+b.compareTo(a));

        Heap<Integer, String> heap = new Heap<>("MIN");
        heap.insert(9,"PineAPPLE");
        heap.insert(3,"Oranges");
        heap.insert(15,"Peaches");
        System.out.println("Top element is :" + heap.top());
        heap.insert(1,"Amrood");
        heap.insert(20,"Banana");
        heap.insert(5,"Grapes");

        heap.display();

        System.out.println(heap.state());

        heap.toggle();

        System.out.println("NOW: "+heap.state());

        heap.display();

        System.out.println("calling switchToMax() :");

        heap.switchToMax();

        heap.display();

        System.out.println("calling switchToMin() :");

        heap.switchToMin();

        System.out.println("Removing: ");
        System.out.println(heap.remove());
        heap.display();
        System.out.println("Top element is :" + heap.top());
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        heap.switchToMax();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        heap.switchToMin();
        heap.switchToMax();
        System.out.println(heap.remove());
        heap.display();

        heap.insert(2,"BMW");
        heap.insert(10,"Mercedes");
        heap.insert(21,"Audi");

        heap.display();

        heap.toggle();

        heap.display();
        System.out.println(heap.remove());
        heap.display();
        heap.switchToMax();
        System.out.println(heap.remove());
        heap.display();
        heap.switchToMax();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
    }
}
