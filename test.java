public class test {
	public static void main(String args[]) {
		int[] x = {-4, 3, 21, 2, 0, -5, 34, 1, 1, 3};
		//Sort.selectSort(x);
		//Sort.insertSort(x);
		//Sort.mergeSort(x);
		Sort.stupidSort(x);
		Sort.arrayPrint(x);
		System.out.println(Sort.binarySearch(x, 22));
	}
	
}
