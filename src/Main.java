   import java.util.Scanner;

	public class Main {
	  public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Sayilari virgul ile ayirarak giriniz: ");
	    String input = scanner.nextLine();

	    
	    String[] numbers = input.split(",");

	    
	    int[] arr = new int[numbers.length];

	    
	    for (int i = 0; i < numbers.length; i++) {
	      arr[i] = Integer.parseInt(numbers[i]);
	    }

	    
	    if (isTripleMinHeap(arr)) {
	      System.out.println("Min Heaptir.");
	    } else {
	      System.out.println("Min Heap Degildir.");
	    }

	   
	    tripleMinHeapSort(arr);
	    
	    System.out.print("Min Heap : ");
	    for (int i = 0; i < numbers.length; i++) {
	      System.out.print(arr[i] + " ");
	    }
	  }

	  
	  public static boolean isTripleMinHeap(int[] arr) {
	    
	    if (arr.length < 3) {
	      return false;
	    }

	    
	    if (arr[0] > arr[1] || arr[0] > arr[2]) {
	      return false;
	    }

	    
	    for (int i = 3; i < arr.length; i++) {
	      if (arr[i] < arr[(i - 1) / 3]) {
	        return false;
	      }
	    }

	    return true;
	  }

	  
	  public static void tripleMinHeapSort(int[] array) {
		    
		    int n = array.length;
		    for (int i = (n - 1) / 3; i >= 0; i--) {
		      tripleMinHeapify(array, n, i);
		    }

		    
		   
	  }

		  public static void tripleMinHeapify(int[] array, int n, int i) {
		    int smallest = i;
		    int left = 3 * i + 1;
		    int middle = 3 * i + 2;
		    int right = 3 * i + 3;

		    
		    if (left < n && array[left] < array[smallest]) {
		      smallest = left;
		    }
		    if (middle < n && array[middle] < array[smallest]) {
		      smallest = middle;
		    }
		    if (right < n && array[right] < array[smallest]) {
		      smallest = right;
		    }

		    
		    if (smallest != i) {
		      int temp = array[i];
		      array[i] = array[smallest];
		      array[smallest] = temp;
		      tripleMinHeapify(array, n, smallest);
		    }
		  }
	}
