package map;

import trainstations.TrainStation;
import traintracks.TrainTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristjan on 03/01/2017.
 */
public class Schedule {

    private List<TrainStation> trainStations = new ArrayList<>();
    private int[] rideTimes;
    private List<TrainTrack> trainTracks = new ArrayList<>();

    // rideTimes should be some objects instead of plain primitive ride times
    public Schedule(List<TrainStation> trainStations, List<TrainTrack> trainTracks, int... rideTimes) {
        this.trainStations = trainStations;
        this.trainTracks = trainTracks;
        this.rideTimes = rideTimes;
    }

    public TrainStation getGivenTrainStation(TrainTrack currentTrack, int whichStation) {
        return trainStations.get(trainTracks.indexOf(currentTrack) + whichStation);
    }

    public TrainTrack getNextTrainTrack(TrainStation currentStation) {
        return trainTracks.get(trainStations.indexOf(currentStation));
    }

    public int getNextRideTime(TrainStation currentStation) {
        return rideTimes[trainStations.indexOf(currentStation)];
    }

    public List<TrainStation> getTrainStations() {
        return trainStations;
    }

    public int[] getRideTimes() {
        return rideTimes;
    }
}
