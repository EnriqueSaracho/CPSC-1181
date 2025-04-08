import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

/**
 * A class that represents a hotel server that allows clients to reserve, cancel, and check availability of rooms.
 * 
 * @author Enrique Saracho Felix
 */
public class HotelServer implements Protocols {
    
    public static void main(String[] args) throws IOException {
        Hotel hotel = new Hotel(); // creating a new hotel

        ServerSocket server = new ServerSocket(PORT); // listening for client connections
        System.out.println("Hotel server is running on port: " + PORT);

        try {
            while (true) {
                Socket client = server.accept(); // accepting client connections
                System.out.println("Client connected. Welcome to the hotel!");

                HotelService service = new HotelService(client, hotel);

                Thread thread = new Thread(service); // creating a new thread for the client
                thread.start();
            }
        } finally {
            server.close(); // closing the server
        }
    }
}
