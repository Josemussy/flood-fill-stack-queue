import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        int[][] matrix = new int[rows][cols];

        // Preenchendo a matriz com 1's e diagonal com 0's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }

        System.out.println("Matriz inicial:");
        Matrix.printMatrix(matrix);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a coordenada x inicial: ");
        int startX = scanner.nextInt();
        System.out.print("Digite a coordenada y inicial: ");
        int startY = scanner.nextInt();

        System.out.print("Digite o valor de preenchimento: ");
        int fillValue = scanner.nextInt();

        System.out.print("Escolha o algoritmo (1-Pilha, 2-Fila): ");
        int algorithmChoice = scanner.nextInt();

        FloodFill floodFillAlgorithm;
        if (algorithmChoice == 1) {
            floodFillAlgorithm = new FloodFillStack();
        } else if (algorithmChoice == 2) {
            floodFillAlgorithm = new FloodFillQueue();
        } else {
            System.out.println("Escolha de algoritmo inválida. Saindo do programa.");
            return;
        }

        try {
            floodFillAlgorithm.performFloodFill(matrix, startX, startY, matrix[startY][startX], fillValue);
        } catch (IllegalArgumentException e) {
            System.out.println("Coordenadas iniciais inválidas. Saindo do programa.");
        }
    }
}