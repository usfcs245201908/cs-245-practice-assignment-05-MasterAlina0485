import java.util.*;

/**
 * Write a description of class InsertionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsertionSort implements SortingAlgorithm
{
    public InsertionSort(){}

    public void sort(int [] arr)
    {
        int index = 0; 
        for (int i=1; i<arr.length; i++) //loops through array positions. also marks sorted/unsorted split. 
        {
            index = i;
            while (index>0 && arr[index]<arr[index-1]){ // if higher index is smaller, swap until reach index 0
                int temp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = temp;
                index--;
            }
        }
    }
    
    public static void main(String [ ] args)
    {
        int[] toSort = {5, 10, 47, 2, 59, 21, 94, 19};
        InsertionSort sorter = new InsertionSort();
        System.out.println(" Before Sort: "+Arrays.toString(toSort));
        sorter.sort(toSort);
        System.out.println(" After Sort: "+Arrays.toString(toSort));
    }
}
