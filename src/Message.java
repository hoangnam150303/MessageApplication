

import java.util.Scanner;
public class Message {
    private Stack<String> processingStack = new Stack<>();
    private Queue<String> transportQueue = new Queue<>();
    private Message connectedSystem;
    private boolean checkOnline = false;
    private Scanner input = new Scanner(System.in);

    private void connect(Message other) {
        connectedSystem = other;
    }

    public boolean isOnline() {
        return connectedSystem.checkOnline;
    }
    private long startTime() {
        return System.nanoTime();
    }

    private void endTime(long start) {
        long end = System.nanoTime();
        double excute = end - start;
        System.out.println("Execution time: " + excute + " ns");
    }
    public void online() {
            if (checkOnline==true&&isOnline()==true){
                System.out.println("You are connected");
            }
            else {
                System.out.println("Don't have any request to connect with you!");
            }
    }
    public void sendRequest(Message other)  {
        long start = startTime();
            try {
                System.out.println("Do you want to send the request? (yes/no)");
                String choice = input.next().toLowerCase();
                if ("yes".equals(choice)) {

                    connect(other);
                    checkOnline = true;

                }else if ("no".equals(choice)){
                    System.out.println("You don't send request to another system");
                }else{
                    throw new Exception("Wrong input!");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        endTime(start);
    }

    public void disconnect(){
        long start = startTime();
            try {
                System.out.println("Do you want to disconnect? (yes/no)");
                String choice = input.next().toLowerCase();
                if ("yes".equals(choice)) {

                    connect(null);
                    checkOnline=false;

                } else if ("no".equals(choice)) {
                    System.out.println("You don't disconnect to another system");
                }else{
                    throw new Exception("Wrong input");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        endTime(start);
    }
    private String[] splitMessage(String message) {
        int maxLength = 250;
        int length = message.length();
        int numParts = (int) Math.ceil((double) length / maxLength);
        String[] parts = new String[numParts];
        for (int i = 0; i < numParts; i++) {
            int start = i * maxLength;
            int end = Math.min((i + 1) * maxLength, length);
            parts[i] = message.substring(start, end);
        }
        return parts;
    }

    private void writeMessage()  {
        try {
            input.nextLine();
            System.out.println("Enter the message (250 characters)");
            String writeMessage = input.nextLine();
            if (writeMessage.length() > 250) {

                String[] parts = splitMessage(writeMessage);
                for (String part : parts) {
                    transportQueue.enQueue(part);
                }
                throw new Exception("The message is too long, is splitting now...");

            }else if (writeMessage.length()==0){
                throw new Exception("Wrong message!");
            }
                transportQueue.enQueue(writeMessage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sendMessage() {
        long start = startTime();
            try {
                if (checkOnline==true&&connectedSystem.checkOnline==true) {

                    writeMessage();

                }else {
                    throw new Exception("Another system does not online!");
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        endTime(start);
    }
    public void receiveMessage()  {
        long start = startTime();
            try {
                if (!connectedSystem.transportQueue.isEmpty()) {
                    System.out.println("You have messages!");

                    while (!connectedSystem.transportQueue.isEmpty()) {
                        String receiveMessage = connectedSystem.transportQueue.dequeue();
                        transportQueue.enQueue(receiveMessage);
                    }
                } else {
                    throw new Exception("You don't have any message!");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        endTime(start);
    }

    public void pushMessageIntoStack()  {
        long start = startTime();
           try {
               if (!transportQueue.isEmpty()) {

                   while (!transportQueue.isEmpty()) {
                       String stackMessage = transportQueue.dequeue();
                       processingStack.push(stackMessage);
                   }
               }else {
                   throw new Exception("You don't have any message!");
               }
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
        endTime(start);
    }
    public void displayAllMessages() {
        long start = startTime();
            try {
                if (processingStack.isEmpty()) {
                    throw new Exception("No have any message to display!");
                } else {

                    processingStack.displayAllNode();

                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        endTime(start);
    }
    public void menu() {
        try {
            System.out.println("Main menu System");
            System.out.println("1. Send request or Disconnect.");
            System.out.println("2. Send message");
            System.out.println("3. Check message.");
            System.out.println("4. Display all messages.");
            System.out.println("5. Exit");
        } catch (Exception e) {
            System.out.println("Error in menu method: " + e.getMessage());
        }
    }

    public void subMenu() {
        try {
            System.out.println("Sub menu system");
            System.out.println("1. Send request");
            System.out.println("2. Disconnect");
        } catch (Exception e) {
            System.out.println("Error in subMenu method: " + e.getMessage());
        }
    }
}