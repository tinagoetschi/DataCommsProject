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
The rules (protocols) for our packets are as follows:

### the *DataCommsMachine* class
This class has both sending and receiving powers. 
In the sender the message is broken into packets, the sequence number and checksum is added.
In the receiver each packet is checked for errors (asked to be resent by sequence number if there are errors)
then the message is reassembled in order and passed back to the main program.

### the *mainProgram* class
This class implements the main program (and the main method) that will be used to test our packets
Here, a message is entered,  receiver side
