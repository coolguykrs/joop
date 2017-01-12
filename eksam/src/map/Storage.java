package map;

import trainstations.TrainStation;
import traintracks.TrainTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristjan on 12/01/2017.
 */
public class Storage {

    List<TrainStation> stations = new ArrayList<>();
    List<TrainTrack> tracks = new ArrayList<>();

    public Storage() {

    }

    public void addStation(TrainStation trainStation) {
        stations.add(trainStation);
    }

    public void addTrack(TrainTrack trainTrack) {
        tracks.add(trainTrack);
    }

    public List<TrainStation> getTrainStations() {
        return stations;
    }

    public List<TrainTrack> getTrainTracks() {
        return tracks;
    }

}
