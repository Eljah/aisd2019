package graphs;

import graphs.Vertex;

import java.util.Deque;
import java.util.LinkedList;

public class Graph {
    int maxSize;
    int currentSize=0;

    Vertex[] vertices;
    int[][] matrix;
    Graph(int maxSize)
    {
        this.maxSize=maxSize;
        vertices=new Vertex[maxSize];
        matrix=new int[maxSize][maxSize];
    }

    public void addVertex(Vertex vertex)
    {
        vertices[currentSize]=vertex;
        matrix[currentSize][currentSize]=1;
        currentSize++;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2)
    {
        int vertex1Index=findVertexIndex(vertex1);
        int vertex2Index=findVertexIndex(vertex2);
        matrix[vertex1Index][vertex2Index]=1;
        matrix[vertex2Index][vertex1Index]=1;
    }

    public void printMatrix()
    {
        System.out.print("  ");
        for (int i=0; i<currentSize;i++)
        {
            System.out.print(vertices[i].label+" ");
        }
        System.out.println();

        for (int j=0;j<currentSize; j++)
        {
            System.out.print(vertices[j].label+" ");
            for (int i=0; i<currentSize;i++)
            {
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();

        }
    }

    private int findVertexIndex(Vertex vertex)
    {
        int start1Index=-1;
        for (int i=0;i<vertices.length;i++)
        {
            if (vertices[i]==vertex)
            {
                start1Index=i;
                break;
            }
        }
        return  start1Index;
    }

    public void dfs(Vertex start)
    {


        //получили индекс стартовой точки

        Deque<Vertex> stack=new LinkedList<>();
        stack.push(start);
        start.isVisited=true;
        System.out.println("Output:");
        while (!stack.isEmpty())
        {
            Vertex current=stack.poll();
            System.out.print(current.label);
            int currentIndex=findVertexIndex(current);
            for (int i=0;i<currentSize;i++)
            {
                if (matrix[currentIndex][i]==1)
                {
                    if (!vertices[i].isVisited)
                    {
                        stack.push(vertices[i]);
                        vertices[i].isVisited=true;
                        //break;
                    }
                }
            }

        }

    }
}
