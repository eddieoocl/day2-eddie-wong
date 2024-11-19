package org.marsrover;

import java.util.ArrayList;
import java.util.Arrays;

enum Command {
    Left("L"),
    Right("R"),
    Move("M");

    private String value;

    Command(final String value) {
        this.value = value;
    }

    public static Command getCommand(final String value) {
        for (final Command command : Command.values()) {
            if (command.value.equals(value)) {
                return command;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return value;
    }
}

enum MovingDirection {
    Forward, Backward
}

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

    public void execute(String command) {
        Command cmd = Command.getCommand(command);
        switch (cmd) {
            case Left: {
                rotate(Rotation.Left);
                break;
            }
            case Right: {
                rotate(Rotation.Right);
                break;
            }
            case Move: {
                move(MovingDirection.Forward);
                break;
            }
        }
    }

    public void bashExecute(String bashCommand) {
        for (char command : bashCommand.toCharArray()) {
            execute(Character.toString(command));
        }
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

    public void move(MovingDirection movingDirection) {
        switch (movingDirection) {
            case Forward: {
                moveForward();
                break;
            }
            case Backward: {
                moveBackward();
            }
        }
    }

    public void moveForward() {
        switch (this.direction) {
            case North: {
                this.y += 1;
                break;
            }
            case East: {
                this.x += 1;
                break;
            }
            case South: {
                this.y -= 1;
                break;
            }
            case West: {
                this.x -= 1;
                break;
            }
        }
    }

    public void moveBackward() {
        switch (this.direction) {
            case North: {
                this.y -= 1;
                break;
            }
            case East: {
                this.x -= 1;
                break;
            }
            case South: {
                this.y += 1;
                break;
            }
            case West: {
                this.x += 1;
                break;
            }
        }
    }
}
