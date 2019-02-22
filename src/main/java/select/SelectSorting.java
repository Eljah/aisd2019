package select;

public class SelectSorting {
    private long[] theArray; //исходный массив
    private int nElems; // счетчик заполненности исходного массива

    public SelectSorting(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println();
    }

    public void selectSort()
    {
        for (int i=0; i<nElems; i++)
        {
            for (int j=i+1; j<nElems; j++)
            {
                if (theArray[j]<theArray[i])
                {
                    long x= theArray[i];
                    theArray[i]=theArray[j];
                    theArray[j]=x;
                    display();
                }

            }
        }
    }

    public static void main(String[] args) {
        SelectSorting selectSorting=new SelectSorting(20);
        selectSorting.insert(10);
        selectSorting.insert(23);
        selectSorting.insert(2);
        selectSorting.insert(6);
        selectSorting.insert(1);
        selectSorting.insert(0);
        selectSorting.insert(15);
        selectSorting.insert(-1);

        selectSorting.display();
        selectSorting.selectSort();
        selectSorting.display();


    }

}
