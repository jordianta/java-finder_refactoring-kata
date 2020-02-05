package algorithm;
public class Couple
{
	private Person oldest;
	private Person youngest;
	private long distance;


	public Person getOldest()
	{
		return oldest;
	}


	public void setOldest(final Person oldest)
	{
		this.oldest = oldest;
	}


	public Person getYoungest()
	{
		return youngest;
	}


	public void setYoungest(final Person youngest)
	{
		this.youngest = youngest;
	}


	public long getDistance()
	{
		return distance;
	}


	public void setDistance(final long distance)
	{
		this.distance = distance;
	}
}
