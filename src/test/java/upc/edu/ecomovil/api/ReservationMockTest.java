package upc.edu.ecomovil.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import upc.edu.ecomovil.api.reservations.domain.model.aggregates.Reservation;
import upc.edu.ecomovil.api.reservations.domain.model.commands.CreateReservationCommand;
import upc.edu.ecomovil.api.user.domain.model.aggregates.Profile;
import upc.edu.ecomovil.api.vehicles.domain.model.aggregates.Vehicle;

public class ReservationMockTest {
    @Test
    public void testConstructorWithCreateReservationCommand() {
        // Arrange
        CreateReservationCommand mockCommand = mock(CreateReservationCommand.class);
        Vehicle mockVehicle = mock(Vehicle.class);
        Profile mockProfile = mock(Profile.class);

        when(mockCommand.status()).thenReturn("pending");

        // Act
        Reservation reservation = new Reservation(mockCommand, mockVehicle, mockProfile);

        // Assert
        assertEquals("pending", reservation.getStatus());
        assertEquals(mockVehicle, reservation.getVehicle());
        assertEquals(mockProfile, reservation.getProfile());
    }
}
