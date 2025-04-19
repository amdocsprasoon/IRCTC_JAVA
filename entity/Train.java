package entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;


public class Train {
    private String trainNumber;
    private String trainName;
    private Map<String, LocalTime> route; // Map of source to destination, arrival time is the first entry and destination time is the last entry

    public Train(String trainNumber, String trainName, Map<String,LocalTime> route) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.route = route;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Map<String, LocalTime> getRoute() {
        return route;
    }

    public void setRoute(Map<String, LocalTime> route) {
        this.route = route;
    }
}
