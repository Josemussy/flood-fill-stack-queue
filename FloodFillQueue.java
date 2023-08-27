public class FloodFillQueue implements FloodFill {
    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private DinamicQueue<Position> queue = new DinamicQueue<>();


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

        queue.add(new Position(startX, startY));

        while (!queue.isEmpty()) {
            Position current = queue.remove();
            int x = current.x;
            int y = current.y;

            if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] != originalValue) {
                continue;
            }

            matrix[x][y] = fillValue;
            Matrix.printMatrix(matrix);

            queue.add(new Position(x - 1, y));
            queue.add(new Position(x + 1, y));
            queue.add(new Position(x, y - 1));
            queue.add(new Position(x, y + 1));
        }
    }
}