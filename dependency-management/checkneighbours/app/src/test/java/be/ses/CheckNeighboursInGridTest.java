package be.ses;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CheckNeighboursInGridTest {

    @Test
    public void testGetSameNeighboursIds_CenterElement_FindsAllMatchingNeighbours() {

        List<Integer> grid = Arrays.asList(
                1, 2, 3,
                4, 5, 5,
                7, 5, 9);
        int width = 3;
        int height = 3;
        int indexToCheck = 4;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : result) {
            resultList.add(i);
        }
        assertTrue(resultList.contains(5));
        assertTrue(resultList.contains(7));
        assertEquals(2, resultList.size());
    }

    @Test
    public void testGetSameNeighboursIds_CornerElement_FindsMatchingNeighbours() {

        List<Integer> grid = Arrays.asList(
                7, 7, 3,
                7, 5, 5,
                7, 8, 9);
        int width = 3;
        int height = 3;
        int indexToCheck = 0;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : result) {
            resultList.add(i);
        }
        assertTrue(resultList.contains(1));
        assertTrue(resultList.contains(3));
        assertEquals(2, resultList.size());
    }

    @Test
    public void testGetSameNeighboursIds_LeftEdgeElement_FindsMatchingNeighbours() {
        List<Integer> grid = Arrays.asList(
                1, 2, 3,
                6, 5, 6,
                6, 8, 9);
        int width = 3;
        int height = 3;
        int indexToCheck = 3;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : result) {
            resultList.add(i);
        }
        assertTrue(resultList.contains(6));
        assertEquals(1, resultList.size());
    }

    @Test
    public void testGetSameNeighboursIds_RightEdgeElement_FindsMatchingNeighbours() {
        List<Integer> grid = Arrays.asList(
                1, 2, 3,
                4, 5, 3,
                7, 8, 3);
        int width = 3;
        int height = 3;
        int indexToCheck = 5;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : result) {
            resultList.add(i);
        }
        assertTrue(resultList.contains(2));
        assertTrue(resultList.contains(8));
        assertEquals(2, resultList.size());
    }

    @Test
    public void testGetSameNeighboursIds_NoMatchingNeighbours_ReturnsEmptyList() {
        List<Integer> grid = Arrays.asList(
                1, 2, 3,
                4, 5, 6,
                7, 8, 9);
        int width = 3;
        int height = 3;
        int indexToCheck = 4;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : result) {
            resultList.add(i);
        }
        assertEquals(0, resultList.size());
    }

    @Test
    public void testGetSameNeighboursIds_LargerGrid_FindsMatchingNeighbours() {

        List<Integer> grid = Arrays.asList(
                1, 2, 3, 4,
                5, 6, 6, 8,
                9, 6, 1, 2,
                3, 4, 5, 6);
        int width = 4;
        int height = 4;
        int indexToCheck = 5;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : result) {
            resultList.add(i);
        }
        assertTrue(resultList.contains(6));
        assertTrue(resultList.contains(9));
        assertEquals(2, resultList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSameNeighboursIds_IndexOutOfBounds_ThrowsException() {
        List<Integer> grid = Arrays.asList(1, 2, 3, 4);
        int width = 2;
        int height = 2;
        int indexToCheck = 10;

        CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSameNeighboursIds_EmptyGrid_ThrowsException() {
        List<Integer> grid = Collections.emptyList();
        int width = 0;
        int height = 0;
        int indexToCheck = 0;

        CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
    }
}
