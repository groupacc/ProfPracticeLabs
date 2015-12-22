package Common;

import java.util.ArrayList;

public class Group {
    ArrayList<DataUnit> dataUnits;


    public Group() {
        this.dataUnits = new ArrayList<>();
    }

    public void add(DataUnit unit) {
        this.dataUnits.add(unit);
    }

    public ArrayList<DataUnit> getDataUnits() {
        return this.dataUnits;
    }
}
