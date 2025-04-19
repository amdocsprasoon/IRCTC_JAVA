package entity;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketNumber;
    private String passengerName;
    private String source;
    private String destination;
    private Train train;

    public Ticket(String passengerName, String source, String destination, Train train) {

        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.train = train;

    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
