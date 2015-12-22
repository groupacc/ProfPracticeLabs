package Common;

import java.util.ArrayList;

public class SmallerGroup implements GroupPrinter {
    @Override
    public void print(Group group) {
        ArrayList<DataUnit> units = group.getDataUnits();
        DataUnit minSpread = units.get(0);

        for(DataUnit c : units) {
            if(minSpread.getSpread() > c.getSpread()) {
                minSpread = c;
            }
        }

        System.out.println(minSpread);
    }
}
