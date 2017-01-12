package trainstations;

import passengers.Passenger;
import train.Train;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristjan on 04/01/2017.
 */
public class TrainStation {

    private String name;
    private List<Passenger> passengers = new ArrayList<>();
    private List<Train> trains = new ArrayList<>();


    public TrainStation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void addTrain(Train train) {
        trains.add(train);
    }



}
