package org.marsrover;

enum Rotation {
    Left, Right
}

enum Direction {
    North("N"), East("E"), South("S"), West("W");

    private String value;

    Direction(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}


public class MarsRover {
    private Direction direction;
    private int x;
    private int y;

    public MarsRover() {
        this.direction = Direction.North;
        this.x = 0;
        this.y = 0;
    }

    public MarsRover(Direction direction) {
        this.direction = direction;
        this.x = 0;
        this.y = 0;
    }

    public String generateStatus() {
        return String.format("%d:%d:%s", x, y, this.direction.toString());
    }

    public void rotate(Rotation rotation) {
        return;
    }
}
