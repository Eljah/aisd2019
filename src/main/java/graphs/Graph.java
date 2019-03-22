package graphs;

import graphs.Vertex;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int maxSize;
    int currentSize = 0;

    Vertex[] vertices;
    int[][] matrix;

    Graph(int maxSize) {
        this.maxSize = maxSize;
        vertices = new Vertex[maxSize];
        matrix = new int[maxSize][maxSize];
    }

    public void addVertex(Vertex vertex) {
        vertices[currentSize] = vertex;
        matrix[currentSize][currentSize] = 1;
        currentSize++;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        int vertex1Index = findVertexIndex(vertex1);
        int vertex2Index = findVertexIndex(vertex2);
        matrix[vertex1Index][vertex2Index] = 1;
        matrix[vertex2Index][vertex1Index] = 1;
    }

    public void printMatrix() {
        System.out.print("  ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(vertices[i].label + " ");
        }
        System.out.println();

        for (int j = 0; j < currentSize; j++) {
            System.out.print(vertices[j].label + " ");
            for (int i = 0; i < currentSize; i++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();

        }
    }

    private int findVertexIndex(Vertex vertex) {
        int start1Index = -1;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == vertex) {
                start1Index = i;
                break;
            }
        }
        return start1Index;
    }

    public void dfs(Vertex start) {        //получили индекс стартовой точки
        Deque<Vertex> stack = new LinkedList<>();
        stack.push(start);
        start.isVisited = true;
        System.out.println("Output dfs:");
        while (!stack.isEmpty()) {
            Vertex current = stack.poll();
            System.out.print(current.label);
            int currentIndex = findVertexIndex(current);
            for (int i = 0; i < currentSize; i++) {
                if (matrix[currentIndex][i] == 1) {
                    if (!vertices[i].isVisited) {
                        stack.push(vertices[i]);
                        vertices[i].isVisited = true;
                        //break;
                    }
                }
            }
        }
        Arrays.
                stream(vertices).filter((Vertex vertex) -> {
            return vertex != null;
        }).
                peek((Vertex vertex)
                        -> {
                    vertex.isVisited = false;
                }).count();
        System.out.println();
    }

    public void bfs(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        start.isVisited = true;
        System.out.println("Output bfs:");
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.label);
            int currentIndex = findVertexIndex(current);
            for (int i = 0; i < currentSize; i++) {
                if (matrix[currentIndex][i] == 1) {
                    //System.out.println("Related to "+vertices[i].label);
                    if (!vertices[i].isVisited) {
                        //System.out.println("Related and not visited to "+vertices[i].label);
                        queue.add(vertices[i]);
                        vertices[i].isVisited = true;
                        //break;
                    }
                }
            }
        }
        Arrays.
                stream(vertices).filter((Vertex vertex) -> {
            return vertex != null;
        }).
                peek((Vertex vertex)
                        -> {
                    vertex.isVisited = false;
                }).count();
        System.out.println();
    }


    public void warshallMatrix()
    {
        for (int i=0; i<currentSize; i++)
            for (int j=0; j<currentSize; j++) //todo improve currentsize
                if (matrix[i][j]==0)
                {
                    for (int k=0; k<currentSize; k++) //todo improve currentsize
                    {
                        if (matrix[k][j]!=0&&k!=j)
                        {
                            if (matrix[i][k]==1)
                            {
                                matrix[i][j]=1;
                            }
                        }
                    }
                }
    }
}
