import java.util.Arrays;
public class Sort {
	
	private Sort() {
		throw new IllegalStateException("Sort class");
	}
	
	public static int[] selectSort(int[] x) {
		for (int i = 0; i < x.length; i++) {
			int min = Integer.MAX_VALUE;
			int index = i;
			for (int j = i; j < x.length; j++) {
				if (x[j] < min) {
					min = x[j];
					index = j;
				}
			}
			x[index] = x[i];
			x[i] = min;
		}
		return x;
	}
	
	public static int[] insertSort(int[] x) {
		for (int i = 1; i < x.length; i++) {
			int index = i;
			// this could be a while loop too 
			for (int j = i-1; j >= 0 && x[j] > x[index]; j--) {
				int temp = x[j];
				x[j] = x[index];
				x[index] = temp;
				index = j;
			}
		}
		return x;
	}
	
	public static int[] mergeSort(int[] x) {
		if (x.length <= 1) {
			return x;
		}
		int[] a = Arrays.copyOfRange(x, 0, x.length/2);
		int[] b = Arrays.copyOfRange(x,  x.length/2, x.length);
		a = mergeSort(a);
		b = mergeSort(b);
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				x[i+j] = a[i];
				i++;
			}
			else {
				x[i+j] = b[j];
				j++;
			}
		}
		for (int k = i; k < a.length; k++) {
			x[k+j] = a[k];
		}
		for (int l = j; l < b.length; l++) {
			x[i+l] = b[l];
		}
		return x;
	}
	
	public static int[] stupidSort(int[] x) {
		int index = 0;
		while (index < x.length) {
			if (index == 0) {
				index++;
			}
			else if (x[index-1] <= x[index]) {
				index++;
			}
			else {
				int temp = x[index];
				x[index] = x[index-1];
				x[index-1] = temp;
				index --;
			}
		}
		return x;
	}
	
	public static int binarySearch(int[] x, int value) {
		int index = x.length/2;
		if (x.length == 1 && x[index] != value) {
			if (x[0] > value) {
				return 0;
			}
			return 1;
		}
		if (x[index] == value) {
			return index;
		}
		
		if (x[index] > value) {
			return binarySearch(Arrays.copyOfRange(x, 0, index), value);
		}
		
		else {
			return index + binarySearch(Arrays.copyOfRange(x, index, x.length), value);
		}
	}
	
	public static void arrayPrint(int[] x) {
		for (int y: x) {
			System.out.print(" " + y);
		}
		System.out.println();
	}
}
