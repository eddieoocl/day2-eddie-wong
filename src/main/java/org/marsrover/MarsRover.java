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
        switch (this.direction) {
            case North: {
                this.direction = Direction.West;
                break;
            }
            case East: {
                this.direction = Direction.North;
                break;
            }
            case South: {
                this.direction = Direction.East;
                break;
            }
            case West: {
                this.direction = Direction.South;
                break;
            }
        }
    }

    public void rotateRight() {
        switch (this.direction) {
            case North: {
                this.direction = Direction.East;
                break;
            }
            case East: {
                this.direction = Direction.South;
                break;
            }
            case South: {
                this.direction = Direction.West;
                break;
            }
            case West: {
                this.direction = Direction.North;
                break;
            }
        }
    }
}
