package org.marsrover;

import java.util.ArrayList;
import java.util.Arrays;

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
    private final ArrayList<Direction> directions = new ArrayList<>(Arrays.asList(Direction.North, Direction.East, Direction.South, Direction.West));
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
        switch (rotation) {
            case Left: {
                rotateLeft();
                break;
            }
            case Right: {
                rotateRight();
            }
        }
    }

    public void rotateLeft() {
        int nextDirectionIndex = directions.indexOf(this.direction) - 1 == -1 ? directions.size() - 1 : directions.indexOf(this.direction) - 1;
        this.direction = directions.get(nextDirectionIndex);
    }

    public void rotateRight() {
        int nextDirectionIndex = (directions.indexOf(this.direction) + 1) % directions.size();
        this.direction = directions.get(nextDirectionIndex);
    }
}
