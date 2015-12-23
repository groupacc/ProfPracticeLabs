import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;


public class FileProcessor {

    public LinkedList<LinkedList<String>> readFromFile(String fileName) {

        StringBuilder sb = new StringBuilder();
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                LinkedList<String> array = new LinkedList<>();

                for (String tempStr: line.split(" ")){
                    if(!tempStr.equals("")) {
                        array.add(tempStr);
                    }
                }
                result.add(array);
                line = br.readLine();
            }
            result.removeFirst();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {}

        return result;
    }
}
