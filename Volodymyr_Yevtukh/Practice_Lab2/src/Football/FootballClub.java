package Football;

import Common.DataUnit;

public class FootballClub implements DataUnit {
    String name;
    int scoresFor;
    int scoresAgainst;


    public FootballClub(String name, int scoresFor, int scoresAgainst) {
        this.name = name;
        this.scoresFor = scoresFor;
        this.scoresAgainst = scoresAgainst;
    }

    public int getSpread() {
        return Math.abs(this.scoresAgainst - this.scoresFor);
    }

    public String getName() {
        return name;
    }

    public int getScoresFor() {
        return scoresFor;
    }

    public int getScoresAgainst() {
        return scoresAgainst;
    }

    @Override
    public String toString() {
        return name + ": " +
                "scoresFor = " + scoresFor +
                "; scoresAgainst = " + scoresAgainst +
                "; spread = " + getSpread();
    }
}