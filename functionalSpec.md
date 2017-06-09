# Functional Specfication of Data Communication Project
[markdown cheatsheet here](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

## Overview
This is a set of Java classes that implements 
1) a packet transmission end point (sender and the receiver)
2) the packet
3) a main class for testing

## Details of the data packet in our protocol
The data packets consists of
1) Header - which contains: sequence number and a checksum for error detection
2) Payload - which contains a part of the entire message

Each data packet is 64 characters in size

**header** 6 characters 
first 3 = Sequence number eg '000' - '999' - maximum 1000 packets message size 
next 3 = checksum eg 0-999  it should be between 0-255  MOD 256

**Payload** 57+1 = 58 characters
3 x 19 = actual payload eg '123123123123...' which represents data '{{{{.....'
so each set of 3 numbers represents the ASCII value of a character.
add a NULL character to the end to get a round 64 (2^6) size.

## List of Classes and Methods
### the *Packet* class
This class implements one packet of data that will be the basic unit of communication
Every message sent will be broken into these packets and then sent (this sending will be simulated)
The rules (protocols) for our packets are explained above
#### attributes ####
1) sequence number
2) checksum
3) string to send
#### methods ####
1) TellMeAboutYourself - a method that prints out the private attribute values
3) calcChecksum - calculates the checksum given the payload
2) calcStrToSend - takes the payload and sequence number, calculates a checksum and the string to send 
3) Packet - constructor that creates a packet given a sequence number as an int and a payload as a string
4) pad - a helper method that pads ASCII codes less than 3 digits into 3 digit strings (eg 99 into '099') 

### the *DataCommsMachine* class
This class has both sending and receiving powers. 
In the sender the message is broken into packets, the sequence number and checksum is added.
In the receiver each packet is checked for errors (asked to be resent by sequence number if there are errors)
then the message is reassembled in order and passed back to the main program.
#### attributes ####
1) packetList

#### methods ####
0) preparePackets - takes a message and breaks into the list of Packets to then send via a 
[packet switching network](https://en.wikipedia.org/wiki/Packet_switching)

1) reassemblePackets - takes an unordered list of Packets and puts them in order

!!!! 2) checkChecksum - calculates a checksum on a packet!!!!

3) reqResend - ask the sender to resend a particular packet defined by the sequence number

4) receivePacket - obtains a packet

5) sendPacket - sends a packet to another DataCommsMachine

### the *mainProgram* class
This class implements the main program (and the main method) that will be used to test our packets
Here, a message is entered,  receiver side
