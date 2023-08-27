public class FloodFillStack implements FloodFill {
    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private DinamicStack<Position> stack = new DinamicStack<>();



    @Override
    public void performFloodFill(int[][] matrix, int startX, int startY, int targetValue, int fillValue) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (startX < 0 || startX >= rows || startY < 0 || startY >= cols) {
            throw new IllegalArgumentException("Invalid starting coordinates");
        }

        int originalValue = matrix[startX][startY];
        if (originalValue == fillValue) {
            return;
        }

        stack.push(new Position(startX, startY));

        while (!stack.isEmpty()) {
            Position current = stack.pop();
            int x = current.x;
            int y = current.y;

            if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] != originalValue) {
                continue;
            }


            matrix[x][y] = fillValue;
            Matrix.printMatrix(matrix);

            stack.push(new Position(x - 1, y));
            stack.push(new Position(x + 1, y));
            stack.push(new Position(x, y - 1));
            stack.push(new Position(x, y + 1));
        }
    }
}