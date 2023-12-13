import java.util.Random;

public class DataMessage implements Cloneable {
    // fields

    // Add the
    // messageID to DataMessage as a private integer member. Provide a
    // getter and setter method for it. Do NOT change the constructors for
    // DataMessage. Simply add code to set MessageID to -1
    private int messageID;
    private String name;
    private String date;
    private double airTemp;
    private double groundTemp;
    private double windSpeed;
    private int humidity;
    private boolean urgent;

    // Add a String field to the class called notes. Update both of the constructors
    // to set this field to an empty
    // string (“”). Note: do NOT add new parameters to the constructors since you
    // are hardcoding the empty
    // string when setting the value of notes.
    private String notes;

    // constructor
    public DataMessage() {
        this.messageID = -1;
        this.name = "";
        this.date = "";
        this.airTemp = 0.0;
        this.groundTemp = 0.0;
        this.windSpeed = 0.0;
        this.humidity = 0;
        this.urgent = false;
        this.notes = "";
    }

    public DataMessage(String name, String date, double airTemp, double groundTemp, double windSpeed, int humidity) {
        this.messageID = -1;
        this.name = name;
        this.date = date;
        this.airTemp = airTemp;
        this.groundTemp = groundTemp;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.urgent = false;
        this.notes = "";
    }

    // getters
    public int getMessageID() {
        return messageID;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getAirTemp() {
        return airTemp;
    }

    public double getGroundTemp() {
        return groundTemp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public boolean getUrgent() {
        return urgent;
    }

    // Setters
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAirTemp(double airTemp) {
        this.airTemp = airTemp;
    }

    public void setGroundTemp(double groundTemp) {
        this.groundTemp = groundTemp;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    // Add a public non-static method called serialize() which takes no arguments
    // and returns a String. The String
    // return value should contain a ‘compact’ form of all the data in the object.
    // The compact form should include
    // all the weather measurements with preceding labels. Use ‘:’ to separate the
    // labels from the values and use
    // ‘;’ to separate the name/value pairs. For instance, with air temperature of
    // 20.5, ground temperature of 22.2,
    // wind speed of 25, and humidity of 15 and nothing in notes, the output of
    // serialize() should be:
    // airTemp:20.5;groundTemp:22.2;windspeed:25.0;humidity:15;notes:””
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("airTemp:").append(this.airTemp).append(";");
        sb.append("groundTemp:").append(this.groundTemp).append(";");
        sb.append("windSpeed:").append(this.windSpeed).append(";");
        sb.append("humidity:").append(this.humidity).append(";");
        sb.append("notes:").append("\"").append(this.notes).append("\"");
        return sb.toString();
    }

    // Add a public non-static method called checkHardware(). This method does not
    // return a value! Since we do
    // not have real hardware, you will simulate this by using a random object to
    // determine if there is a failure
    // and, if so, on which sensor the failure occurred. Create a random object. Use
    // random.nextInt(10). If the
    // return value is greater than or equal to 6, then there is a hardware problem.
    // If it is less than 6, the hardware
    // is fine and you need do nothing further. If there is a hardware problem, do
    // the following:
    // a. Use random again (random.nextInt(4)). Use the return value plus 1 to
    // indicate the sensor number
    // of the bad sensor (1=airTemp, 2=groundTemp, 3=windspeed, 4=humidity). [Do you
    // see why you
    // need to use the returned random number + 1? (returned random value will be
    // 0-3)]
    // b. Set the urgent member to true.
    // c. Set the notes field to “!!! Hw failure: sensor: <sensor name>” (without
    // the quotes ””)
    // translating the number returned by the second random call into the matching
    // string (see ‘a’ above)
    // to replace <sensor name> in the string).
    public void checkHardware() {
        Random random = new Random();
        if (random.nextInt(10) >= 6) {
            int badSensor = random.nextInt(4) + 1;
            String badSensorName = "";
            switch (badSensor) {
            case 1:
                badSensorName = "airTemp";
                break;
            case 2:
                badSensorName = "groundTemp";
                break;
            case 3:
                badSensorName = "windSpeed";
                break;
            case 4:
                badSensorName = "humidity";
                break;
            }
            this.urgent = true;
            this.notes = "!!! Hw failure: sensor: " + badSensorName;
        }
    }

    // Add a public, non-static method called transmit. Again, we do not have a
    // ‘communication’ line to a data
    // collection server, so rather than sending the data over a network, we will
    // just print it on the console. Do the
    // following:
    // a. Print the line: Source: <name>
    // Where <name> is replaced by the name field in the object
    // b. Print the line: Date: <datestamp>
    // Where <datestamp> is the date field from the object.
    // c. Call serialize() and print a line: Data: <serializeOutput>
    // Where <serializeOutput> is the string returned from serialize()
    public void transmit() {
        System.out.println("Source: " + this.name);
        System.out.println("Date: " + this.date);
        System.out.println("Data: " + serialize());
    }

    // Add to the class DataMessage a non-static method named toString that takes no
    // parameter and
    // returns a string representation of the object. For the exact signature of the
    // method, refer to the
    // documentation for the toString method in java.lang.Object class. The toString
    // that you
    // added can simply use the serialize() method and return the String it
    // generates.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        // Change toString() to add “MsgId: “ plus the message id as well as
        // the Source: and Date: lines before the serialized data (as is done
        // in transmit().) So instead of just calling serialize(), it should build
        // a String with it's message id field, name field and date field. Then
        // add the string from serialize() to those items.
        sb.append("MsgId: ").append(this.messageID).append(newLine);
        sb.append("Source: ").append("\"").append(this.name).append("\"").append(newLine);
        sb.append("Date: ").append("\"").append(this.date).append("\"").append(newLine);
        sb.append(serialize());
        return sb.toString();
    }

    // Add an additional public dynamic method called transmit(). This
    // one will take one argument that is a target Mailbox. It should take
    // the actual Mailbox object, not a name (i.e., String)! This transmit()
    // routine will, instead of printing the message, call the Mailbox's
    // receive() method with a copy of 'this'. The result will be that the
    // Mailbox adds a copy of the DataMessage to its inbox.
    public void transmit(Mailbox mailbox) {
        try {
            mailbox.receive((DataMessage) this.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
