package Models;

import java.util.ArrayList;

public class RaceEvent {
    private ArrayList<Athlete> athletes;
    private String date;
    private String examStatus;

    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(ArrayList<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }
}
