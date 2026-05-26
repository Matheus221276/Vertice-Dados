import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printHeader();

        int vertexCount = readPositiveInt(scanner, "Quantidade de vertices: ");
        Graph graph = new Graph(vertexCount);

        int maxEdges = vertexCount * (vertexCount - 1) / 2;

        int edgeCount = readIntInRange(
                scanner,
                "Quantidade de arestas: ",
                0,
                maxEdges
        );

        for (int i = 1; i <= edgeCount; i++) {
            while (true) {
                String line = readText(scanner, "Aresta " + i + " (exemplo: 1 2): ");
                String[] parts = line.split("\\s+");

                if (parts.length != 2) {
                    System.out.println("Entrada invalida. Digite dois vertices separados por espaco.");
                    continue;
                }

                try {
                    int first = Integer.parseInt(parts[0]);
                    int second = Integer.parseInt(parts[1]);

                    if (!graph.isValidVertex(first) || !graph.isValidVertex(second)) {
                        System.out.println("Aresta invalida. Use vertices entre 1 e " + vertexCount + ".");
                    } else if (first == second) {
                        System.out.println("Aresta invalida. Um vertice nao pode se ligar a ele mesmo.");
                    } else if (graph.hasEdge(first, second)) {
                        System.out.println("Aresta ja cadastrada. Digite outra.");
                    } else {
                        graph.addEdge(first, second);
                        break;
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Entrada invalida. Digite apenas numeros.");
                }
            }
        }

        VertexCoverSolver solver = new VertexCoverSolver(graph);
        List<Integer> cover = solver.findMinimumVertexCover();

        printSection("Resultado do Vertex Cover");

        if (cover.isEmpty()) {
            System.out.println("Nenhum vertice foi escolhido, pois o grafo nao possui arestas.");
        } else {
            System.out.println("Vertices escolhidos:");
            for (Integer vertex : cover) {
                System.out.println("- Vertice " + vertex);
            }
        }

        System.out.println("Tamanho da cobertura: " + cover.size());

        printSection("Analise de complexidade");
        System.out.println("Algoritmo utilizado: Backtracking exato com poda.");
        System.out.println("Complexidade de tempo: O(2^n * m).");
        System.out.println("Complexidade de memoria: O(n + m).");
        System.out.println("Vertex Cover de decisao e NP-Completo.");
        System.out.println("Vertex Cover de otimizacao e NP-Dificil.");

        scanner.close();
    }

    private static void printHeader() {
        System.out.println("============================================================");
        System.out.println("        SIMULACAO DE WAR ROOM COM GRAFOS - VERTEX COVER");
        System.out.println("============================================================");
        System.out.println();
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println(title);
        System.out.println("------------------------------------------------------------");
    }

    private static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            String input = readText(scanner, message);

            try {
                int value = Integer.parseInt(input);

                if (value > 0) {
                    return value;
                }

                System.out.println("Digite um numero maior que zero.");
            } catch (NumberFormatException exception) {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
            }
        }
    }

    private static int readIntInRange(Scanner scanner, String message, int min, int max) {
        while (true) {
            String input = readText(scanner, message);

            try {
                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("Digite um numero entre " + min + " e " + max + ".");
            } catch (NumberFormatException exception) {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
            }
        }
    }

    private static String readText(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}