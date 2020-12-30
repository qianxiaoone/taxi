package entity;

import java.util.Calendar;

/**
 * @author wang-hc
 */
public class Taxi implements Comparable<Taxi> {
    private String taxiNo;
    private Calendar buyTime;
    private String brandName;
    private long usageLength;
    private boolean repair;
    private Calendar submitTime;

    public Taxi(String taxiNo, Calendar buyTime, String brandName, long usageLength, boolean repair) {
        this.taxiNo = taxiNo;
        this.buyTime = buyTime;
        this.brandName = brandName;
        this.usageLength = usageLength;
        this.repair = repair;
    }

    public Calendar getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Calendar submitTime) {
        this.submitTime = submitTime;
    }

    public Calendar getBuyTime() {
        return buyTime;
    }

    public String getTaxiNo() {
        return taxiNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public long getUsageLength() {
        return usageLength;
    }

    public boolean isRepair() {
        return repair;
    }

    @Override
    public int compareTo(Taxi o) {
        return this.getBrandName().compareTo(o.getBrandName());
    }
}
