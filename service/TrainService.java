package service;

import entity.Train;

import java.util.List;
import java.util.stream.Collectors;

public class TrainService {

    public List<Train> searchTrains(String source, String destination, TrainDataLoader trainDataLoader) {
        // Logic to search for trains based on source, destination
        // This will involve checking the train data loaded from TrainDataLoader

        // For each train in the trainDataLoader, check if the source and destination are in the route
        // If they are, add the train to a list of available trains
        // Return the list of available trains
        // This is a placeholder for the actual implementation.

        List<Train> availaibleTrains = trainDataLoader.getTrainData()
                .values()
                .stream()
                .filter(train -> train.getRoute().containsKey(source) && train.getRoute().containsKey(destination))
                .collect(Collectors.toList());

        return availaibleTrains;



        // and returning a list of available trains.
        // For now, we will return an empty list.

    }
}
