
import java.util.*;

public class Kruskal {

//	Disjoint Sets
    int[] parent;

    public Kruskal(int n, int m, ArrayList<Edge> edges) {
        parent = new int[m];

        for (int i = 0; i < m; i++) {
            parent[i] = i;
        }

        int a, b, w;
        int mst_weight = 0, mst_edges = 0;
        int mst_i = 0;

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.wt - e2.wt;
            }
        });

        System.out.println("V1\tV2\tWeight");
        while ((mst_edges < n - 1) || (mst_i < m)) {

            a = edges.get(mst_i).u;
            b = edges.get(mst_i).v;
            w = edges.get(mst_i).wt;

            if (find(a) != find(b)) {
                union(a, b);
                mst_weight += w;
                System.out.println(a + "\t" + b + "\t" + w);
                mst_edges++;
            }
            mst_i++;
        }
        System.out.println("\nWeight of the MST is " + mst_weight);
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        parent[fx] = fy;
    }

    public static void main(String args[]) {

        int n = 7, m = 9;

        ArrayList<Edge> edges = new ArrayList<Edge>();

        edges.add(new Edge(1, 2, 4));
        edges.add(new Edge(7, 2, 2));
        edges.add(new Edge(6, 2, 3));
        edges.add(new Edge(5, 3, 20));
        edges.add(new Edge(4, 3, 6));
        edges.add(new Edge(4, 3, 6));
        edges.add(new Edge(1, 4, 7));
        edges.add(new Edge(2, 5, 2));
        edges.add(new Edge(2, 3, 1));
        System.out.println();

        new Kruskal(n, m, edges);
    }

}

class Edge {
    int u, v, wt;
    public Edge(int a, int b, int w) {
        this.u = a;
        this.v = b;
        this.wt = w;
    }
}
