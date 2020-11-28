package medium;

// 26.11.2020
// to test the functions of queue
import java.util.LinkedList;
import java.util.Queue;

public class BBQueue {

	public static void main(String[] args) {
		Queue<String> bbqLine = new LinkedList<String>();
		// add elements to queue
		bbqLine.add("Alex");
		bbqLine.add("Simone");
		bbqLine.add("John");

		// poll/remove the first element
		bbqLine.poll();
		// peek the first one in the array
		System.out.println(bbqLine.peek());
		// check the whole array
		System.out.println(bbqLine);

		System.out.println(bbqLine.size());
		// check if the specified element exists
		System.out.println(bbqLine.contains("Simone"));
		// covert to array and call array element
		System.out.println(bbqLine.toArray()[1]);
	}

}
