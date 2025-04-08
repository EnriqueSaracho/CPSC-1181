/**
 * A class that represents the protocols for the hotel server and client.
 * 
 * @author Enrique Saracho Felix
 */
public interface Protocols {
    int PORT = 12345; // port for the server and client
    int USER = 0; // user command
    int RESERVE = 1; // reserve command
    int CANCEL = 2; // cancel command
    int AVAIL = 3; // availability command
    int QUIT = 4; // quit command
}