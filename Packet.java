/**
 * Created by t.gotschi on 26/05/2017.
 */
public class Packet {
    //attributes
    //these two are the HEADER of the packet
    private int seqNum; // should this be a char??
    private int checkSum;

    private  char[] payload; // remember 3 x19 = 57  must add 1 = 58
    //constructor

    public Packet (int sN, char[] pL ) {

        //set the attributes according to arguments passed
        seqNum = sN;
        payload = pL;

    }

    public void calcChecksum() {

        int answer;

        // do the complicated checksum calc here
        answer = 42;

        checkSum = answer;
    }

    // write a method that allows a user of this class to gain some insight into attributes and methods
    public void TellMeAboutYourself() {

        System.out.println("my seq num is", seqNum);
        System.out.println("my checksum is", checkSum);
        System.out.println("my payload", payload);


    }

    //add methods as appropriate



} // end of  Class
