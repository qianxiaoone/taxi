package Service;

import entity.InputInfo;
import entity.Taxi;
import entity.OutputParam;

import java.util.*;

/**
 * @author wang-hc
 */
public class ReminderCars {
    private InputInfo inputInfo;

    public ReminderCars(InputInfo inputInfo) {
        this.inputInfo = inputInfo;
    }

    public OutputParam getAllTypeCarsList() {
        List<Taxi> writeOffTaxi = new ArrayList<>();
        List<Taxi> distanceRelatedMaintenanceTaxi = new ArrayList<>();
        List<Taxi> timeRelatedMaintenanceTaxi = new ArrayList<>();
        Taxi t;
        for (Taxi taxi : inputInfo.getCheckTaxis()) {
            if (!isValid(taxi)) {
                continue;
            }
            t = getWriteOffCar(taxi);
            if (t != null) {
                writeOffTaxi.add(t);
                continue;
            }
            t = getDistanceRelatedMaintenanceCar(taxi);
            if (t != null) {
                distanceRelatedMaintenanceTaxi.add(t);
                continue;
            }
            t = getTimeRelatedMaintenanceCar(taxi);
            if (t != null) {
                timeRelatedMaintenanceTaxi.add(t);
            }
        }
        Collections.sort(writeOffTaxi);
        Collections.sort(distanceRelatedMaintenanceTaxi);
        Collections.sort(timeRelatedMaintenanceTaxi);
        return new OutputParam(writeOffTaxi, distanceRelatedMaintenanceTaxi, timeRelatedMaintenanceTaxi);

    }

    boolean isValid(Taxi taxi) {
        int writeOffDay = 6 * 365;
        if (taxi.isRepair()) {
            writeOffDay = writeOffDay / 2;
        }
        Calendar writeOffCalendar = (Calendar) taxi.getBuyTime().clone();
        writeOffCalendar.add(Calendar.DAY_OF_YEAR, writeOffDay);
//        if (writeOffCalendar.compareTo(taxi.getSubmitTime()) > 0) {
//            return true;
//        }
//        return false;
        return writeOffCalendar.compareTo(taxi.getSubmitTime()) > 0;
    }

    Taxi getWriteOffCar(Taxi taxi) {
        int writeOffDay = (taxi.isRepair()) ? 3 * 365 : 6 * 365;
        Calendar writeOffCalendar = (Calendar) taxi.getBuyTime().clone();
        writeOffCalendar.add(Calendar.DAY_OF_YEAR, writeOffDay);
        if (isReminderTime(taxi.getSubmitTime(), writeOffCalendar)) {
            return taxi;
        }
        return null;
    }

    boolean isReminderTime(Calendar submitCal, Calendar endCal) {
        int writeOffYear = endCal.get(Calendar.YEAR);
        int writeOffMonth = endCal.get(Calendar.MONTH) + 1;
        int submitYear = submitCal.get(Calendar.YEAR);
        int submitMonth = submitCal.get(Calendar.MONTH) + 1;
        if (writeOffYear == submitYear && writeOffMonth == submitMonth + 1) {
            return true;
        }
        if (writeOffYear == submitYear && writeOffMonth == submitMonth && submitCal.compareTo(endCal) <= 0) {
            return true;
        }
        return false;
    }

    Taxi getDistanceRelatedMaintenanceCar(Taxi taxi) {
        final int maintenanceLimit = 10000;
        final int maintenanceRemindStandard = 500;
        long nowDistance = taxi.getUsageLength();
        if (nowDistance % maintenanceLimit == 0 || (maintenanceLimit - nowDistance % maintenanceLimit) <= maintenanceRemindStandard) {
            return taxi;
        }
        return null;
    }

    Taxi getTimeRelatedMaintenanceCar(Taxi taxi) {
        int checkEveryMonth = 12;
        int threeYear = 3;
        Calendar submitTime = (Calendar) taxi.getSubmitTime().clone();
        Calendar checkTime = (Calendar) taxi.getBuyTime().clone();
        if (submitTime.get(Calendar.YEAR) - checkTime.get(Calendar.YEAR) > threeYear) {
            checkEveryMonth = 6;
        }
        if (taxi.isRepair()) {
            checkEveryMonth = 3;
        }
        for (int n = 0; ; n++) {
            checkTime = (Calendar) taxi.getBuyTime().clone();
            checkTime.add(Calendar.MONTH, n * checkEveryMonth);
            if (submitTime.get(Calendar.YEAR) == checkTime.get(Calendar.YEAR)) {
                if (isReminderTime(submitTime, checkTime)) {
                    return taxi;
                } else {
                    continue;
                }
            }
            if (submitTime.get(Calendar.YEAR) < checkTime.get(Calendar.YEAR)) {
                break;
            }
        }
        return null;
    }

}
