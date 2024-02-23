import java.util.ArrayList;
import java.util.List;

public class _054_SpiralMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        var list = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return list;

        int x = 0, y = 0;
        int minX = 0, maxX = matrix[0].length - 1;
        int minY = 0, maxY = matrix.length - 1;

        var direction = Direction.Right;
        while (list.size() < matrix.length * matrix[0].length) {
            list.add(matrix[y][x]);
            switch (direction) {
                case Right:
                    if (x < maxX) {
                        x++;
                    } else {
                        direction = Direction.Down;
                        y++;
                        maxX--;
                    }
                    break;
                case Down:
                    if (y < maxY) {
                        y++;
                    } else {
                        direction = Direction.Left;
                        x--;
                        maxY--;
                    }
                    break;
                case Left:
                    if (x > minX) {
                        x--;
                    } else {
                        direction = Direction.Up;
                        y--;
                        minX++;
                    }
                    break;
                case Up:
                    if (y > minY + 1) {
                        y--;
                    } else {
                        direction = Direction.Right;
                        x++;
                        minY++;
                    }
                    break;
            }
        }
        return list;
    }

    private enum Direction {
        Up,
        Down,
        Left,
        Right
    }
}

