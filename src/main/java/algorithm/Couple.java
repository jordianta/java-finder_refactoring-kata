package algorithm;

public class Couple
{
    private final Person oldest;
    private final Person youngest;


    private Couple(final Person oldest, final Person youngest)
    {
        this.oldest = oldest;
        this.youngest = youngest;
    }


    public static Couple of(final Person person1, final Person person2)
    {
        if (person1.isOlder(person2))
        {
            return new Couple(person1, person2);
        }
        return new Couple(person2, person1);
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
