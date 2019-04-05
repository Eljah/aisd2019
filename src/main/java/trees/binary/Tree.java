package trees.binary;

import java.util.function.Consumer;

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
        while (current != null && current.getKey() != key) {
            if (current.getKey() > key) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return current;
    }

    public void remove(int key) {
        Node toBeRemove = findIfExist(key);
        if (toBeRemove != null) {
            System.out.println("Element to be removed was fount: " + toBeRemove.getKey() + ": " + toBeRemove.getPayload());
            Node localRightMin = findLocalMin(toBeRemove);
            System.out.println("Element to be moved as successor was fount: " + localRightMin.getKey() + ": " + localRightMin.getPayload());
            Node parentOfToBeRemove = findParentOf(toBeRemove);
            System.out.println("Element to have ties replaced (parent of the element to be removed)" + parentOfToBeRemove.getKey() + ": " + parentOfToBeRemove.getPayload());
            Node parentOfLocalRightMin = findParentOf(localRightMin);
            System.out.println("Element to have ties replaced (parent of the element to be moved)" + parentOfLocalRightMin.getKey() + ": " + parentOfLocalRightMin.getPayload());

//
//
            if (parentOfToBeRemove.getRightChild()==toBeRemove) parentOfToBeRemove.setRightChild(localRightMin);
            if (parentOfToBeRemove.getLeftChild()==toBeRemove) parentOfToBeRemove.setLeftChild(localRightMin);

            parentOfLocalRightMin.setLeftChild(localRightMin.getRightChild());

            localRightMin.setLeftChild(toBeRemove.getLeftChild());
            localRightMin.setRightChild(toBeRemove.getRightChild());

        } else {
            System.out.println("No element found to be removed");
        }
    }

    ;

    private Node findLocalMin(Node node) {
        Node parent = node;
        Node current = parent.getRightChild();
        if (current != null) {
            parent = current;
            while (current != null) {
                parent = current;
                current = current.getLeftChild();
            }
        } else {
            current = parent.getLeftChild();
            parent = current;
        }
        if (parent != node)
            return parent;
        else return null;
    }

    private Node findParentOf(Node node) {
        return tranverse(root, node);
    }

    public void print() {
        tranverse(root, (node) -> {
            for (int i = 0; i < this.counter; i++) {
                System.out.print(" ");
            }
            System.out.println(node.getKey() + ": " + node.getPayload());
        });
    }

    private void tranverse(Node node, Consumer<Node> consumer) {
        counter++;
        if (node.getRightChild() != null)
            tranverse(node.getRightChild(), consumer);
        counter--;
        //for (int i = 0; i < counter; i++) System.out.print(" ");

        consumer.accept(node);
        counter++;
        if (node.getLeftChild() != null)
            tranverse(node.getLeftChild(), consumer);
        counter--;
    }

    private Node tranverse(Node node, Node toCompare) {
        //System.out.println(node.getKey());
        if (node.getRightChild() == toCompare || node.getLeftChild() == toCompare) return node;
        Node result = null;
        if (node.getRightChild() != null)
            result = tranverse(node.getRightChild(), toCompare);
        if (result == null) {
            if (node.getLeftChild() != null)
                result = tranverse(node.getLeftChild(), toCompare);
        }
        return result;
    }
}
