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
}
