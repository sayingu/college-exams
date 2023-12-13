
public class UseMailbox {

    public static void main(String[] args) {
       DataMessage msg1 = new DataMessage();
       DataMessage msg2;
       DataMessage dataMessages[] = new DataMessage[10];
       Mailbox boxes[] = new Mailbox[3];
       
       boxes[0] = new Mailbox("Seoul");
       boxes[1] = new Mailbox("Incheon");
       boxes[2] = new Mailbox("Busan");
       
       System.out.println("msg1 - Before sets: ");
 
       System.out.println("  Name: " + msg1.getName());
       System.out.println("  Date: " + msg1.getDate());
       System.out.println("  airTemp: " + msg1.getAirTemp());
       System.out.println("  groundTemp: " + msg1.getGroundTemp());
       System.out.println("  windSpeed: " + msg1.getWindSpeed());
       System.out.println("  humidity: " + msg1.getHumidity());
       System.out.println("  urgent: " + msg1.getUrgent());
       
       msg1.setAirTemp(22.2);
       msg1.setWindSpeed(25.5);
       msg1.setGroundTemp(28);
       msg1.setHumidity(10);
       msg1.setName("Manitoba_1_7");
       msg1.setDate("Fri, Nov 8, 2019 at 1128 PM");
       msg1.setUrgent(false);
 
       System.out.println("msg1 - After sets: ");
       
       System.out.println("  Name: " + msg1.getName());
       System.out.println("  Date: " + msg1.getDate());
       System.out.println("  airTemp: " + msg1.getAirTemp());
       System.out.println("  groundTemp: " + msg1.getGroundTemp());
       System.out.println("  windSpeed: " + msg1.getWindSpeed());
       System.out.println("  humidity: " + msg1.getHumidity());
       System.out.println("  urgent: " + msg1.getUrgent());
 
       msg2 = new DataMessage("Manitoba_1_8", "Sat, Nov 9, 2019 at 1128 PM", 
             18.8, 21.0, 14.0, 21);
       System.out.println("msg2:");
       System.out.println("  Name: " + msg2.getName());
       System.out.println("  Date: " + msg2.getDate());
       System.out.println("  airTemp: " + msg2.getAirTemp());
       System.out.println("  groundTemp: " + msg2.getGroundTemp());
       System.out.println("  windSpeed: " + msg2.getWindSpeed());
       System.out.println("  humidity: " + msg2.getHumidity());
       System.out.println("  urgent: " + msg2.getUrgent());
 
       
       System.out.println("msg1: " + msg1.serialize());
       System.out.println("msg2: " + msg2.serialize());
       
       dataMessages[0] = msg1;
       dataMessages[1] = msg2;
       dataMessages[2] = new DataMessage("Manitoba_1_8", "Sun, Nov 10, 2019 at 1128 PM", 
             19.8, 22.0, 24.0, 41);
       dataMessages[3] = new DataMessage("Manitoba_1_8", "Mon, Nov 11, 2019 at 1128 PM", 
             22.8, 32.0, 25.0, 51);
       dataMessages[4] = new DataMessage("Manitoba_1_8", "Tue, Nov 12, 2019 at 1128 PM", 
             21.8, 19.0, 24.0, 51);
       dataMessages[5] = new DataMessage("Manitoba_1_1", "Tue, Nov 12, 2019 at 1128 PM", 
             24.8, 21.0, 23.0, 51);
       dataMessages[6] = new DataMessage("Manitoba_1_7", "Tue, Nov 13, 2019 at 1128 PM", 
             23.8, 21.0, 2.0, 51);
       dataMessages[7] = new DataMessage("Manitoba_1_6", "Tue, Nov 14, 2019 at 1128 PM", 
             24.6, 21.0, 22.5, 51);
       dataMessages[8] = new DataMessage("Manitoba_1_5", "Tue, Nov 15, 2019 at 1128 PM", 
             24.4, 21.0, 23.0, 51);
       dataMessages[9] = new DataMessage("Manitoba_1_0", "Tue, Nov 16, 2019 at 1128 PM", 
             24.3, 21.0, 24.0, 52);
       
       for (int i = 0; i < dataMessages.length; i++) {
          dataMessages[i].checkHardware();
       }
       System.out.println();
       System.out.println();
       System.out.println("All:");
       // Send all messages to Busan
       for (int i = 0; i < dataMessages.length; i++) {
          dataMessages[i].transmit(boxes[2]);
          System.out.println("DataMessage delivered to: " + boxes[2].toString());
          System.out.println();
       }
       System.out.println();
       System.out.println();
       System.out.println("Urgent!");
       // Send urgent messages to Seoul
       for (int i = 0; i < dataMessages.length; i++) {
          if (dataMessages[i].getUrgent()) {
             dataMessages[i].transmit(boxes[0]);
             System.out.println("DataMessage delivered to: " + boxes[0].toString());
             System.out.println();
          }
       }
       
       for (int i = 0; i < 20; i++) {
          if (boxes[0].delete(i)) {
             break;
          }
       }
       
       System.out.println("Busan Inbox: ");
       boxes[2].dumpInbox();
       System.out.println();
       
       for (int i = 0; i < 20; i++) {
          if (boxes[2].delete(i)) {
             System.out.println("DEB: deleted: " + i);
             break;
          }
       }
       System.out.println("Busan Inbox: ");
       boxes[2].dumpInbox();
       System.out.println();
       
       System.out.println("Look for some message ids");
       
       System.out.println("Seoul, msgid=5: " + boxes[0].searchMailbox(5));
       System.out.println("Incheon, msgid=1: " + boxes[1].searchMailbox(1));
       System.out.println("Busan, msgid=1: " + boxes[2].searchMailbox(1));
       System.out.println("Seoul, msgid=3: " + boxes[0].searchMailbox(3));
       System.out.println("Incheon, msgid=2: " + boxes[1].searchMailbox(2));
       System.out.println("Busan, msgid=8: " + boxes[2].searchMailbox(8));
       
       System.out.println();
       
       System.out.println("Seoul Inbox: ");
       boxes[0].dumpInbox();
       System.out.println();
       
       System.out.println("Incheon Inbox: ");
       boxes[1].dumpInbox();
       System.out.println();
       
       System.out.println("Busan Inbox: ");
       boxes[2].dumpInbox();
       System.out.println();
       
       System.out.println("Seoul Delbox: ");
       boxes[0].dumpDelbox();
       System.out.println();
       
       System.out.println("Incheon Delbox: ");
       boxes[1].dumpDelbox();
       System.out.println();
       
       System.out.println("Busan Delbox: ");
       boxes[2].dumpDelbox();
       System.out.println();
       
    
    }
 
 }