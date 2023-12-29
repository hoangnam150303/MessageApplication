
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Message[] systems = new Message[10];
        systems[1] = new Message();
        systems[2] = new Message();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            try {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                choice = input.nextInt();
                if (choice == 1) {
                    System.out.println("Enter ID: ");
                    int id = input.nextInt();
                    if (id >= 1 && id <= 5) {
                        do {
                            systems[id].menu();
                            System.out.println("Your choice: ");
                            choice = input.nextInt();
                            switch (choice) {
                                case 1:
                                    systems[id].subMenu();
                                    choice = input.nextInt();
                                    if (choice == 1) {
                                        System.out.println("Enter Id you want to send request: ");
                                        int idRequest = input.nextInt();
                                        systems[id].sendRequest(systems[idRequest]);
                                        systems[id].online();
                                    } else if (choice == 2) {
                                        systems[id].disconnect();
                                    } else {
                                        throw new Exception("Wrong choice");
                                    }
                                    break;
                                case 2:
                                    systems[id].sendMessage();
                                    break;
                                case 3:
                                    systems[id].receiveMessage();
                                    break;
                                case 4:
                                    systems[id].pushMessageIntoStack();
                                    systems[id].displayAllMessages();
                                    break;
                                case 5:
                                    System.out.println("Good bye!");
                                    break;
                                default:
                                    System.out.println("Wrong choice!");
                                    break;
                            }
                        } while (choice != 5);
                    } else {
                        throw new Exception("Invalid ID!");
                    }
                } else if (choice == 2) {
                    System.out.println("Goodbye!");
                } else {
                    throw new Exception("Wrong input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 2);
    }
}
