package merge.stack;

import java.io.IOException;

public class StackMergingSorting {
    private MergingStack mergingStack;
    private int codePart;
    private Params currentParams;

    private int arraySize;
    private int nElems;
    private int stackSize;

    private  long[] theArray;
    private  int lowerBound;
    private  int upperBound;

    public StackMergingSorting(int maxArraySize, int maxStackSize)
    {
        arraySize=maxArraySize;
        stackSize=maxStackSize;
        theArray=new long[arraySize];
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

    public void mergeSort() {
        long[] workSpace = new long[arraySize];
        recMerging(workSpace, stackSize);
    }

    private void recMerging(long[] workspace,int stackSize)
    {
        mergingStack=new MergingStack(stackSize);
        codePart=1;
        while (step() == false);
    }

    private boolean step()
    {
        switch(codePart)
        {
            case 1:
                currentParams=new Params(0,nElems-1,6);
                mergingStack.push(currentParams);
                codePart=2;
                break;
            case 2:
                currentParams = mergingStack.peek();
                if (currentParams.lowerBound==currentParams.upperBound)
                {
                    //todo or not todo?
                    codePart = 5;
                }
                else
                    codePart=3;
                break;
            case 3:
                Params newParams = new Params(currentParams.lowerBound, currentParams.upperBound-1, 4);
                Params newParams2 = new Params(currentParams.lowerBound+1, currentParams.upperBound, 4);
                //todo the correct parametrization on initializing!!!
                mergingStack.push(newParams);
                mergingStack.push(newParams2);
                codePart = 2;
                break;
            case 4:
                currentParams=mergingStack.peek();
                //todo array merge here
                codePart = 5;
                break;
            case 5:
                currentParams = mergingStack.peek();
                codePart = currentParams.returnAddress;
                mergingStack.pop();
                break;
            case 6:
                return true;
        }

        return false;
    }

}
