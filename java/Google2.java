import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;

class RandomGengerator {
	private Random rand; 
	
	public RandomGengerator() {
		rand = new Random();
	}
	
	int getRandomNumber() {
		return rand.nextInt();
	}
}

public class Google2 {
	
	public long numberOfCalls(Supplier<Integer> generator, int[] expected) {
		HashMap<Integer, Long> valueMap = new HashMap<>();
		
		for (int i : expected) {
			if (valueMap.containsKey(i)) {
				valueMap.put(i, valueMap.get(i) + 1L);
			} else {
				valueMap.put(i, 1L);
			}
		}
		
		long calls = 0;
		while (!valueMap.isEmpty()) {
			int randV = generator.get();
			if (valueMap.containsKey(randV)) {
				if (valueMap.get(randV) == 1) {
					valueMap.remove(randV);
				} else {
					valueMap.put(randV, valueMap.get(randV) - 1L);
				}
			}
			calls++;
		}
		
		return calls;
	}
	

	public static void main(String[] args) {
		RandomGengerator generator = new RandomGengerator();
		System.out.println(new Google2().numberOfCalls(generator::getRandomNumber, new int[]{1,2,3,4,5,6,7,8,9})); 

	}

}
