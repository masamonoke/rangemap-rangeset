package org.vsu.range.rangemap;

import org.junit.jupiter.api.Test;
import org.vsu.range.BoundType;
import org.vsu.range.IntRange;
import org.vsu.range.Range;

import static org.junit.jupiter.api.Assertions.*;

class RangeMapTest {
    @Test
    void test() {
        Range<Integer> range1 = new IntRange(0, 10, BoundType.OPEN, BoundType.OPEN);
        RangeMap<Integer, Integer> rangeMap = new RangeMap<>();
        rangeMap.put(new IntRange(0, 10, BoundType.OPEN, BoundType.OPEN), 10);
        assertTrue(rangeMap.isContainsKey(range1));
        rangeMap.remove(range1);
        assertFalse(rangeMap.isContainsKey(range1));
    }
}