import java.util.ArrayList;
import java.util.List;

public class VertexCoverSolver {
    private final Graph graph;
    private boolean[] bestCover;
    private int bestSize;

    public VertexCoverSolver(Graph graph) {
        this.graph = graph;
        this.bestCover = new boolean[graph.getVertexCount() + 1];
        this.bestSize = graph.getVertexCount() + 1;
    }

    public List<Integer> findMinimumVertexCover() {
        boolean[] currentCover = new boolean[graph.getVertexCount() + 1];

        backtrack(currentCover, 0);

        return convertToList(bestCover);
    }

    private void backtrack(boolean[] currentCover, int currentSize) {
        if (currentSize >= bestSize) {
            return;
        }

        Edge uncoveredEdge = findUncoveredEdge(currentCover);

        if (uncoveredEdge == null) {
            bestSize = currentSize;
            bestCover = currentCover.clone();
            return;
        }

        chooseVertex(currentCover, uncoveredEdge.getFirst(), currentSize);
        chooseVertex(currentCover, uncoveredEdge.getSecond(), currentSize);
    }

    private void chooseVertex(boolean[] currentCover, int vertex, int currentSize) {
        currentCover[vertex] = true;
        backtrack(currentCover, currentSize + 1);
        currentCover[vertex] = false;
    }

    private Edge findUncoveredEdge(boolean[] cover) {
        for (Edge edge : graph.getEdges()) {
            if (!cover[edge.getFirst()] && !cover[edge.getSecond()]) {
                return edge;
            }
        }

        return null;
    }

    private List<Integer> convertToList(boolean[] cover) {
        List<Integer> chosenVertices = new ArrayList<>();

        for (int i = 1; i <= graph.getVertexCount(); i++) {
            if (cover[i]) {
                chosenVertices.add(i);
            }
        }

        return chosenVertices;
    }
}