import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private final int vertexCount;
    private final List<Edge> edges;
    private final Set<String> edgeKeys;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edges = new ArrayList<>();
        this.edgeKeys = new HashSet<>();
    }

    public void addEdge(int first, int second) {
        edges.add(new Edge(first, second));
        edgeKeys.add(createEdgeKey(first, second));
    }

    public boolean hasEdge(int first, int second) {
        return edgeKeys.contains(createEdgeKey(first, second));
    }

    public boolean isValidVertex(int vertex) {
        return vertex >= 1 && vertex <= vertexCount;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    private String createEdgeKey(int first, int second) {
        int smaller = Math.min(first, second);
        int bigger = Math.max(first, second);

        return smaller + "-" + bigger;
    }
}