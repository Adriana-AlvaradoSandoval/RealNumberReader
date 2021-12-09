package realNumbReader;

public class fileLinkedList {
	// Data members
	private ListNode head;
	private ListNode tail;

	// constructors
	public fileLinkedList() {
		head = null;
		tail = null;
	}

	public void addNode(int n) {
		ListNode temp = new ListNode(n);

		if (head == null) {
			head = temp;
			tail = temp;
		}

		else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}

	public String toPrint() {
		ListNode travel = head;
		String collection = "";

		while (travel != null) {
			collection += travel.n + " ";
			travel = travel.next;
		}

		return collection;
	}

	public String calc() {
		int count = 0;
		int sum = 0;
		double mean;
		double stDev;

		ListNode travel = head;

		while (travel != null) {
			sum += travel.n;
			travel = travel.next;
			count++;
		}
		System.out.println("sum: " + sum);
		System.out.println("count: " + count);

		mean = (double) sum / count;

		double step = 0;

		travel = head;

		while (travel != null) {
			step += Math.pow((travel.n - mean), 2);
			travel = travel.next;
		}

		stDev = Math.sqrt(step / (count));

		return "Mean: " + mean + "\nStandard Deviation: " + stDev;
	}

	public Integer pop() {
		// grab the item from the front
		int headValue = -1;
		if (head != null) {
			headValue = head.n;
		}
		// constructing a queue
		// if there is only 1 item in the list
		if (head == tail) {
			tail = null;
			head = null;
		}
		// if there is more than 1 item in the list
		else {
			head.next.prev = null;
			head = head.next;

		}
		return headValue;
	}

}
