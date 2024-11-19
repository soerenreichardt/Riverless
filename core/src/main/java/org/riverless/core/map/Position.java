package org.riverless.core.map;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void set(Position position) {
        set(position.x(), position.y());
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(Direction direction, int distance) {
        var x = this.x;
        var y = this.y;
        switch (direction) {
            case UP -> y -= distance;
            case DOWN -> y += distance;
            case LEFT -> x -= distance;
            case RIGHT -> x += distance;
        }
        return new Position(x, y);
    }

    public static Position adjacent(Position position, Direction direction) {
        return switch (direction) {
            case UP -> new Position(position.x(), position.y() - 1);
            case DOWN -> new Position(position.x(), position.y() + 1);
            case LEFT -> new Position(position.x() - 1, position.y());
            case RIGHT -> new Position(position.x() + 1, position.y());
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }
}
