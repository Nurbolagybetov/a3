public class Main {

    public static void main(String[] args) {
        MyBinarySearchTree<Integer, Integer> binaryTree = new MyBinarySearchTree<>();

        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(2);
        binaryTree.insert(6);
        binaryTree.insert(7);

        String traversalResult = binaryTree.inOrder();
        System.out.println(traversalResult);
        System.out.println("Root data before remove: " + binaryTree.root.key);
        binaryTree.remove(5);
        binaryTree.inOrder();
        traversalResult = binaryTree.inOrder();
        System.out.println(traversalResult);
        System.out.println("Root data after remove: " + binaryTree.root.key);

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        MyTestingClass key = new MyTestingClass("test_key");
        Student value = new Student("John", 20);
        table.put(key, value);
        Student retrievedValue = table.get(key);
        System.out.println("Retrieved value: " + retrievedValue);
    }
}
