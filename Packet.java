/**
 * Created by t.gotschi on 26/05/2017.
 */
public class Packet {
    //attributes
    //these two are the HEADER of the packet
    private int seqNum; // should this be a char??
    private int checkSum;
    private String payload;
    private String strToSend;

    // private  char[] payload; // remember 3 x19 = 57  must add 1 = 58
    //constructor

    public Packet (int sN, String pL ) {

        //set the attributes according to arguments passed
        seqNum = sN;
        payload = pL;

    }

    public void calcChecksum() {

        int sum = 0;
        // do the complicated checksum calc here
        // loop for the length of the string
        for (int i = 0; i < payload.length() ; i++) {
            char x = payload.charAt(i);
            int a = (int) x;
            sum += a;
        }
        sum = sum % 256;
        checkSum = sum;
    }

    //take number and pad to 3 characters eg 10 --> "010"  56 --> "056"   255 --> "255"
    private String pad(int num) {


        String s = Integer.toString(num);

        if (num < 10) {
            //pad with two 0
            s = "00" + s;

        } else if (num < 100) {
            //PAD WITH one 0
            s = "0" + s;
        }

        return s;
    }


    public void calcStrToSend() {


        strToSend = pad(seqNum) + pad(checkSum);

        for (int i = 0; i < payload.length(); i++) {
            char c = payload.charAt(i);
            int ascii = (int) c;
            strToSend += pad(ascii);

        }

        //set up the NULL
        int x=127;
        char asciiNull = (char) x;

        //if the packet payload is less than 19 groups of 3 pad with NULLs up to 63 characters
        while (strToSend.length()< 63) {
            strToSend+=asciiNull;
        }

        //FINALLY ADD ONE EXTRA NULL character to get to 64 chars
        strToSend+=asciiNull;
    }
    // write a method that allows a user of this class to gain some insight into attributes and methods
    public void TellMeAboutYourself() {

        System.out.println("my seq num is " + seqNum);
        System.out.println("my checksum is " +checkSum);
        System.out.println("my payload " +payload);
        System.out.println("my string to send  " +strToSend);
        System.out.println("my string to send  is this long " +strToSend.length());


    }

    //add methods as appropriate



} // end of  Class