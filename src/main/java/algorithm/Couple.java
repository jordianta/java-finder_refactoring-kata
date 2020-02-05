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
        return youngest.getBirthDateTime() - oldest.getBirthDateTime();
    }


    public boolean isCloser(final Couple couple)
    {
        return this.getDistance() < couple.getDistance();
    }


    public boolean isFarther(final Couple couple)
    {
        return this.getDistance() > couple.getDistance();
    }
}
