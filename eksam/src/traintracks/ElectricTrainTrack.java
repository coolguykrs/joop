package traintracks;

/**
 * Created by Kristjan on 12/01/2017.
 */
public class ElectricTrainTrack extends TrainTrack {

    private static String TRACK_TYPE = "Electric train track";

    public ElectricTrainTrack(String name, int numberOfTracks) {
        super(name, numberOfTracks);
    }

    @Override
    public String getTrackType() {
        return TRACK_TYPE;
    }
}
