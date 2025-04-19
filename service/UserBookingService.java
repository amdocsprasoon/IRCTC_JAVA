package service;

import entity.IrctcUser;
import entity.Ticket;
import entity.Train;

import java.util.List;
import java.util.Scanner;

public class UserBookingService {

    public static Ticket bookTicket(Scanner scanner, IrctcUser user, TrainDataLoader trainDataLoader) {
        // Logic to book a ticket for the user
        // This will involve checking if the user is logged in and if the train is available
        // If both are true, create a new Ticket object and add it to the user's booked tickets
        // This is a placeholder for the actual implementation.




            System.out.print("Enter source station: ");
            String source = scanner.nextLine();
            System.out.print("Enter destination station: ");
            String destination = scanner.nextLine();

            List<Train> trainList = TrainService.searchTrains(source, destination, trainDataLoader);
            System.out.println("Available Trains:");
            trainList.forEach(train -> {
                System.out.println("Train Number: " + train.getTrainNumber());
                System.out.println("Train Name: " + train.getTrainName());
                System.out.println("Route: " + train.getRoute());
                System.out.println("-------------------------------------------------");
            });
            if (trainList.isEmpty()) {
                System.out.println("No trains available for the selected route.");
                return null;
            }
            Train train = null;
            while (true) {

                System.out.print("Enter the train number you want to book: ");
                String trainNumber = scanner.nextLine();

                train = trainList.stream()
                        .filter(t -> t.getTrainNumber().equals(trainNumber))
                        .findFirst()
                        .orElse(null);
                if (train == null) {
                    System.out.println("Invalid train number. Please try again.");
                } else
                    break;
            }
            Ticket ticket = new Ticket(user.getUsername(), source, destination,train);

            user.getBookedTickets().add(ticket);
            return ticket;





    }
    public static void viewBookedTickets(IrctcUser user) {
        // Logic to view booked tickets for the user
        // This will involve checking if the user is logged in and if they have any booked tickets
        // If they do, display the booked tickets
        // This is a placeholder for the actual implementation.

        if (user.getBookedTickets().isEmpty()) {
            System.out.println("No booked tickets found.");
        } else {
            System.out.println("Booked Tickets:");
            user.getBookedTickets().forEach(ticket -> {
                System.out.println("Ticket ID: " + ticket.getTicketNumber());
                System.out.println("Source: " + ticket.getSource());
                System.out.println("Destination: " + ticket.getDestination());
                System.out.println("Train Number: " + ticket.getTrain().getTrainNumber());
                System.out.println("Train Name: " + ticket.getTrain().getTrainName());
                System.out.println("-------------------------------------------------");
            });
        }
    }
}
