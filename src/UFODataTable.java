/*
Lyndsey Wilson
ID#684781
https://www.geeksforgeeks.org/singleton-class-java/
https://www.geeksforgeeks.org/how-to-use-iterator-in-java/
https://stackoverflow.com/questions/11871520/how-can-i-read-input-from-the-console-using-the-scanner-class-in-java
 */

import java.io.*;
import java.util.*;

public class UFODataTable
{
    private static UFODataTable instance = null;
    private static final String FILE_NAME = "scrubbed.csv";
    private ArrayList<UFO> list = new ArrayList<UFO>();

    private UFODataTable() throws FileNotFoundException
    {
        Scanner input = new Scanner(new File(FILE_NAME));
        input.nextLine();

        while(input.hasNextLine())
        {
            String line = input.nextLine();
            Scanner lineInput = new Scanner(line);
            lineInput.useDelimiter(",");

            String dtime = lineInput.next();
            String city = lineInput.next();
            String state = lineInput.next();
            String country = lineInput.next();
            String shape = lineInput.next();
            String duration = lineInput.next();
            lineInput.next();
            String comments = lineInput.next();
            String posted = lineInput.next();
            String latitude = lineInput.next();
            String longitude = lineInput.next();
            list.add(new UFO(dtime, city, state, country, shape, duration, comments, posted, latitude, longitude));
        }

        input.close();
    }

    public static UFODataTable getInstance()
    {
        try
        {
            if(instance == null)
                instance = new UFODataTable();
            return instance;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Iterator<UFO> getIterator()
    {
        return list.iterator();
    }
}
