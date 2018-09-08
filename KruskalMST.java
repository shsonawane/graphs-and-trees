
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalMST {

    int parent[] = new int[10];

    int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) {
        KruskalMST kru = new KruskalMST();

        for (int i = 0; i < 10; i++) {
            kru.parent[i] = i;
        }

        ArrayList<Edge1> edges = new ArrayList<Edge1>();

        int n = 7,
                m = 9;
        int a, b, w;

        edges.add(new Edge1(1, 2, 4));
        edges.add(new Edge1(7, 2, 2));
        edges.add(new Edge1(6, 2, 3));
        edges.add(new Edge1(5, 3, 20));
        edges.add(new Edge1(4, 3, 6));
        edges.add(new Edge1(4, 3, 6));
        edges.add(new Edge1(1, 4, 7));
        edges.add(new Edge1(2, 5, 2));
        edges.add(new Edge1(2, 3, 1));

        Collections.sort(edges, new Comparator<Edge1>() {
            @Override
            public int compare(Edge1 o1, Edge1 o2) {
                return o1.wt = o2.wt;
            }
        });

        System.out.println();

        int mst_weight = 0, mst_edges = 0;
        int mst_i = 0;
        System.out.println("V1\tV2\tWeight");
        while ((mst_edges < n - 1) || (mst_i < m)) {

            a = edges.get(mst_i).u;
            b = edges.get(mst_i).v;
            w = edges.get(mst_i).wt;

            if (kru.find(a) != kru.find(b)) {
                kru.union(a, b);
                mst_weight += w;
                System.out.println(a + "\t" + b + "\t" + w);
                mst_edges++;
            }
            mst_i++;
        }
        System.out.println("\nWeight of the MST is " + mst_weight);

    }

}

class Edge1 {

    int u, v, wt;

    public Edge1(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

}
