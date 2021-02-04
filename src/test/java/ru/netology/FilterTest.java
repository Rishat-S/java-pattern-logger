package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterTest {

    @Test
    void filterOutTest() {
        int threshold = 5;
        Filter filter = new Filter(threshold);

        List<Integer> sourceList = Arrays.asList(3, 5, 10, 12);
        List<Integer> filteredList = filter.filterOut(sourceList);
        List<Integer> expectedList = Arrays.asList(10, 12);

        assertEquals(expectedList, filteredList);
    }
}