package train;

import map.Schedule;

/**
 * Created by Kristjan on 03/01/2017.
 */
public class ElectricTrain extends DieselTrain {

    private static final String TRAIN_TYPE = "Electric train";

    public ElectricTrain(String name, Schedule schedule, int amountOfTrips) {
        super(name, schedule, amountOfTrips);
    }

    @Override
    public String getTrainType() {
        return TRAIN_TYPE;
    }
}
