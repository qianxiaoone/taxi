package input;

import entity.InputInfo;
import entity.Taxi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author wang-hc
 */
public class InputParam {
    public InputInfo getTaxiInfo(String inputStr) {
        final String submitDate = "SubmitDate";
        Calendar checkDate = null;
        List<Taxi> checkTaxis = new ArrayList<Taxi>();
        String[] inputArr = inputStr.split("\n");
        for (String inputLine : inputArr) {
            if (inputLine.equals("")) {
                continue;
            }
            if (inputLine.startsWith(submitDate)) {
                checkDate = getCalendar(inputLine.split(":")[1]);
                continue;
            }
            Taxi taxi = getTaxi(inputLine);
            taxi.setSubmitTime(checkDate);
            checkTaxis.add(taxi);
        }
        return new InputInfo(checkDate, checkTaxis);
    }

    public Taxi getTaxi(String taxisInfo) {
        String[] taxiInfo = taxisInfo.split("\\|");
        return new Taxi(taxiInfo[0], getCalendar(taxiInfo[1]), taxiInfo[2], Long.parseLong(taxiInfo[3]), taxiInfo[4].equals("T"));
    }

    public Calendar getCalendar(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

}
