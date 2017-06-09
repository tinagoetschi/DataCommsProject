/**
 * Created by t.gotschi on 09/06/2017.
 */
import java.util.ArrayList;

public class DataCommsMachine {

    //attributes
    // and array list of packet objects
    ArrayList<Packet> packetList;
    String name;

    //constructor - parameter is the NAME of this machine....
    public DataCommsMachine(String n) {

        name = n;
        System.out.println("new machine made with the name "+name);

    }

    public void preparePackets(String m) {
        String newStr;
        String leftOver;
        int pCount=0;
        packetList = new ArrayList<Packet>();

        while (m.length() > 0 ) {
            try {
                newStr = m.substring(0, 19);
                leftOver = m.substring(19, m.length());
            } catch (Exception e) {
                 newStr = m;
                 leftOver = "";
            }

            System.out.println("packet being created with " + newStr);
            // add a new Packet object to our packetList ArrayList
            Packet DataPacket = new Packet(pCount, newStr);
            DataPacket.calcChecksum();
            DataPacket.calcStrToSend();
            DataPacket.TellMeAboutYourself();
            packetList.add(DataPacket);

            pCount++;
            m = leftOver;
        } // end of while
        System.out.println(packetList);
    } // end of preparePacketethod


} // end of class
