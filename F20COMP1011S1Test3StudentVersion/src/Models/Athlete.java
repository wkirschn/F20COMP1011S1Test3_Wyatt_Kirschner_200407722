/*
    Name:       Wyatt Kirschner
    Date:       12/16/20
    Purpose:    Test 3 - COMP1011
 */

package Models;

import java.util.OptionalDouble;
import java.util.TreeSet;

public class Athlete implements Comparable<Athlete> {
    private int id;
    private String gender, firstName, lastName;
    private TreeSet<RunLog> runLogs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TreeSet<RunLog> getRunLogs() {
        return runLogs;
    }

    public void setRunLogs(TreeSet<RunLog> runLogs) {
        this.runLogs = runLogs;
    }

    public int getNumberOfRuns()
    {
        return runLogs.size();
    }

    public double getAvgDistance()
    {
        OptionalDouble avgDistance = runLogs.stream()
                                    .mapToDouble(RunLog::getDistanceInKM)
                                    .average();

        return avgDistance.isPresent()?avgDistance.getAsDouble():0;
    }

    public Integer getTotalDistanceRun()
    {
        return runLogs.stream()
                        .mapToInt(run -> run.getDistanceInKM())
                        .sum();
    }

    public double getTotalTime()
    {
        return runLogs.stream()
                        .mapToDouble(RunLog::getDuration)
                        .sum();
    }

    public double getAvgPace()
    {
        return (getTotalTime()/60)/getTotalDistanceRun();
    }

    public String toString()
    {
        return String.format("%d %s %s, avg pace: %.1f",id,firstName,lastName,getAvgPace());
    }

    @Override
    public int compareTo(Athlete o) {
        return Integer.compare(this.id, o.id);
    }
}
