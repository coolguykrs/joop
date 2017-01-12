package train;

import map.Schedule;
import passengers.Passenger;
import trainstations.TrainStation;
import traintracks.TrainTrack;

import java.util.ArrayList;

/**
 * Created by Kristjan on 03/01/2017.
 */
public class DieselTrain implements Train, Runnable {

    private static final String TRAIN_TYPE = "Diesel train";

    private Schedule schedule;
    private int amountOfTrips;
    private String name;

    public DieselTrain(String name, Schedule schedule, int amountOfTrips) {
        this.name = name;
        this.schedule = schedule;
        this.amountOfTrips = amountOfTrips;
    }

    @Override
    public int maxAmountOfPassengers() {
        return 0;
    }

    @Override
    public String getTrainType() {
        return TRAIN_TYPE;
    }

    private void moveTrainToNextStation(int i, int whichStation) throws InterruptedException {
        TrainTrack nextTrack = schedule.getNextTrainTrack(schedule.getTrainStations().get(i));
        nextTrack.addTrain(this);
        Thread.sleep(schedule.getRideTimes()[i] * 1000);
        nextTrack.removeTrain(this);
        TrainStation nextStation = schedule.getGivenTrainStation(nextTrack, whichStation);
        nextStation.addTrain(this);
        System.out.println(name + " arrived at " + nextStation.getName());
    }

    @Override
    public void startTrainRide() throws InterruptedException {
        for (int j = 0; j < amountOfTrips; j++) {
            for (int i = 0; i < schedule.getTrainStations().size() - 1; i++) {
                moveTrainToNextStation(i, 1);
            }
            for (int i = schedule.getTrainStations().size() - 2; i > -1 ; i--) {
                moveTrainToNextStation(i, 0);
            }
        }
    }

    @Override
    public void addPassengers(ArrayList<Passenger> passengers) {

    }

    @Override
    public int getNumberOfPassengers() {
        return 0;
    }

    @Override
    public void removeAllPassengers() {

    }

    @Override
    public void removeNecessaryPassenger() {

    }

    @Override
    public void run() {
        try {
            startTrainRide();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
