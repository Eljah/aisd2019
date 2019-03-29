package trees.binary;

import java.sql.SQLOutput;

public class Tree {
    private Node root;
    private int counter = 0;

    public void insert(int key, String payload) {
        if (root == null) {
            root = new Node(key, payload);
        } else {
            Node toInsertChild = findToInsert(key);
            if (toInsertChild.getKey() > key) {
                toInsertChild.setLeftChild(new Node(key, payload));
            } else {
                toInsertChild.setRightChild(new Node(key, payload));
            }
        }
    }

    private Node findToInsert(int key) {
        Node current = root;
        Node parent = root;
        //todo remove duplicates
        while (current != null) {
            parent = current;
            if (current.getKey() > key) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return parent;
    }

    private Node findIfExist(int key) {
        Node current = root;
        //todo remove duplicates
        while (current != null&&current.getKey()!=key) {
            if (current.getKey() > key) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return current;
    }

    public void remove(int key)
    {
        Node toBeRemove=findIfExist(key);
        if (toBeRemove!=null)
        {
            System.out.println("Element to be removed was fount: "+toBeRemove.getKey()+": "+toBeRemove.getPayload());
            Node localRightMin=findLocalMin(toBeRemove);
            System.out.println("Element to be moved as successor was fount: "+localRightMin.getKey()+": "+localRightMin.getPayload());


        }
        else {
            System.out.println("No element found to be removed");
        }
    };

    private Node findLocalMin(Node node)
    {
        Node current=node;
        Node parent=node;
        while (current!=null)
        {
            parent=current;
            current=current.getLeftChild();
        }
        return parent;
    }

    public void print() {
        printValuesInOrder(root);
    }

    private void printValuesInOrder(Node node) {
        counter++;
        if (node.getRightChild() != null)
            printValuesInOrder(node.getRightChild());
        counter--;
        for (int i = 0; i < counter; i++) System.out.print(" ");
        System.out.println(node.getKey() + ": " + node.getPayload());
        counter++;
        if (node.getLeftChild() != null)
            printValuesInOrder(node.getLeftChild());
        counter--;
    }
}
