package merge.stack;

public class MergingStack {
    private int maxSize;
    private Params[] stackArray;
    private int top;

    public MergingStack(int maxSize)
    {
        this.maxSize=maxSize;
        this.stackArray=new Params[maxSize];
        top = -1;
    }

    public void push(Params p)
    {
        stackArray[++top] = p;
    }

    public Params pop()
    {
        Params params=stackArray[top--];
        stackArray[top+1]=null;
        return params;
    }

    public Params peek()
    {
        return stackArray[top];
    }

    public void display(String message)
    {
        System.out.print(message+": ");
        for (int i=0; i<=top;i++)
            System.out.print(stackArray[i].lowerBound+"/"+stackArray[i].upperBound+" ");
        System.out.println();
    }
}
