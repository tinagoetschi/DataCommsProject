/**
 * Created by t.gotschi on 26/05/2017.
 */
import java.util.Scanner;

public class mainProgram {

    //imports... you may want input from the user?

        // create an instance of the Scanner class
        public static Scanner userInput = new Scanner(System.in);

        // your main program starts here... write you code to instatiate and test your class
        public static void main(String[] args) {


            System.out.println("Welcome to my Data Comms Protocol Project");
            Packet DataPacket1 = new Packet(55, "hello world");
            DataPacket1.calcChecksum();
            DataPacket1.calcStrToSend();
            DataPacket1.TellMeAboutYourself();



        }
    }

