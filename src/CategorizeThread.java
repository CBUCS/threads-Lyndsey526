/*
Lyndsey Wilson
ID#684781

https://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap
https://www.geeksforgeeks.org/hashmap-treemap-java/
https://www.geeksforgeeks.org/multithreading-in-java/
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class CategorizeThread extends Thread
{
    int categoryType;
    TreeMap<String, Integer> occurrences;
    TreeMap<Integer, Integer> blockOccurrences;
    private final String START_TIMES[] = {"00:01", "08:01", "12:01", "16:01", "20:01", "unknown"};
    private final String END_TIMES[] = {"08:00", "12:00", "16:00", "20:00", "00:00", "unknown"};

    public CategorizeThread(int type)
    {
        super();
        categoryType = type;
        occurrences = new TreeMap<String, Integer>();
        blockOccurrences = new TreeMap<Integer, Integer>();
    }

    @Override
    public void run()
    {
        Iterator<UFO> table = UFODataTable.getInstance().getIterator();
        while(table.hasNext())
        {
            String record_val = getColumnValue(table.next());
            if(!occurrences.containsKey(record_val))
                occurrences.put(record_val, 1);
            else
                occurrences.put(record_val, occurrences.get(record_val) + 1);
        }
        printToFile(getOutputFile());
    }

    private String getColumnValue(UFO ufo)
    {
        switch(categoryType)
        {
            case 0: return ufo.getDateTime();
            case 1: return ufo.getCity();
            case 2: return ufo.getState();
            case 3: return ufo.getCountry();
            case 4: return ufo.getShape();
            case 5: return ufo.getDuration();
            case 6: return ufo.getComments();
            case 7: return ufo.getPostedDate();
            case 8: return ufo.getLatitude();
            case 9: return ufo.getLongitude();
            case 10: return ufo.getMonth();
            default: return ufo.getYear();
        }
    }

    private String getOutputFile()
    {
        switch(categoryType)
        {
            case 0: return "datetime.txt";
            case 1: return "city.txt";
            case 2: return "state.txt";
            case 3: return "country.txt";
            case 4: return "shape.txt";
            case 5: return "duration.txt";
            case 6: return "comments.txt";
            case 7: return "posted.txt";
            case 8: return "latitude.txt";
            case 9: return "longitude.txt";
            case 10: return "month.txt";
            default: return "year.txt";
        }
    }

    private void printToFile(String file_name)
    {
        try
        {
            PrintWriter writer = new PrintWriter(new File(file_name));
            Iterator<String> set = occurrences.keySet().iterator();

            while(set.hasNext())
            {
                if(categoryType != 0)
                {
                    Object obj = set.next();
                    writer.println((obj.equals("") ? "N/A" : obj) + ": " + occurrences.get(obj));
                }
                else
                {
                    String obj = (String)set.next();
                    obj = (obj.equals("00:00") ? "24:00" : obj);
                    Integer block = getEndTime(obj);
                    obj = (obj.equals("24:00") ? "00:00" : obj);
                    if(blockOccurrences.containsKey(block))
                        blockOccurrences.put(block, blockOccurrences.get(block) + occurrences.get(obj));
                    else
                        blockOccurrences.put(block, occurrences.get(obj));
                }
            }

            if(categoryType == 0)
            {
                for(int i = 0; i < 5; i++)
                    writer.println(START_TIMES[i] + " - " + END_TIMES[i] + ": " + blockOccurrences.get(i));
                writer.println("unknown: " + blockOccurrences.get(5));
            }
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("CHILD FINISHED");
    }

    private int getEndTime(String time)
    {
        if(time.compareTo("08:00") <= 0)
            return 0;
        else if(time.compareTo("12:00") <= 0)
            return 1;
        else if(time.compareTo("16:00") <= 0)
            return 2;
        else if(time.compareTo("20:00") <= 0)
            return 3;
        else if(time.compareTo("24:00") <= 0)
            return 4;
        else
            return 5;
    }
}
