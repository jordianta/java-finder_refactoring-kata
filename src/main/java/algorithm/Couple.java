package algorithm;

public class Couple
{
    private final Person oldest;
    private final Person youngest;


    public Couple(final Person oldest, final Person youngest)
    {
        this.oldest = oldest;
        this.youngest = youngest;
    }


    public Couple()
    {
        this.oldest = null;
        this.youngest = null;
    }


    public Person getOldest()
    {
        return oldest;
    }


    public Person getYoungest()
    {
        return youngest;
    }


    public long getDistance()
    {
        if (youngest == null || oldest == null)
        {
            return 0;
        }
        return youngest.getBirthDateTime() - oldest.getBirthDateTime();
    }
}
