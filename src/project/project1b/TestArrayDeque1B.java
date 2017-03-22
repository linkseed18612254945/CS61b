package project.project1b;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;

public class TestArrayDeque1B
{	
	@Test
	public void dequeTest()
	{
		StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
		ArrayDequeSolution<Integer> rightDeque = new ArrayDequeSolution<>();
		OperationSequence stepMessage = new OperationSequence();

		while(true)
		{	
			double randomNumberZeroToOne = StdRandom.uniform();
			Integer addNum = (int) (randomNumberZeroToOne * 10);
			if (randomNumberZeroToOne < 0.25 || studentDeque.isEmpty())
			{
				studentDeque.addFirst(addNum);
				rightDeque.addFirst(addNum);
				DequeOperation currenOperation = new DequeOperation("addFirst", addNum);
				addStepMessage(stepMessage, currenOperation);
			}
			else if (0.25 <= randomNumberZeroToOne && randomNumberZeroToOne < 0.5) 
			{
				studentDeque.addLast(addNum);
				rightDeque.addLast(addNum);
				DequeOperation currenOperation = new DequeOperation("addLast", addNum);
				addStepMessage(stepMessage, currenOperation);
			}
			else if (0.5 <= randomNumberZeroToOne && randomNumberZeroToOne < 0.75) 
			{
				Integer studentRemoveNum = studentDeque.removeFirst();
				Integer rightRemoveNum = rightDeque.removeFirst();
				DequeOperation currenOperation = new DequeOperation("removeFirst");
				addStepMessage(stepMessage, currenOperation);
				assertEquals(stepMessage.toString(), studentRemoveNum, rightRemoveNum);
			}
			else
			{
				Integer studentRemoveNum = studentDeque.removeLast();
				Integer rightRemoveNum = rightDeque.removeLast();
				DequeOperation currenOperation = new DequeOperation("removeLast");
				addStepMessage(stepMessage, currenOperation);
				assertEquals(stepMessage.toString(), studentRemoveNum, rightRemoveNum);
			}
		}

	}

	public static void addStepMessage(OperationSequence os, DequeOperation d)
	{
		if (os.sequenceSize() < 3)
		{
			os.addOperation(d);
		}
		else
		{
			os.addOperation(d);
			os.removeOperation();
		}
	} 

	public static void main(String[] args)
	{
		jh61b.junit.TestRunner.runTests("all", TestArrayDeque1B.class);
	}
}