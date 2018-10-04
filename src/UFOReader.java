/*
Lyndsey Wilson
ID#684781

.join Gray https://stackoverflow.com/questions/15956231/what-does-this-thread-join-code-mean
https://www.geeksforgeeks.org/multithreading-in-java/
 */
public class UFOReader
{
    private static int TYPES[] = {3, 2, 0, 10, 11};

    public static void main(String[] args) throws InterruptedException
    {
        for(int i = 0; i < TYPES.length; i++)
        {
            CategorizeThread timeThread = new CategorizeThread(TYPES[i]);
            timeThread.start();
            timeThread.join();
        }

        System.out.println("PARENT FINISHED");
    }
}
