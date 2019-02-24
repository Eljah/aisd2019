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
                System.out.println("Stack call with "+currentParams.lowerBound+"-"+currentParams.upperBound);
                if (currentParams.lowerBound==currentParams.upperBound)
                {
                    //todo or not todo?
                    System.out.println("Processing stack's local deep: "+currentParams.lowerBound+"/"+currentParams.upperBound);
                    codePart = 5;
                    System.out.println("Stack back->5");
                }
                else {
                    codePart = 3;
                    System.out.println("Stack deep->3");
                }
                break;
            case 3:
                Params newParams = new Params(currentParams.lowerBound, (currentParams.upperBound+currentParams.lowerBound)/2, 4);
                Params newParams2 = new Params((currentParams.upperBound+currentParams.lowerBound)/2+1, currentParams.upperBound, 44);
                //todo the correct parametrization on initializing!!!
                mergingStack.display("Before 3 "+currentParams.lowerBound+"-"+currentParams.upperBound);
                mergingStack.push(newParams2);
                mergingStack.display("Middle 3 " +currentParams.lowerBound+"-"+currentParams.upperBound);
                mergingStack.push(newParams);
                mergingStack.display("After 3 "+currentParams.lowerBound+"-"+currentParams.upperBound);
                codePart = 2;
                break;
            case 4:
                mergingStack.display("Before 4 "+currentParams.lowerBound+"-"+currentParams.upperBound);
                currentParams=mergingStack.peek();
                mergingStack.display("After 4 "+currentParams.lowerBound+"-"+currentParams.upperBound);
                //todo array merge here
                display();
                codePart = 2;
                break;
            case 44:
                mergingStack.display("Before 44 "+currentParams.lowerBound+"-"+currentParams.upperBound);
                currentParams=mergingStack.peek();
                mergingStack.display("After 44 "+currentParams.lowerBound+"-"+currentParams.upperBound);
                //todo array merge here
                display();
                codePart = 5;
                break;
            case 5:
                mergingStack.display("Before 5 pop "+currentParams.lowerBound+"-"+currentParams.upperBound);
                //mergingStack.display("Before 5 pop 2 "+currentParams.lowerBound+"-"+currentParams.upperBound);
                //mergingStack.pop();
                currentParams = mergingStack.peek();
                codePart = currentParams.returnAddress;
                mergingStack.pop();
                mergingStack.display("After 5 pop "+currentParams.lowerBound+"-"+currentParams.upperBound);
                //codePart = 3;
                break;
            case 6:
                return true;
        }

        return false;
    }

}
