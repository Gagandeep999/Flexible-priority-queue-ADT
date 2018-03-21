/*
Author : Gagandeep Singh
Date   : March 19, 2017
Purpose: An array implementation of a heap.
 */

public class Heap<K extends Comparable<K>, V> {

    private class HeapNode<K extends Comparable<K>, V>  implements Comparable<HeapNode<K, V>>{

        private K key;
        private V value;

        public HeapNode(K k, V v) {
            this.key = k;
            this.value = v;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Key: "+this.key+"--------->Value: "+this.value;
        }
        @Override
        public int compareTo(HeapNode<K, V> o) {
            if ((o == null) || (this.getClass() != o.getClass()))
                return -1;
            else if (state == "MIN"){
                return this.getKey().compareTo(o.getKey());
            }
            else return this.getKey().compareTo(o.getKey())*(-1);
        }
    }

    static String state;
    HeapNode root;
    HeapNode[] arr = new HeapNode[2];
    static int arrayIndex = 0;

    public Heap(String s) {
        this.state = s;
        root = null;
    }

    public static String getState() {
        return state;
    }
    public static void setState(String state) {
        Heap.state = state;
    }

    public HeapNode<K,V> remove(){
        HeapNode<K,V> topmost = null;
        if (arrayIndex == 0){
            System.out.println("No more elements to return!!\n");
        }
        else if(arrayIndex == 1){
            topmost = arr[0];
            System.out.println("This is the last element. No more elements to return.\n");
            arrayIndex--;
            arr[arrayIndex] = null;
        }
        else{
            topmost = arr[0];
            arr[0] = arr[arrayIndex-1];
            arr[arrayIndex-1] = null;
            arrayIndex--;
            afterRemoving(0, arr[0]);
        }
        return topmost;
    }

    public void insert(K key, V value) {
        HeapNode<K, V> newest = new HeapNode<>(key, value);
        if(arrayIndex == arr.length){
            arr = changeSize(arr);
        }
        if (isEmpty()){
            arr[0] = newest;
            arrayIndex++;
        }
        else{
            arr[arrayIndex] = newest;
            heapify(arrayIndex, newest);
            arrayIndex++;
        }
    }

    public HeapNode<K,V> top() {
        return arr[0];
    }

    public void toggle(){
        if (state.equalsIgnoreCase("MIN")){
            switchToMax();
        }
        else if (state.equalsIgnoreCase("MAX")){
            switchToMin();
        }
    }

    public void switchToMax(){
        setState("MAX");
        for (int i=0; i<arrayIndex; i++){
            afterRemoving(i, arr[i]);
        }
        for (int i=arrayIndex; i>=0; i--){
            afterRemoving(i, arr[i]);
        }
    }

    public void switchToMin(){
        setState("MIN");
        for (int i=0; i<arrayIndex; i++){
            afterRemoving(i, arr[i]);
        }
        for (int i=arrayIndex; i>=0; i--){
            afterRemoving(i, arr[i]);
        }
    }

    public String state(){
        return "The current state is: "+this.state+"\n";
    }

    public boolean isEmpty(){
        return (arrayIndex == 0);
    }

    public String size(){
        return "Current number of elements in the Priority Queue are: "+arrayIndex;
    }

    private void heapify(int currentIndex, HeapNode<K, V> node){
        int parent = (currentIndex - 1) / 2;
        if (arr[parent].compareTo(node) > 0){
            HeapNode<K,V> temp = arr[parent];
            arr[parent] = node;
            arr[currentIndex] = temp;
            heapify(parent, node);
        }
    }

    public void display(){
        if (!isEmpty()){
//            System.out.println(state());
            for (int i=0 ; i<arr.length;i++)
                if (arr[i] != null)
                    System.out.println("arr["+i+"] "+arr[i]);
        }
        System.out.println("\n");
    }

    private void afterRemoving(int index, HeapNode<K,V> node){
        int rightChild = (2*index) + 2;
        int leftChild = (2*index) + 1;
        int priorityChild = 0;
        if ((rightChild<arrayIndex) && (leftChild<arrayIndex) && (arr[rightChild] != null) && (arr[leftChild] != null)) {
            if (arr[rightChild].compareTo(arr[leftChild]) > 0){
                priorityChild = leftChild;
                if (arr[index].compareTo(arr[priorityChild]) > 0){
                    HeapNode<K,V> temp = arr[leftChild];
                    arr[leftChild] = arr[index];
                    arr[index] = temp;
                    afterRemoving(leftChild, arr[leftChild]);
                }
            }
            else {
                priorityChild = rightChild;
                if (arr[index].compareTo(arr[priorityChild]) > 0){
                    HeapNode<K,V> temp = arr[rightChild];
                    arr[rightChild] = arr[index];
                    arr[index] = temp;
                    afterRemoving(rightChild, arr[rightChild]);
                }
            }
        }
        else if ((leftChild<arrayIndex)&&(arr[leftChild] != null)){
            if (arr[index].compareTo(arr[leftChild]) > 0){
                HeapNode<K,V> temp = arr[leftChild];
                arr[leftChild] = arr[index];
                arr[index] = temp;
                afterRemoving(leftChild, arr[leftChild]);
            }
        }
        else {
            if (((leftChild<arrayIndex))) {
                if (arr[index].compareTo(arr[leftChild]) > 0) {
                    HeapNode<K, V> temp = arr[rightChild];
                    arr[rightChild] = arr[index];
                    arr[index] = temp;
                    afterRemoving(rightChild, arr[rightChild]);
                }
            }
        }
    }

    private HeapNode[] changeSize(HeapNode[] arr){
        int newLength = arr.length * 2;
        HeapNode[] arr2 = new HeapNode[newLength];
        for (int i=0;i<arr.length;i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }
}