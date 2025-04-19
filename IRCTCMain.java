import entity.IrctcUser;
import entity.Train;
import service.AuthService;
import service.TrainDataLoader;
import service.UserBookingService;

import java.util.Map;
import java.util.Scanner;

public class IRCTCMain {

    public static void main(String[] args) {
        System.out.println("Welcome to IRCTC V1");
        AuthService authService = new AuthService();
        TrainDataLoader trainDataLoader = new TrainDataLoader();


        // Example: Print train details
        trainDataLoader.getTrainData().forEach((trainNumber, train) -> {
            System.out.println("Train Number: " + trainNumber);
            System.out.println("Train Name: " + train.getTrainName());
            System.out.println("Route: " + train.getRoute());
        });

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    authService.signup(scanner);
                    break;
                case 2:
                    IrctcUser user = authService.login(scanner);
                    if (user!=null) {
                        showPostLoginMenu(scanner, trainDataLoader,user);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showPostLoginMenu(Scanner scanner, TrainDataLoader trainDataLoader, IrctcUser irctcUser) {

        while (true) {
            System.out.println("\nPost-Login Menu:");
            System.out.println("1. View Booked Tickets");
            System.out.println("2. Book Ticket");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("View Booked Tickets");
                    UserBookingService.viewBookedTickets(irctcUser);
                    break;
                case 2:
                    System.out.println("Please Book a ticket");

                    if(UserBookingService.bookTicket(scanner, irctcUser, trainDataLoader)!=null)
                    {
                        System.out.println("Ticket booked successfully!");
                        while (true){
                            System.out.println("Press any key to continue");
                            String input = scanner.nextLine();
                            if (input != null) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please try again.");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Ticket booking failed.");
                    }

                    break;
                case 3:
                    System.out.println("Logging out...");
                    return; // Exit the post-login menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
