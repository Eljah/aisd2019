package merge;

import merge.stack.StackMergingSorting;

public class MergeSortingTester {
    public static void main(String[] args) {
        int max=100;
        MergingSorting mergingSorting =new MergingSorting(max);

        mergingSorting.insert(64);
        mergingSorting.insert(21);
        mergingSorting.insert(33);
        mergingSorting.insert(70);
        mergingSorting.insert(12);
        mergingSorting.insert(85);
        mergingSorting.insert(44);
        mergingSorting.insert(3);
        mergingSorting.insert(99);
        mergingSorting.insert(0);
        mergingSorting.insert(108);
        mergingSorting.insert(36);

        mergingSorting.display();
        mergingSorting.mergeSort();
        mergingSorting.display();

//        int maxArray=100;
//        int maxStack=10000;
//        StackMergingSorting stackMergingSorting=new StackMergingSorting(maxArray,maxStack);
//
//        stackMergingSorting.insert(64);
//        stackMergingSorting.insert(21);
//        stackMergingSorting.insert(33);
//        stackMergingSorting.insert(70);
//        stackMergingSorting.insert(12);
//        stackMergingSorting.insert(85);
//        stackMergingSorting.insert(44);
//        stackMergingSorting.insert(3);
//        stackMergingSorting.insert(99);
//        stackMergingSorting.insert(0);
//        stackMergingSorting.insert(108);
//        stackMergingSorting.insert(36);
//        stackMergingSorting.display();
//        stackMergingSorting.mergeSort();
//        stackMergingSorting.display();
    }
}
