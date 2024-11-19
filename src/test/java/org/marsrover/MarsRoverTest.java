package org.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarsRoverTest {
    @Test
    public void should_initialize_mars_rover() {
        // Given
        MarsRover rover = new MarsRover();

        // When
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:N", status);
    }

    @Test
    public void should_face_west_when_direction_north_and_turn_left() {
        // Given
        MarsRover rover = new MarsRover(Direction.North);
        Rotation rotation = Rotation.Left;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:W", status);
    }

    @Test
    public void should_face_south_when_direction_west_and_turn_left() {
        // Given
        MarsRover rover = new MarsRover(Direction.West);
        Rotation rotation = Rotation.Left;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:S", status);
    }

    @Test
    public void should_face_east_when_direction_south_and_turn_left() {
        // Given
        MarsRover rover = new MarsRover(Direction.South);
        Rotation rotation = Rotation.Left;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:E", status);
    }

    @Test
    public void should_face_north_when_direction_east_and_turn_left() {
        // Given
        MarsRover rover = new MarsRover(Direction.East);
        Rotation rotation = Rotation.Left;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:N", status);
    }

    @Test
    public void should_face_east_when_direction_north_and_turn_right() {
        // Given
        MarsRover rover = new MarsRover(Direction.North);
        Rotation rotation = Rotation.Right;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:E", status);
    }

    @Test
    public void should_face_north_when_direction_west_and_turn_right() {
        // Given
        MarsRover rover = new MarsRover(Direction.West);
        Rotation rotation = Rotation.Right;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:N", status);
    }

    @Test
    public void should_face_west_when_direction_south_and_turn_right() {
        // Given
        MarsRover rover = new MarsRover(Direction.South);
        Rotation rotation = Rotation.Right;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:W", status);
    }

    @Test
    public void should_face_south_when_direction_east_and_turn_right() {
        // Given
        MarsRover rover = new MarsRover(Direction.East);
        Rotation rotation = Rotation.Right;

        // When
        rover.rotate(rotation);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:0:S", status);
    }

    @Test
    public void should_y_increase_by_1_when_direction_north_and_move_forward() {
        // Given
        MarsRover rover = new MarsRover(Direction.North);
        MovingDirection movingDirection = MovingDirection.Forward;

        // When
        rover.move(movingDirection);
        String status = rover.generateStatus();

        // Then
        assertEquals("0:1:N", status);
    }
}
