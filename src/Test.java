public class Test {

    public static void main(String args[]){

//        Integer a = 5;
//        Integer b = 3;
//        System.out.println("5.compareTo(3) returns: "+a.compareTo(b));
//        System.out.println("3.compareTo(5) returns: "+b.compareTo(a));


        Binary_Tree<Integer, String> tree = new Binary_Tree<>("MIN");
//        tree.addRoot(26,"Apple");
        tree.insert(9,"PineAPPLE");
        tree.insert(3,"Oranges");
        tree.insert(15,"Peaches");
        tree.insert(1,"Amrood");
        tree.insert(20,"Banana");
        tree.insert(5,"Grapes");

        tree.display();

        System.out.println(tree.state());

        tree.toggle();

        System.out.println(tree.state());

        tree.display();






//        System.out.println("calling switchToMax() :");
//
//        tree.switchToMax();
////
//        tree.display();
////
//        System.out.println("calling switchToMin() :");
//
//        tree.switchToMin();
//
        System.out.println("Removing two elements");
        System.out.println(tree.remove());
        System.out.println(tree.remove());
        System.out.println(tree.remove());
//        System.out.println(tree.remove());
//        System.out.println(tree.remove());
//        System.out.println(tree.remove());
//        System.out.println(tree.remove());
//        System.out.println(tree.remove());
//        System.out.println(tree.remove());


//        tree.display();

    }
}
