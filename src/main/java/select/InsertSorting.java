package select;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class InsertSorting {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] <= array[j]) {
                    int element = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = element;
                }

            }

        }
        return array;
    }
    public static int[] shellSort(int[] array) {
        int[] result = array;
        int d=1;
        while(3*d+1<array.length){
            d=3*d+1;
        }

        while (d>0) {
            //System.out.println("D: "+d);
            for (int i = d; i < array.length; i++) {
                result = sortWithIncrement(array, d, i);
            }
            d = (d-1)/3;
        }

        return result;
    }
    public static int[] sortWithIncrement(int[] array, int d, int startPoint){
//        for (int i = startPoint+1; i < array.length; i+=d) {
//            for (int j = startPoint; j < i; j+=d) {
//                if (array[i] <= array[j]) {
//                    int element = array[i];
//                    for (int k = i; k > j && k-d > 0; k-=d) {
//                        array[k] = array[k - d];
//                    }
//                    array[j] = element;
//                }
//            }
//        }
        int temp=array[startPoint];
        int inner=startPoint;

        while (inner > d-1 && array[inner-d]>=temp)
        {
            array[inner]=array[inner-d];
            inner-=d;
        }
        array[inner]=temp;

        //System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        Random random = new Random();
        //int[] array = random.ints(0, 10000).limit(1_000_00).toArray();
        int[] array = random.ints(0, 10000).limit(100).toArray();

        int[] array2 = array.clone();
        long start1 = System.nanoTime();
        sort(array);
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        shellSort(array2);
        long end2 = System.nanoTime();
        System.out.println("Array1 sorted with insertionSort in " + (end1-start1)/1_000_000d + " ms.");
        System.out.println("Array1 sorted with shellSort in " + (end2-start2)/1_000_000d + " ms.");

    }
}
