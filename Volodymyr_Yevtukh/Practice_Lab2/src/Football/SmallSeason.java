package Football;

import Common.*;

import java.util.ArrayList;

public class SmallSeason implements GroupPrinter {
    @Override
    public void print(Group group) {
        ArrayList<DataUnit> clubs = group.getDataUnits();
        DataUnit minSpread = clubs.get(0);

        for(DataUnit c : clubs) {
            if(minSpread.getSpread() > c.getSpread()) {
                minSpread = c;
            }
        }

        System.out.println(minSpread);
    }
}