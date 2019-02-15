package merge;

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
    }
}
