package org.vsu.rangemap;

import org.junit.jupiter.api.Test;
import org.vsu.range.BoundType;
import org.vsu.range.IntRange;

import static org.junit.jupiter.api.Assertions.*;

class IntRangeTest {

    @Test
    void compareTo1() {
        IntRange r1 = new IntRange(0, 10, BoundType.CLOSED, BoundType.OPEN);
        IntRange r2 = new IntRange(0, 10, BoundType.CLOSED, BoundType.CLOSED);
        assertTrue(r1.compareTo(r2) < 0);
    }

    @Test
    void compareTo2() {
        IntRange r1 = new IntRange(0, 10, BoundType.CLOSED, BoundType.OPEN);
        IntRange r2 = new IntRange(0, 11, BoundType.CLOSED, BoundType.OPEN);
        assertTrue(r1.compareTo(r2) < 0);
    }
}