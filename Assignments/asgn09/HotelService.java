import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * A class that represents a hotel service that allows clients to reserve, cancel, and check availability of rooms.
 * 
 * @author Enrique Saracho Felix
 */
public class HotelService implements Protocols, Runnable {
    // Creating variables for the connection
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;

    private Hotel hotel; // hotel for the service
    private String n; // name of the user

    /**
     * Constructor for the hotel service.
     * 
     * @param client the client socket
     * @param hotel the hotel
     */
    public HotelService(Socket client, Hotel hotel) {
        this.client = client;
        this.hotel = hotel;
    }

    /**
     * Runs the hotel service.
     */
    @Override
    public void run() {
        try {
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
                doService();
            } finally {
                client.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Does the service for the hotel.
     * 
     * @throws IOException if an I/O error occurs
     */
    private void doService() throws IOException {
        int command = in.readInt();
        if (command == USER) {
            n = in.readUTF();
            out.writeUTF("Hello, " + n);
        } else {
            out.writeUTF("Invalid command: closing connection");
            return;
        }

        while (true) {
            command = in.readInt();
            if (command == QUIT) {
                out.writeUTF("Closing connection");
                return;
            } else {
                executeCommand(command);
            }
        }
    }

    /**
     * Executes the command for the hotel.
     * 
     * @param command the command to be executed
     */
    private void executeCommand(int command) {
        try {
            if (command == RESERVE) {
                // Reserving the room
                // Getting the date of entry and departure
                int first = in.readInt();
                int last = in.readInt();
                if (hotel.requestReservation(n, first, last)) {
                    out.writeUTF("Reservation made: " + n + " from " + first + " to " + last + "\n");
                } else {
                    out.writeUTF("Reservation unsuccessful: " + n + " from " + first + " to " + last + "\n");
                }
            } else if (command == CANCEL) {
                // Cancelling the reservation
                if (hotel.cancelReservation(n)) {
                    out.writeUTF("Reservation successfully cancelled for " + n + "\n");
                } else {
                    out.writeUTF("Reservation not cancelled for " + n + ", no current reservation" + "\n");
                }
            } else if (command == AVAIL) {
                // Checking the availability of the rooms
                out.writeUTF(hotel.toString() + "\n");
            } else if (command == QUIT) {
                // Quitting the program
                out.writeUTF("Closing connection");
                return;
            } else {
                // Default case
                out.writeUTF("Invalid command: closing connection");
                return;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
