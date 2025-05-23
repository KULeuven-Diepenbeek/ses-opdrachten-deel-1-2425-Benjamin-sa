package be.ses;

import java.util.ArrayList;
import java.util.List;

public class CheckNeighboursInGrid {

    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height,
            int indexToCheck) {
        List<Integer> gridList = new ArrayList<>();
        for (Integer value : grid) {
            gridList.add(value);
        }

        Integer valueToCheck = gridList.get(indexToCheck);

        int row = indexToCheck / width;
        int col = indexToCheck % width;

        List<Integer> result = new ArrayList<>();

        for (int r = Math.max(0, row - 1); r <= Math.min(height - 1, row + 1); r++) {
            for (int c = Math.max(0, col - 1); c <= Math.min(width - 1, col + 1); c++) {
                if (r == row && c == col)
                    continue;

                int neighborIndex = r * width + c;

                if (gridList.get(neighborIndex).equals(valueToCheck)) {
                    result.add(neighborIndex);
                }
            }
        }

        return result;
    }
}