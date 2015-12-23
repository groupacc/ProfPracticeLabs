package Football;

import Common.Group;
import java.util.ArrayList;

public class SeasonInfo extends Group {
    ArrayList<FootballClub> clubs;

    public SeasonInfo() {
        this.clubs = new ArrayList<>();
    }

    public void add(FootballClub day) {
        this.clubs.add(day);
    }

    public ArrayList<FootballClub> get() {
        return this.clubs;
    }
}