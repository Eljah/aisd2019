package merge;

import merge.stack.StackMergingSorting;

public class MergeSortingTester {
    public static void main(String[] args) {
        int max=100;
        MergeSorting mergeSorting=new MergeSorting(max);

        mergeSorting.insert(64);
        mergeSorting.insert(21);
        mergeSorting.insert(33);
        mergeSorting.insert(70);
        mergeSorting.insert(12);
        mergeSorting.insert(85);
        mergeSorting.insert(44);
        mergeSorting.insert(3);
        mergeSorting.insert(99);
        mergeSorting.insert(0);
        mergeSorting.insert(108);
        mergeSorting.insert(36);

        mergeSorting.display();
        mergeSorting.mergeSort();
        mergeSorting.display();

        int maxArray=100;
        int maxStack=10000;
        StackMergingSorting stackMergingSorting=new StackMergingSorting(maxArray,maxStack);

        stackMergingSorting.insert(64);
        stackMergingSorting.insert(21);
        stackMergingSorting.insert(33);
        stackMergingSorting.insert(70);
        stackMergingSorting.insert(12);
        stackMergingSorting.insert(85);
        stackMergingSorting.insert(44);
        stackMergingSorting.insert(3);
        stackMergingSorting.insert(99);
        stackMergingSorting.insert(0);
        stackMergingSorting.insert(108);
        stackMergingSorting.insert(36);
        stackMergingSorting.display();
        stackMergingSorting.mergeSort();
        stackMergingSorting.display();
    }
}
