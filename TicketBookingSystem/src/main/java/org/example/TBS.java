import java.util.Scanner;

// TRAIN CLASS
class Train {

    int trainId;
    String trainName;
    String source;
    String destination;
    int totalSeats;
    int availableSeats;

    static int idCounter = 1;

    Train(String trainName, String source, String destination, int totalSeats) {
        this.trainId = idCounter++;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;

    }
}


// TICKET CLASS
class Ticket {

    int ticketId;
    Train train;
    String passengerName;
    int seatsBooked;

    static int idCounter = 1001; // 1001 theke id count suru hobe
    Ticket(Train train, String passengerName, int seatsBooked) {
        this.ticketId = idCounter++;
        this.train = train;
        this.passengerName = passengerName;
        this.seatsBooked = seatsBooked;

    }
}


// MAIN CLASS
public class TBS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Train[] trains = new Train[5];
        Ticket[] tickets = new Ticket[20];

        int trainCount = 0;
        int ticketCount = 0;
        int choice;

        do {
            System.out.println("\n======== TICKET BOOKING SYSTEM ========");
            System.out.println("1. Add Train");
            System.out.println("2. View Trains");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. View Bookings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                // ADD TRAIN
                case 1:
                    if (trainCount >= trains.length) {
                        System.out.println("Train limit reached!");
                        break;
                    }

                    input.nextLine();
                    System.out.print("Enter Train Name: ");
                    String trainName = input.nextLine();

                    System.out.print("Enter Source: ");
                    String source = input.nextLine();

                    System.out.print("Enter Destination: ");
                    String destination = input.nextLine();

                    System.out.print("Enter Total Seats: ");
                    int totalSeats = input.nextInt();

                    if (totalSeats <= 0) {
                        System.out.println("Total seats must be greater than 0!");
                        break;
                    }

                    trains[trainCount++] = new Train(trainName, source, destination, totalSeats);
                    System.out.println("Train added successfully!");
                    break;


                // VIEW TRAINS
                case 2:
                    System.out.println("\n========== TRAINS LIST ==========");
                    if (trainCount == 0) {
                        System.out.println("No trains available!");
                        break;
                    }

                    for (int i = 0; i < trainCount; i++) {
                        Train train = trains[i];
                        System.out.println(
                                "Train ID: " + train.trainId +
                                        " | Name: " + train.trainName +
                                        " | Source: " + train.source +
                                        " | Destination: " + train.destination +
                                        " | Total Seats: " + train.totalSeats +
                                        " | Available Seats: " + train.availableSeats

                        );
                    }
                    break;


                // BOOK TICKET
                case 3:
                    if (trainCount == 0) {
                        System.out.println("No trains available!");
                        break;
                    }

                    if (ticketCount >= tickets.length) {
                        System.out.println("Ticket booking limit reached!");
                        break;
                    }

                    System.out.println("\n========== BOOK TICKET ==========");
                    System.out.print("Enter Train ID: ");
                    int trainId = input.nextInt();

                    Train selectedTrain = null;
                    // Find train
                    for (int i = 0; i < trainCount; i++) {
                        if (trains[i].trainId == trainId) {
                            selectedTrain = trains[i];
                            break;

                        }
                    }

                    // Train not found
                    if (selectedTrain == null) {
                        System.out.println("Train not found!");
                        break;

                    }

                    input.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String passengerName = input.nextLine();

                    System.out.print("Enter Seats to Book: ");
                    int seatsBooked = input.nextInt();

                    if (seatsBooked <= 0) {
                        System.out.println("Seats must be greater than 0!");
                        break;

                    }


                    // Check available seats
                    if (selectedTrain.availableSeats >= seatsBooked) {
                        selectedTrain.availableSeats -= seatsBooked;
                        tickets[ticketCount++] = new Ticket(selectedTrain, passengerName, seatsBooked);
                        System.out.println("Ticket booked successfully!");

                        System.out.println("Your Ticket ID: " + tickets[ticketCount - 1].ticketId);

                    }
                    else {
                        System.out.println("No available seats!");
                    }
                    break;


                // CANCEL TICKET
                case 4:
                    if (ticketCount == 0) {
                        System.out.println("No bookings available!");
                        break;
                    }

                    System.out.println("\n========== CANCEL TICKET ==========");
                    System.out.print("Enter Ticket ID: ");
                    int tId = input.nextInt();

                    boolean ticketFound = false;
                    for (int i = 0; i < ticketCount; i++) {
                        if (tickets[i].ticketId == tId) {
                            // Return booked seats
                            tickets[i].train.availableSeats += tickets[i].seatsBooked;
                            System.out.println("Ticket canceled successfully!");

                            // Remove ticket from array
                            tickets[i] = tickets[ticketCount - 1];
                            tickets[ticketCount - 1] = null;
                            ticketCount--;
                            ticketFound = true;
                            break;

                        }
                    }
                    if (!ticketFound) {
                        System.out.println("Ticket not found!");
                    }
                    break;


                // 5. VIEW BOOKINGS
                case 5:
                    System.out.println("\n========== VIEW BOOKINGS ==========");
                    if (ticketCount == 0) {
                        System.out.println("No bookings available!");
                        break;
                    }
                    for (int i = 0; i < ticketCount; i++) {
                        Ticket ticket = tickets[i];
                        System.out.println(
                                "Ticket ID: " + ticket.ticketId +
                                        " | Passenger Name: " + ticket.passengerName +
                                        " | Train Name: " + ticket.train.trainName +
                                        " | Source: " + ticket.train.source +
                                        " | Destination: " + ticket.train.destination +
                                        " | Seats Booked: " + ticket.seatsBooked


                        );
                    }
                    break;

                // 6. EXIT
                case 6:
                    System.out.println("Exiting Ticket Booking System...");
                    break;


                // INVALID CHOICE
                default:
                    System.out.println("Invalid user choice!");
            }

        } while (choice != 6);

        input.close();






    }
}