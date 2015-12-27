package Football;

public class RowReader {
    public String[] getParameters(String data) {
        String[] params = (data.trim()).split("[-\\* ]+");

        if(params.length < 3) return null;
        return params;
    }
}
