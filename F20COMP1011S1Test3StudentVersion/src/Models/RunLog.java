/*
    Name:       Wyatt Kirschner
    Date:       12/16/20
    Purpose:    Test 3 - COMP1011
 */

package Models;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class RunLog implements Comparable<RunLog>{
    @SerializedName("date")
    private String date;

    @SerializedName("distanceInKM")
    private int distanceInKM;

    @SerializedName("durationInSec")
    private double durationInSec;

    public RunLog(LocalDate date, int distanceInKM, double duration) {
        setDate(date);
        this.distanceInKM = distanceInKM;
        setDurationInSec(duration);
    }

    public double getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(double durationInSec) {
        if (durationInSec >= distanceInKM*3*60)
            this.durationInSec = durationInSec;
        else
            throw new IllegalArgumentException(String.format("That runtime is too fast! " +
                    "Distance: %d  Duration: %.1f" ,distanceInKM, durationInSec));
    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date.toString();
    }

    public int getDistanceInKM() {
        return distanceInKM;
    }

    public void setDistanceInKM(int distanceInKM) {
        this.distanceInKM = distanceInKM;
    }

    public double getDuration() {
        return durationInSec;
    }

    public void setDuration(double duration) {
        this.durationInSec = duration;
    }

    @Override
    public int compareTo(RunLog o) {
        return this.date.compareTo(o.date);
    }
}
