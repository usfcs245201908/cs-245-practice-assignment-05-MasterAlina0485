
import java.util.*;

/**
 * Write a description of class QuickSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuickSort implements SortingAlgorithm
{
    public QuickSort(){}

    /**
     * if larger than pivot, dump it on the right
     * if smaller than pivot, dump it on the left
     * 
     * recursively call for left and right portions
     */
    public void sort(int [] arr)
    {
        if (arr == null || arr.length == 0){return;}
        quicksort(arr,0, arr.length-1);
    }
    
    public void quicksort(int [] arr, int low, int high)
    {
        if (low >= high){return;}
        int temp;
        int pivot = arr[low+(high-low)/2];
        int i=low, j=high;

        while (j>i) 
        {
            while (arr[i]<pivot){ i++;} // find first element from left that's bigger than pivot
            while (arr[j]>pivot){j--;} // find first element from right that's smaller than pivot
			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++; j--;
			}
        }
        quicksort(arr,low, j);
        quicksort(arr, i, high);
    }
    
    public static void main(String [ ] args)
    {
        int[] toSort = {5, 10, 47, 2, 59, 21, 94, 19};
        //int[] toSort = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort sorter = new QuickSort();
        System.out.println(" Before Sort: "+Arrays.toString(toSort));
        sorter.sort(toSort);
        System.out.println(" After Sort: "+Arrays.toString(toSort)+"\n");
    }
}
