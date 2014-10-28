import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class sort9323 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		int seed = Integer.parseInt(string);
		Random r =new Random(seed);
		int[] array = new int[10000];
		for (int i = 0; i < 10000; i++) {
			array[i]=r.nextInt(10000);
			//System.out.println(array[i]);
		}
		
		//bubble sort
		//bubbleSort(array);

		//quick sort
		sort(array);


		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

	public static void bubbleSort(int[] array) {
		//bubble sort
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i]>array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}


	public static void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		int length = inputArr.length;
		quickSort(0, length - 1, inputArr);
	}

	private static void quickSort(int lowerIndex, int higherIndex, int[] array) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j, array);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j, array);
		if (i < higherIndex)
			quickSort(i, higherIndex, array);
	}

	private static void exchangeNumbers(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
