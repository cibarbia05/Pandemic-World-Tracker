package Model;

public class Infection {
    private int cases;
    private int deaths;
    private int recoveries;

    /*On instantiation, creates an infection which has cases, deaths, and recoveries*/
    public Infection(int c, int d, int r){
        cases = c;
        deaths = d;
        recoveries = r;
    }
    public int getCases() {
        return cases;
    }
    public int getDeaths() {
        return deaths;
    }
    public int getRecoveries() {
        return recoveries;
    }
}
