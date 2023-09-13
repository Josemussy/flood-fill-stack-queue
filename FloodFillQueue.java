public class FloodFillQueue implements FloodFill {
    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private DinamicQueue<Position> queue = new DinamicQueue<>();                       //Fila encadeada para armazenar posicoes

    //Sobrescrita do metodo abstrato da interface para executar flood fill usando fila
    @Override
    public void performFloodFill(int[][] matrix, int startX, int startY, int targetValue, int fillValue) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (startX < 0 || startX >= rows || startY < 0 || startY >= cols) {           //Verificacao da posicao inicial
            throw new IllegalArgumentException("Invalid starting coordinates");
        }

        int originalValue = matrix[startX][startY];
        if (originalValue == fillValue) {                                             //Se valor da posicao for igual valor a sobrescrever nada é feito
            return;
        }

        queue.add(new Position(startX, startY));                                      //Adiciona posicao inicial a fila

        while (!queue.isEmpty()) {
            Position current = queue.remove();                                        //Remove posicao atual da fila
            int x = current.x;
            int y = current.y;

            // Verifica se a posicao esta dentro dos limites da matriz e se o valor é o valor original
            if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] != originalValue) {
                continue;                                                              //Pula para a proxima iteracao
            }

            matrix[x][y] = fillValue;                                                  //Altera o valor da posicao com o valor a ser preenchido
            Matrix.printMatrix(matrix);                                                //Imprime a matriz apos alteracao

            //Adiciona as posicoes da fronteira a fila para verificacao e preenchimento
            queue.add(new Position(x - 1, y));
            queue.add(new Position(x + 1, y));
            queue.add(new Position(x, y - 1));
            queue.add(new Position(x, y + 1));
        }
    }
}