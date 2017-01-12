import map.Schedule;
import map.Storage;
import train.DieselTrain;
import train.ElectricTrain;
import trainstations.TrainStation;
import traintracks.TrainTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kristjan on 03/01/2017.
 */
public class ControlStation {
    public static void main(String[] args) {

        Storage storage = new Storage();
        storage.addStation(new TrainStation("Tallinn"));
        storage.addStation(new TrainStation("Pärnu"));
        storage.addStation(new TrainStation("Rapla"));

        storage.addTrack(new TrainTrack("Tallinn-Pärnu", 2));
        storage.addTrack(new TrainTrack("Pärnu-Rapla", 1));

        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(storage, new int[]{0, 1}, 3));
        schedules.add(new Schedule(storage, new int[]{0, 1, 2}, 1, 2));

        List<DieselTrain> trains = new ArrayList<>();
        trains.add(new DieselTrain("Train1",schedules.get(0), 6));
        trains.add(new DieselTrain("Train2", schedules.get(1), 6));

        List<Thread> trainThreads = new ArrayList<>();
        trainThreads.add(new Thread(trains.get(0)));
        trainThreads.add(new Thread(trains.get(1)));

        trainThreads.stream().forEach(s -> s.start());

    }

}
