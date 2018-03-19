import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG_BInary {

    static int root = 0;
    static String[] str = new String[10];

    public void Root(String value){
        str[0] = value;
    }
    public void leftChild(int parentKey, String value){
        int index = (parentKey*2) + 1;
        str[index] = value;
    }
    public void rightChild(int parentKey, String value){
        int index = (parentKey*2) + 2;
        str[index] = value;
    }

    public void printTree(){
        for (int i=0; i<10; i++){
            if(str[i] != null)
                System.out.println(str[i]);
        }
    }

    public void inOrder(){

    }

    public static void main(String args[]){
        GFG_BInary tree = new GFG_BInary();

        tree.Root("Z");
        tree.leftChild(0,"A");
        tree.rightChild(0,"B");
        tree.leftChild(1,"J");
        tree.leftChild(2,"K");
        tree.rightChild(1,"X");
        tree.rightChild(2,"Y");
        tree.printTree();
    }
}
