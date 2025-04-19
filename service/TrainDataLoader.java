package service;

import entity.Train;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TrainDataLoader {
    Map<String, Train> trainData;


    public TrainDataLoader() {
        trainData = new HashMap<>();

        // Train 1
        Map<String, LocalTime> route1 = new LinkedHashMap<>();
        route1.put("Delhi", LocalTime.of(10, 0));
        route1.put("Ghaziabad", LocalTime.of(11, 0));
        route1.put("Aligarh", LocalTime.of(12, 30));
        route1.put("Lucknow", LocalTime.of(17, 30));
        route1.put("Pratapgarh", LocalTime.of(19, 30));
        route1.put("Patna", LocalTime.of(20, 0));

        Train train1 = new Train("101", "Bullet Train", route1);
        trainData.put(train1.getTrainNumber(), train1);

        // Train 2
        Map<String, LocalTime> route2 = new HashMap<>();
        route2.put("Lahore", LocalTime.of(19, 0));
        route2.put("Kashmir", LocalTime.of(21, 0));
        route2.put("Delhi", LocalTime.of(0, 0));
        route2.put("Aligarh", LocalTime.of(1, 0));
        route2.put("Pratapgarh", LocalTime.of(12, 0));

        Train train2 = new Train("102", "Vande Bharat", route2);
        trainData.put(train2.getTrainNumber(), train2);
    }
    public Map<String, Train> getTrainData() {
        return trainData;
    }
}