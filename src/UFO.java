/*
Lyndsey Wilson
ID#684781

https://stackoverflow.com/questions/14833008/java-string-split-with-dot Tutor explained to me.

 */

public class UFO
{
    private String month, year;
    private String occur_time, posted_date;
    private String city, state, country, shape, comments;
    private String duration, latitude, longitude;

    //sets each part of the ufo file to its contnet
    public UFO(String datetime, String city, String state, String country, String shape, String duration, String comments, String posted, String latitude, String longitude)
    {
        setDateTime(datetime);
        setCity(city);
        setState(state);
        setCountry(country);
        setShape(shape);
        setDuration(duration);
        setComments(comments);
        setPostedDate(posted);
        setLatitude(latitude);
        setLongitude(longitude);
    }
    //setting it up to get the time
    public void setDateTime(String datetime)
    {
        try
        {
            occur_time = datetime.split(" ")[1];
            for(int i = 0; i < 5 - occur_time.length(); i++)
                occur_time = ("0" + occur_time);

            String date = datetime.split(" ")[0];
            month = date.split("/")[0];
            year = date.split("/")[2];
        }
        catch (Exception e)
        {
            occur_time = "unknown";
            month = "unknown";
            year = "unknown";
        }
    }
    //retrieving the time
    public String getDateTime()
    {
        return occur_time;
    }

    //set the city to city
    public void setCity(String city)
    {
        this.city = city;
    }

    //gets the city
    public String getCity()
    {
        return city;
    }

    //sets the state
    public void setState(String state)
    {
        this.state = state;
    }

    //gets the state
    public String getState()
    {
        return state;
    }

    //sets the country
    public void setCountry(String country)
    {
        this.country = country;
    }

    //gets the country
    public String getCountry()
    {
        return country;
    }

    //sets the shape
    public void setShape(String shape)
    {
        this.shape = shape;
    }

    //gets the shape
    public String getShape()
    {
        return shape;
    }

    //sets the duration
    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    //gets the duration
    public String getDuration()
    {
        return duration;
    }

    //sets comments
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    //gets the comments
    public String getComments()
    {
        return comments;
    }

    //sets posted date
    public void setPostedDate(String date)
    {
        posted_date = date;
    }

    //gets posted date
    public String getPostedDate()
    {
        return posted_date;
    }

    //sets latitude
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    //gets the latitude
    public String getLatitude()
    {
        return latitude;
    }

    //sets longitude
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    //gets the longitude
    public String getLongitude()
    {
        return longitude;
    }

    //gets the month
    public String getMonth()
    {
        return month;
    }

    //gets the year
    public String getYear()
    {
        return year;
    }
}
