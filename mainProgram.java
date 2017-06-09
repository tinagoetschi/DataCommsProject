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
            //Packet DataPacket1 = new Packet(55, "hello world");
            //DataPacket1.calcChecksum();
            //DataPacket1.calcStrToSend();
            //DataPacket1.TellMeAboutYourself();
            DataCommsMachine sender = new DataCommsMachine("Sammy the sender");
            DataCommsMachine receiver = new DataCommsMachine("Rachel the receiver");
            //System.out.println("Please enter the message you want to send via the packet switching network");
            //String message = userInput.nextLine();
            String message = "hello world this is a really long message that i will be using for debuging &*£(%^836578265 more stuff folowing this rubbish yooo wooo wooo";
            System.out.println("the message "+message+" will now be prepared into packets and send. Bear with.....");
            sender.preparePackets(message);

        }
    }

