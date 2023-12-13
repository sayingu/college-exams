public class UseDataMessage {
    public static void main(String[] args) {
        // Create one object (instance) of the DataMessage class and name it msg1. Be
        // sure to use the names
        // exactly as I specify them. Think about what the type of this variable msg1
        // should be. This message object
        // should be created with the constructor that does not take any argument.
        DataMessage msg1 = new DataMessage();

        // Now print the value of each field in msg1 to the standard output device
        // (i.e., screen) using the values
        // returned by the getters. As you print out the values for the fields, properly
        // annotate the values being printed
        // out so they will be meaningful. Use something that indicates what physical
        // thing (air temp, etc) the value
        // represents. NOT the data type!

        // Add a piece of code in the main of UseDataMessage that prints the state
        // information of msg1 using
        // the toString method that you just added to DataMessage
        System.out.println(msg1.toString());

        // This time change the value of each field in msg1 using the setters if
        // available. You may use any
        // reasonable values for the fields as you modify them
        msg1.setName("Manitoba_1_7");
        msg1.setDate("Fri, Nov 8, 2019 at 1128 PM");
        msg1.setAirTemp(11.1);
        msg1.setGroundTemp(13.5);
        msg1.setWindSpeed(10);
        msg1.setHumidity(60);
        msg1.setUrgent(true);

        // Now print the value of each field in msg1 again using the getters. Be sure
        // that your getters are now seeing
        // the new values now that we have changed them using the setters. Again as you
        // print out the values for the
        // fields, properly annotate the values being printed out with the physical
        // property the value represents.
        msg1.transmit();

        // Create another object of type DataMessage and name it msg2 this time. This
        // data message object
        // should be created with the constructor that takes six arguments this time.
        // You can use any reasonable
        // values as arguments in the call to the constructor
        DataMessage msg2 = new DataMessage("Lisbon_1_1", "Fri, Nov 16, 2019 at 2000 PM", 18.0, 23.5, 0.1, 99);

        // Now, print the value of each field in msg2 using the getters. Be sure that
        // your getters are seeing the
        // correct values. Again, as you print out the values for the fields, properly
        // annotate the values being printed
        // out
        msg2.transmit();

        // Add a piece of code in the main of UseDataMessage that creates an array of
        // data messages of length
        // 5. Name that array dataMessages. Add msg1 as the first element of the array
        // and msg2 as the second
        // element of the array. Create three more DataMessage objects of your choice
        // and add them to the array
        // too
        DataMessage msg3 = new DataMessage("Seoul_1_17", "Fri, Nov 17, 2019 at 2100 PM", 19.0, 25.5, 0.2, 97);
        DataMessage msg4 = new DataMessage("Busan_3_1", "Fri, Nov 18, 2019 at 2200 PM", 20.0, 26.6, 0.3, 98);
        DataMessage msg5 = new DataMessage("Gangseo_1_2", "Fri, Nov 19, 2019 at 2300 PM", 25.0, 29.4, 0.4, 99);
        DataMessage[] msgArr = { msg1, msg2, msg3, msg4, msg5 };

        // In the main, write a for loop that loops through the message objects in the
        // dataMessages array and
        // calls checkHardware() for each one.
        for (DataMessage msg : msgArr) {
            msg.checkHardware();
        }

        // In the main, add a for loop that loops through the data message objects in
        // the dataMessages array
        // and prints each message in the array using the transmit() method that you
        // added to DataMessage
        System.out.println("[[[Print all data messages]]]");
        for (DataMessage msg : msgArr) {
            msg.transmit();
        }
        System.out.println("");

        // Add another for loop that loops through the data message objects in the
        // dataMessages array once
        // more and prints only urgent messages in the array using transmit() this time.
        System.out.println("[[[Print urgent data messages only]]]");
        for (DataMessage msg : msgArr) {
            if (msg.getUrgent()) {
                msg.transmit();
            }
        }
    }
}
