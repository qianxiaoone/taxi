package entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InputInfo {
    private Calendar checkDate;
    private List<Taxi> checkTaxis;

    public InputInfo(Calendar checkDate, List<Taxi> checkTaxis) {
        this.checkDate = checkDate;
        this.checkTaxis = checkTaxis;
    }

    public Calendar getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Calendar checkDate) {
        this.checkDate = checkDate;
    }

    public List<Taxi> getCheckTaxis() {
        return checkTaxis;
    }

    public void setCheckTaxis(List<Taxi> checkTaxis) {
        this.checkTaxis = checkTaxis;
    }
}
