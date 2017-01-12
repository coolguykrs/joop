package train;

import passengers.Passenger;

import java.util.ArrayList;

/**
 * Created by Kristjan on 03/01/2017.
 */
public interface Train {

    int maxAmountOfPassengers();
    String getTrainType();
    void startTrainRide() throws InterruptedException;

    void addPassengers(ArrayList<Passenger> passengers);
    int getNumberOfPassengers();
    void removeAllPassengers();
    void removeNecessaryPassenger();

}
