package graphs;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph=new Graph(15);
        Vertex a=new Vertex("A");
        Vertex b=new Vertex("B");
        Vertex c=new Vertex("C");
        Vertex d=new Vertex("D");
        Vertex e=new Vertex("E");
        Vertex f=new Vertex("F");
        Vertex g=new Vertex("G");
        Vertex h=new Vertex("H");
        Vertex i=new Vertex("I");
        Vertex j=new Vertex("J");
        Vertex k=new Vertex("K");
        graph.printMatrix();
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);
        graph.addVertex(i);
        graph.addVertex(k);
        graph.addVertex(j);
        System.out.println();
        graph.printMatrix();
        graph.addEdge(a,b);
        graph.addEdge(c,b);
        graph.addEdge(c,d);
        graph.addEdge(c,e);
        graph.addEdge(d,h);
        graph.addEdge(e,h);
        graph.addEdge(e,f);
        graph.addEdge(e,g);
        graph.addEdge(f,g);
        graph.addEdge(h,g);
        graph.addEdge(k,j);
        graph.addEdge(k,i);
        graph.addEdge(j,i);
        //graph.addEdge(a,j);
        graph.printMatrix();

        graph.dfs(b);
        graph.dfs(j);
        graph.dfs(i);
        System.out.println();
        graph.bfs(b);
        graph.bfs(j);
        graph.bfs(i);
        System.out.println();
        graph.warshallMatrix();
        graph.printMatrix();










    }
}
