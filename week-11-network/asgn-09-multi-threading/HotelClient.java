import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * A class that represents a hotel client that allows clients to reserve,
 * cancel, and check availability of rooms.
 * 
 * @author Enrique Saracho Felix
 */
public class HotelClient implements Protocols {

    public static void main(String[] args) throws IOException {
        // Creating a variables for connection to the server
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        String serverHost = "localhost";

        try {
            socket = new Socket(serverHost, PORT); // connecting to the server
            System.out.println("Connected to the hotel server");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            buildUI(in, out); // building the options menu
        } catch (IOException e) {
            System.out.println("Error connecting to the hotel server");
            System.exit(1);
        } finally {
            if (socket != null) {
                socket.close();
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Builds the UI for the hotel client.
     * 
     * @param in  the input stream from the server
     * @param out the output stream to the server
     * @throws IOException if an I/O error occurs
     */
    public static void buildUI(DataInputStream in, DataOutputStream out) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Getting the user's name
        System.out.print("Enter your name: ");
        String n = scanner.nextLine();
        out.writeInt(USER);
        out.flush();
        out.writeUTF(n);
        out.flush();
        String response = in.readUTF();
        System.out.println("\n" + response);

        // Building the options menu
        while (true) {
            try {
                System.out.println("Options: ");
                System.out.println("1. RESERVE");
                System.out.println("2. CANCEL");
                System.out.println("3. AVAIL");
                System.out.println("4. QUIT");
                System.out.print("Enter a command: ");
                int command = scanner.nextInt();

                // Starting the request
                startRequest(command, in, out, scanner);

            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    /**
     * Starts the request for the hotel client.
     * 
     * @param command the command to be executed
     * @param in      the input stream from the server
     * @param out     the output stream to the server
     * @param scanner the scanner for the user input
     * @throws IOException if an I/O error occurs
     */
    public static void startRequest(int command, DataInputStream in, DataOutputStream out, Scanner scanner)
            throws IOException {
        switch (command) {
            case RESERVE:
                // Getting the date of entry and departure
                System.out.print("Enter the date of entry: ");
                int first = scanner.nextInt();
                System.out.print("Enter the date of departure: ");
                int last = scanner.nextInt();
                out.writeInt(RESERVE);
                out.flush();
                out.writeInt(first);
                out.flush();
                out.writeInt(last);
                out.flush();
                // Getting the response from the server
                String response = in.readUTF();
                System.out.println("\n" + response);
                break;

            case CANCEL:
                // Cancelling the reservation
                out.writeInt(CANCEL);
                out.flush();
                response = in.readUTF();
                System.out.println("\n" + response);
                break;

            case AVAIL:
                // Checking the availability of the rooms
                out.writeInt(AVAIL);
                out.flush();
                response = in.readUTF();
                System.out.println("\n" + response);
                break;

            case QUIT:
                // Quitting the program
                out.writeInt(QUIT);
                out.flush();
                response = in.readUTF();
                System.out.println("\n" + response);
                System.exit(0);
                break;
            default:
                // Default case
                out.writeInt(command);
                out.flush();
                response = in.readUTF();
                System.out.println("\n" + response);
                System.exit(0);
                break;
        }
    }
}
