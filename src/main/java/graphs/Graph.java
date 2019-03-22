package graphs;

import graphs.Vertex;

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
        currentSize++;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2)
    {
        int vertex1Index=-1;
        for (int i=0;i<vertices.length;i++)
        {
            if (vertices[i]==vertex1)
            {
                vertex1Index=i;
                break;
            }
        }
        int vertex2Index=-1;
        for (int i=0;i<vertices.length;i++)
        {
            if (vertices[i]==vertex2)
            {
                vertex2Index=i;
                break;
            }
        }
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
}
