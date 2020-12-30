package entity;

import entity.Taxi;

import java.util.List;

/**
 * @author wang-hc
 */
public class OutputParam {
    private List<Taxi> writeOffTaxi;
    private List<Taxi> distanceRelatedMaintenanceTaxi;
    private List<Taxi> timeRelatedMaintenanceTaxi;

    public OutputParam(List<Taxi> writeOffTaxi, List<Taxi> distanceRelatedMaintenanceTaxi, List<Taxi> timeRelatedMaintenanceTaxi) {
        this.writeOffTaxi = writeOffTaxi;
        this.distanceRelatedMaintenanceTaxi = distanceRelatedMaintenanceTaxi;
        this.timeRelatedMaintenanceTaxi = timeRelatedMaintenanceTaxi;
    }

    public List<Taxi> getWriteOffTaxi() {
        return writeOffTaxi;
    }

    public List<Taxi> getDistanceRelatedMaintenanceTaxi() {
        return distanceRelatedMaintenanceTaxi;
    }

    public List<Taxi> getTimeRelatedMaintenanceTaxi() {
        return timeRelatedMaintenanceTaxi;
    }

}
