package org.samples;

import java.util.Objects;

public class AliveCell {
    private Integer x;
    private Integer y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AliveCell aliveCell = (AliveCell) o;
        return Objects.equals(x, aliveCell.x) && Objects.equals(y, aliveCell.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public AliveCell(Integer x
            , Integer y) {

        this.x = x;
        this.y = y;
    }
}
