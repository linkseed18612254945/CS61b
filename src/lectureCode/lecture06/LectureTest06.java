package lectureCode.lecture06;

public class LectureTest06
{	
	public static void speedTest()
	{
		AList L = new AList();
		int i = 0;
		while (i < 1000000)
		{
			L.addLast(i);
			i += 1;
		}
	}

	public static void main(String[] args) 
	{
		AList<Integer> L = new AList<>();
		L.addLast(3);
		L.addLast(2);
		L.addLast(1);
		int delValue = L.removeLast();
		System.out.println(L);
		System.out.println(delValue);

		//speedTest();
	}
}