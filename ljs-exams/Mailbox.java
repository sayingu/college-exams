import java.util.Arrays;
import java.util.Comparator;

public class Mailbox {
    private String name;
    private DataMessage[] inbox;
    private DataMessage[] delbox;

    public Mailbox(String name) {
        this.name = name;
        this.inbox = new DataMessage[10];
        this.delbox = new DataMessage[10];
    }

    public String toString() {
        return this.name;
    }

    // A data message arrives at a mail box when the receive() method is called on
    // the mail
    // box object. The receive method takes a DataMessage object as an argument.
    // When a
    // data message is received, check the value of the message id with the data
    // message's
    // getter method. If it is less than 0, you will set the MessageID field with
    // the data
    // message's setter method. Important note! We check this first since data
    // messages
    // may be submitted to more than 1 mailbox. We do not want to overwrite a
    // previously assigned message id! The ID you assign must be unique so the next
    // available ID in a mailbox should be tracked with a private static integer
    // field (this makes
    // the number unique across ALL mailboxes. Do you understand why?). After
    // assigning a
    // message id, the data message goes automatically into the inbox of the mail
    // box object.
    // The data messages in the inbox are maintained in the order of message ids.
    // The data
    // message with the smallest id number must be located in the index 0 of the
    // inbox array.
    // The data message with the largest id number toward the other end of the
    // array. There
    // must not be any holes between data messages in the array. All the empty slots
    // will be to
    // the right of the data message with the largest id number so far
    public void receive(DataMessage dataMessage) {
        int maxMessageID = 1;
        for (int i = 0; i < this.inbox.length; i++) {
            if (this.inbox[i] != null && this.inbox[i].getMessageID() >= maxMessageID) {
                maxMessageID = this.inbox[i].getMessageID() + 1;
            }
        }

        for (int i = 0; i < this.inbox.length; i++) {
            if (this.inbox[i] == null) {
                dataMessage.setMessageID(maxMessageID);
                this.inbox[i] = dataMessage;
                break;
            }
        }
        this.inbox = sort(this.inbox);
    }

    // A message gets deleted from a mail box object when the delete() method is
    // called on the
    // mail box object with a message id as an argument. If the message is not in
    // the inbox of
    // the mail box object, it just prints out a warning: ”Message not in inbox”. If
    // it is indeed in
    // the inbox, the message is moved to the delbox of the same mail box object.
    // When a
    // message is deleted from the inbox, the hole that gets created must be filled
    // in.
    public boolean delete(int messageID) {
        boolean deleted = false;
        for (int i = 0; i < this.inbox.length; i++) {
            if (this.inbox[i] != null && this.inbox[i].getMessageID() == messageID) {
                for (int j = 0; j < this.delbox.length; j++) {
                    if (this.delbox[j] == null) {
                        this.delbox[j] = this.inbox[i];
                        break;
                    }
                }
                this.delbox = sort(this.delbox);
                this.inbox[i] = null;
                deleted = true;
                break;
            }
        }
        this.inbox = sort(this.inbox);
        if (!deleted) {
            System.out.println("Message not in inbox!");
        }
        return deleted;
    }

    // Given a data message, a mail box object should be able to answer if the
    // message is in the
    // mail box or not. To do this the Mailbox class supports a method named
    // searchMessage()
    // that takes a message id as its argument. The return value is an integer and
    // will be one of
    // the following three: (1) ”inbox”, (2) ”delbox”, or (3) ”neither” with their
    // obvious
    // meanings.
    public int searchMailbox(int messageID) {
        int result = 3;
        for (int i = 0; i < this.inbox.length; i++) {
            if (this.inbox[i] != null && this.inbox[i].getMessageID() == messageID) {
                result = 1;
                break;
            }
        }
        if (result == 3) {
            for (int i = 0; i < this.delbox.length; i++) {
                if (this.delbox[i] != null && this.delbox[i].getMessageID() == messageID) {
                    result = 2;
                    break;
                }
            }
        }
        return result;
    }

    // A method called dumpInbox() that takes no arguments and returns void. It will
    // print
    // each of the DataMessages in the inbox using System.out.println on the
    // DataMessage. This will cause DataMessage's toString() method to print out the
    // contents of the DataMessage.
    public void dumpInbox() {
        for (DataMessage dataMessage : inbox) {
            if (dataMessage != null) {
                System.out.println();
                System.out.println(dataMessage.toString());
            }
        }
    }

    // A method called dumpDelbox() which will dump the DataMessages in the deleted
    // box in the same manner as dumpInbox() does for the inbox.
    public void dumpDelbox() {
        for (DataMessage dataMessage : delbox) {
            if (dataMessage != null) {
                System.out.println();
                System.out.println(dataMessage.toString());
            }
        }
    }

    private static DataMessage[] sort(DataMessage[] box) {
        Arrays.sort(box, Comparator.nullsLast(Comparator.comparingInt(DataMessage::getMessageID)));
        return box;
    }
}
