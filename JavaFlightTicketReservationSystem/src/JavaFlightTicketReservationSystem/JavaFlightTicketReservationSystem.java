package JavaFlightTicketReservationSystem;
import java.util.Scanner;
                            //******    OKTAY CAN SEVİMGİN - 221805001   ******
public class JavaFlightTicketReservationSystem{

    private static boolean[] availableSeats = new boolean[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        while (true) {
            System.out.println("Please type 1 for Buying First Class Ticket");
            System.out.println("Please type 2 for Buying Economy Class Ticket");
            System.out.println("Please type 3 for Ticket Validation");
            System.out.print("Choice: ");
            int userChoice = scanner.nextInt();
            
            switch (userChoice) {
                case 1:
                    if (isFlightFull()) {
                        System.out.println("The plane is fully booked.");
                    } else {
                        assignSeatToUser("First Class", 1, 5, scanner); 
                    }
                    break;

                case 2: 
                    if (isFlightFull()) {
                        System.out.println("The plane is fully booked.");
                    } else {
                        assignSeatToUser("Economy Class", 6, 10, scanner);
                    }
                    break;

                case 3: 
                    System.out.print("Enter seat ID which will be validated: ");
                    int seatNumber = scanner.nextInt();
                    checkTicketValidity(seatNumber);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
  
    public static boolean isFlightFull() {
        for (boolean seat : availableSeats) {
            if (!seat) {
                return false; 
            }
        }
        return true;
    }
    public static void checkTicketValidity(int seatNumber) {
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number.");
        } else if (availableSeats[seatNumber - 1]) {
            System.out.println("Ticket sold.");
        } else {
            System.out.println("Ticket not sold.");
        }
    }
    public static void assignSeatToUser(String section, int startIndex, int endIndex, Scanner scanner) {
        boolean seatAssigned = false;
        
        for (int i = startIndex - 1; i < endIndex; i++) {
            if (!availableSeats[i]) {
                availableSeats[i] = true;
                System.out.println(section + " Ticket is bought. Seat #" + (i + 1));
                seatAssigned = true;
                break;
            }
        }
        if (!seatAssigned) {
            if (section.equals("First Class")) {
                System.out.println("First Class is full. Do you prefer Economy Class ?");
            } else {
                System.out.println("Economy Class is full. Would you like to move to First Class?");
            }
            System.out.println("1. Yes, 2. No. Your choice: ");
            int userChoice = scanner.nextInt();
            
            if (userChoice == 1) {
                if (section.equals("First Class")) {
                    assignSeatToUser("Economy Class", 6, 10, scanner);
                } else {
                    assignSeatToUser("First Class", 1, 5, scanner); 
                }
            } else {
                System.out.println("The next flight will depart in 3 hours.");
            }
        }
    }
}
                           //******    OKTAY CAN SEVİMGİN - 221805001   ******

