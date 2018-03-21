public class Binary_Tree<K extends Comparable<K>, V> { // K implements Comparable

    private class BinaryTreeNode<K extends Comparable<K>, V>  implements Comparable<BinaryTreeNode<K, V>>{

        private K key;
        private V value;

        public BinaryTreeNode(K k, V v) {
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
            return "Element: "+getValue()+" has Key: "+getKey();
        }
        @Override
        public int compareTo(BinaryTreeNode<K, V> o) {
            if ((o == null) || (this.getClass() != o.getClass()))
                return -1;
            else if (state == "MIN"){
                return this.getKey().compareTo(o.getKey());
            }
            else return this.getKey().compareTo(o.getKey())*(-1);
        }
    }

    static String state;
    BinaryTreeNode root;
    BinaryTreeNode[] arr = new BinaryTreeNode[2];
    static int arrayIndex = 0;

    public Binary_Tree(String s) {
        this.state = s;
        root = null;
    }

    public static String getState() {
        return state;
    }
    public static void setState(String state) {
        Binary_Tree.state = state;
    }

    public BinaryTreeNode<K,V> remove(){
        BinaryTreeNode<K,V> topmost = null;
        if(arrayIndex == 1){
            topmost = arr[0];
            System.out.println("This is the last element. No more elements to return.");
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
        BinaryTreeNode<K, V> newest = new BinaryTreeNode<>(key, value);
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

    public BinaryTreeNode<K,V> top() {
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
        return "The current state is: "+this.state;
    }

    public boolean isEmpty(){
        return (arrayIndex == 0);
    }

    public String size(){
        return "Current number of elements in the Priority Queue are: "+arrayIndex;
    }

    private void heapify(int currentIndex, BinaryTreeNode<K, V> node){
        int parent = (currentIndex - 1) / 2;
        if (arr[parent].compareTo(node) > 0){
            BinaryTreeNode<K,V> temp = arr[parent];
            arr[parent] = node;
            arr[currentIndex] = temp;
            heapify(parent, node);
        }
    }

    public void display(){
        System.out.println(state());
        for (int i=0 ; i<arr.length;i++)
            if (arr[i] != null)
                System.out.println("arr["+i+"] "+arr[i]);
    }

    private void afterRemoving(int index, BinaryTreeNode<K,V> node){
        int rightChild = (2*index) + 2;
        int leftChild = (2*index) + 1;
        int priorityChild = 0;
        if ((rightChild<arrayIndex) && (leftChild<arrayIndex) && (arr[rightChild] != null) && (arr[leftChild] != null)) {
            if (arr[rightChild].compareTo(arr[leftChild]) > 0){
                priorityChild = leftChild;
                if (arr[index].compareTo(arr[priorityChild]) > 0){
                    BinaryTreeNode<K,V> temp = arr[leftChild];
                    arr[leftChild] = arr[index];
                    arr[index] = temp;
                    afterRemoving(leftChild, arr[leftChild]);
                }
            }
            else {
                priorityChild = rightChild;
                if (arr[index].compareTo(arr[priorityChild]) > 0){
                    BinaryTreeNode<K,V> temp = arr[rightChild];
                    arr[rightChild] = arr[index];
                    arr[index] = temp;
                    afterRemoving(rightChild, arr[rightChild]);
                }
            }
        }
        else if ((leftChild<arrayIndex)&&(arr[rightChild] == null)){
            if (arr[index].compareTo(arr[leftChild]) > 0){
                BinaryTreeNode<K,V> temp = arr[leftChild];
                arr[leftChild] = arr[index];
                arr[index] = temp;
                afterRemoving(leftChild, arr[leftChild]);
            }
        }
        else {
            if (((leftChild<arrayIndex))) {
                if (arr[index].compareTo(arr[leftChild]) > 0) {
                    BinaryTreeNode<K, V> temp = arr[rightChild];
                    arr[rightChild] = arr[index];
                    arr[index] = temp;
                    afterRemoving(rightChild, arr[rightChild]);
                }
            }
        }
    }

    private BinaryTreeNode[] changeSize(BinaryTreeNode[] arr){
        int newLength = arr.length * 2;
        BinaryTreeNode[] arr2 = new BinaryTreeNode[newLength];
        for (int i=0;i<arr.length;i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }
}