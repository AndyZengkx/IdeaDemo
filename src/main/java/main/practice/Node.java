package main.practice;

import java.util.Objects;

public class Node {
    public int x1, x2, y1, y2, step;

    public int hashCode() {
        return Objects.hash(x1, x2, y1, y2);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node od = (Node) o;
        return x1 == od.x1 && x2 == od.x2 && y1 == od.y1 && y2 == od.y2;
    }

    Node(int x1, int y1, int x2, int y2, int step) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.step = step;
    }
}
