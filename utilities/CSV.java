package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;


public class CSV {

    //this function will read data from a CSV file and return as a list
    //collection list allowed to add elements dynamically if we dont know the number
    public static List<String[]> read(String file) {

        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
           
            //read all the lines in the file while its not empty
           while ((dataRow = br.readLine()) != null) {
            String[] dataRecords = dataRow.split(","); //split by comment add to array
            data.add(dataRecords);
           }

        } catch (FileNotFoundException e) {
            System.out.println("COULD NOT FIND FILE");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("COULD NOT READ FILE");
            e.printStackTrace();
        }
        return data;
    }
    
}
