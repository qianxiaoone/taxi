package entity;

import entity.Taxi;

import java.util.List;

public class Output {
    private List<Taxi> writeOffTaxi;
    private List<Taxi> distanceRelatedMaintenanceTaxi;
    private List<Taxi> timeRelatedMaintenanceTaxi;

    public Output(List<Taxi> writeOffTaxi, List<Taxi> distanceRelatedMaintenanceTaxi, List<Taxi> timeRelatedMaintenanceTaxi) {
        this.writeOffTaxi = writeOffTaxi;
        this.distanceRelatedMaintenanceTaxi = distanceRelatedMaintenanceTaxi;
        this.timeRelatedMaintenanceTaxi = timeRelatedMaintenanceTaxi;
    }

    public List<Taxi> getWriteOffTaxi() {
        return writeOffTaxi;
    }

    public void setWriteOffTaxi(List<Taxi> writeOffTaxi) {
        this.writeOffTaxi = writeOffTaxi;
    }

    public List<Taxi> getDistanceRelatedMaintenanceTaxi() {
        return distanceRelatedMaintenanceTaxi;
    }

    public void setDistanceRelatedMaintenanceTaxi(List<Taxi> distanceRelatedMaintenanceTaxi) {
        this.distanceRelatedMaintenanceTaxi = distanceRelatedMaintenanceTaxi;
    }

    public List<Taxi> getTimeRelatedMaintenanceTaxi() {
        return timeRelatedMaintenanceTaxi;
    }

    public void setTimeRelatedMaintenanceTaxi(List<Taxi> timeRelatedMaintenanceTaxi) {
        this.timeRelatedMaintenanceTaxi = timeRelatedMaintenanceTaxi;
    }
}
