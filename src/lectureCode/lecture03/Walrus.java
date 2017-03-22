package lectureCode.lecture03;

public class Walrus
{
	public int weight;
	public double tuskSize;

	public Walrus(int w, double tusk)
	{
		weight = w;
		tuskSize = tusk;
	}

	public String toString()
	{
		return String.format("weight: %d, tusk size: %.2f", weight, tuskSize);
	}
}