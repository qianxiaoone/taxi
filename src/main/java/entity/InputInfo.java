package entity;

import java.util.List;

/**
 * @author wang-hc
 */
public class InputInfo {
    private List<Taxi> checkTaxis;

    public InputInfo(List<Taxi> checkTaxis) {
        this.checkTaxis = checkTaxis;
    }

    public List<Taxi> getCheckTaxis() {
        return checkTaxis;
    }

}
