package collection.set.test;

import java.util.Objects;

public class Rectangle {
    private int width;
    private int depth;

    public Rectangle(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && depth == rectangle.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, depth);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", depth=" + depth +
                '}';
    }
}
