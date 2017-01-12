package traintracks;

import train.Train;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristjan on 04/01/2017.
 */
public class TrainTrack {

    private static String TRACK_TYPE = "Regular train track";

    private List<Train> ridingTrains;
    private String name;
    private int numberOfTracks;

    public TrainTrack(String name, int numberOfTracks) {
        this.name = name;
        ridingTrains = new ArrayList<>();
        this.numberOfTracks = numberOfTracks;
    }

    public String getTrackInfo() {
        return TRACK_TYPE + " " + name + " with " + numberOfTracks + " tracks.";
    }

    public void addTrain(Train train) throws InterruptedException {
        synchronized (ridingTrains) {
            while (ridingTrains.size() >= numberOfTracks) {
                ridingTrains.wait();
            }
            ridingTrains.add(train);
        }
    }

    public void removeTrain(Train train) {
        synchronized (ridingTrains) {
            ridingTrains.remove(train);
            ridingTrains.notifyAll();
        }
    }

    public String getTrackType() {
        return TRACK_TYPE;
    }

}
