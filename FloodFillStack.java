public class FloodFillStack implements FloodFill {
    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private DinamicStack<Position> stack = new DinamicStack<>();                    //Pilha encadeada para armazenar posicoes


    //Sobrescrita do metodo abstrato da interface para executar flood fill usando pilha
    @Override
    public void performFloodFill(int[][] matrix, int startX, int startY, int targetValue, int fillValue) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (startX < 0 || startX >= rows || startY < 0 || startY >= cols) {         //Verificacao da posicao inicial
            throw new IllegalArgumentException("Invalid starting coordinates");
        }

        int originalValue = matrix[startX][startY];

        if (originalValue == fillValue) {                                           //Se valor da posicao for igual valor a sobrescrever nada é feito
            return;
        }

        stack.push(new Position(startX, startY));                                   //Adiciona posicao inicial a pilha

        while (!stack.isEmpty()) {
            Position current = stack.pop();                                         //Remove posicao atual da pilha
            int x = current.x;
            int y = current.y;

            // Verifica se a posicao esta dentro dos limites da matriz e se o valor é o valor original
            if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] != originalValue) {
                continue;                                                           //Pula para a proxima iteracao
            }


            matrix[x][y] = fillValue;                                               //Altera o valor da posicao com o valor a ser preenchido
            Matrix.printMatrix(matrix);                                             //Imprime a matriz apos alteracao

            //Adiciona as posicoes da fronteira a pilha para verificacao e preenchimento
            stack.push(new Position(x - 1, y));
            stack.push(new Position(x + 1, y));
            stack.push(new Position(x, y - 1));
            stack.push(new Position(x, y + 1));
        }
    }
}