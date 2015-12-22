package Weather;

import Common.*;

import java.util.ArrayList;

public class SmallMonth implements GroupPrinter {
    @Override
    public void print(Group group) {
        ArrayList<DataUnit> days = group.getDataUnits();
        DataUnit minSpread = days.get(0);

        for(DataUnit d : days) {
            if(minSpread.getSpread() > d.getSpread()) {
                minSpread = d;
            }
        }

        System.out.println(minSpread);
    }
}
