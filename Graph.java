
import java.util.*;

public class Graph {

    int V;

    class Data {

        int ver, wt;

        Data(int v, int w) {
            ver = v;
            wt = w;
        }
    }

    LinkedList<Data> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addDiEdge(int v, int w) {
        adj[v].add(new Data(w, 1));
    }

    void addDiEdge(int v, int w, int wt) {
        adj[v].add(new Data(w, wt));
    }

    void addEdge(int v, int w) {
        adj[v].add(new Data(w, 1));
        adj[w].add(new Data(v, 1));
    }

    void BFS(int s) {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        ArrayList<Integer> al = new ArrayList<>();
        while (!queue.isEmpty()) {

            s = queue.poll();
            System.out.print(s + " ");

            ListIterator<Data> i = adj[s].listIterator();
            while (i.hasNext()) {
                Data n = i.next();
                if (!visited[n.ver]) {
                    visited[n.ver] = true;
                    queue.add(n.ver);
                }
            }
        }
    }

    private void visitedDFS(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        ListIterator<Data> i = adj[v].listIterator();
        while (i.hasNext()) {
            Data n = i.next();
            if (!visited[n.ver]) {
                visitedDFS(n.ver, visited);
            }
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];

        visitedDFS(v, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
     
        g.addDiEdge(0, 2, 10);
        g.addDiEdge(0, 1, 5);
        g.addDiEdge(1, 2, 3);
        g.addDiEdge(1, 3, 9);
        g.addDiEdge(1, 4, 2);
        g.addDiEdge(2, 1, 2);
        g.addDiEdge(2, 3, 1);
        g.addDiEdge(3, 4, 4);
        g.addDiEdge(4, 3, 6);
        g.addDiEdge(4, 0, 7);
    }

}
