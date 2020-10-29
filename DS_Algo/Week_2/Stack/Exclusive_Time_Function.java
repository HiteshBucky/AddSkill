class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] output = new int[n];
		Deque<Integer> stack = new LinkedList<>();
		int prevTime = 0;

		for (String log : logs) {
			String[] split = log.split(":");
			//Extracting all the data from the string
			int Id = Integer.parseInt(split[0]);
			boolean isStart = split[1].equals("start");
			int time = Integer.parseInt(split[2]);

			if (!isStart) time++;

			if (!stack.isEmpty()) output[stack.peek()] += time - prevTime;

			if (isStart) stack.push(Id);
			else stack.pop();

			prevTime = time;
		}
		return output;
	}
}

