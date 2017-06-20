import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

/**
 * Created by hyan on 6/20/17.
 */
public class ClosestG {
    public int[][] minSteps(char[][] board, int rows, int columns) {
        int[][] closest = new int[rows][columns];

        Set<Integer> visited = new HashSet<>();
        Set<Integer> lastVisited = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char c = board[row][column];
                if ('G' == c) {
                    closest[row][column] = 0;
                    visited.add(row * columns + column);
                    lastVisited.add(row * columns + column);
                } else {
                    if ('W' == c) {
                        visited.add(row * columns + column);
                    }
                    closest[row][column] = Integer.MAX_VALUE;
                }
            }
        }

        int n = visited.size();

        if (n == 0) {
            return closest;
        }


        int layer = 0;
        do {
            n = visited.size();
            Set<Integer> neighbors = new HashSet<>();
            for (int pos : lastVisited) {
                int row = pos / columns;
                int column = pos % columns;
                if (column > 0 && !visited.contains(pos - 1)) {
                    neighbors.add(pos - 1);
                }
                if (row > 0 && !visited.contains(pos - columns)) {
                    neighbors.add(pos - columns);
                }

                if (column + 1 < columns && !visited.contains(pos + 1)) {
                    neighbors.add(pos + 1);
                }
                if (row + 1 < rows && !visited.contains(pos + columns)) {
                    neighbors.add(pos + columns);
                }
            }

            layer++;
            for (int neighbor: neighbors) {
                int row = neighbor / columns;
                int column = neighbor % columns;
                closest[row][column] = layer;
            }
            lastVisited = neighbors;
            visited.addAll(lastVisited);
        } while (n < visited.size());

        return closest;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {' ', ' ', 'G', ' '},
                {' ', ' ', ' ', ' '},
                {'G', ' ', 'W', ' '},
                {' ', ' ', 'W', ' '},
                {'W', 'W', 'W', 'W'},
                {' ', ' ', 'G', ' '}
        };

        int[][] steps = new ClosestG().minSteps(board, board.length, board[0].length);

        for (int i = 0; i < steps.length; i++) {
            System.out.println(Arrays.stream(steps[i]).mapToObj(String::valueOf).collect(joining(", ")));
        }
    }
}

