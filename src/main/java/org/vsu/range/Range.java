package org.vsu.range;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public abstract class Range <T extends Comparable<T>> implements Comparable<Range<T>> {
    T start;
    T end;
    BoundType leftBoundType;
    BoundType rightBoundType;

    @Override
    public String toString() {
        char left = leftBoundType == BoundType.OPEN ? '(' : '[';
        char right = rightBoundType == BoundType.OPEN ? ')' : ']';
        return String.valueOf(left) + start + ", " + end + right;
    }
}
