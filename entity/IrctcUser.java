package entity;

import java.util.ArrayList;
import java.util.List;

public class IrctcUser {

    private Long userId;
    private String username;
    private String password;
    private List<Ticket> bookedTickets;


    public IrctcUser(Long userId, String username, String password) {
        this.bookedTickets = new ArrayList<>();
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }
}
