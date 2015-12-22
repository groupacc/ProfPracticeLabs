package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	  
	 public static void main(String[] args) throws FileNotFoundException, IOException {
	        
	        // Part One: Weather 
	        File file3 = new File
	            ("C:\\Users\\Programmer\\workspace\\SEPractice\\Weather.dat");
	        
	        Forecast forecast = new Forecast();
	        forecast.Read(file3);
	        
	        // Part Two: Soccer League 
	        
	        File file2 = new File
	            ("C:\\Users\\Programmer\\workspace\\SEPractice\\Football.dat");
	        Football data2 = new Football();
	        data2.Read(file2);
	        
	    }  
}
