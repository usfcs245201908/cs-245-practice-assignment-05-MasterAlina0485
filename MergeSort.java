import java.util.*;

/**
 * Write a description of class InsertionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MergeSort implements SortingAlgorithm
{
    public MergeSort(){}

    public void sort(int [] arr)
    {
        int [] temp = split(arr);
        for (int i = 0; i< temp.length; i++)
        {
            arr[i] = temp[i];
        }
    }
    
    /**
     *  if greater than length 1, recursively call split
     *  if array is length 1, stop splitting and continue to merge portion
     *  once split is done running merge splitted arrays and return merged
     *  
     */
    public int[] split(int[] arr)
    {
        int[] left;
        int[] right;
        if (arr.length > 1)
        {
            left = split(Arrays.copyOfRange(arr,0,arr.length/2));
            right = split(Arrays.copyOfRange(arr,(arr.length/2),arr.length));
        }
        else 
        {
            return arr; 
        }
        return merge(left, right);
    }
    
    /**
     * create array of length of both left and right arrays
     * add lower element from each side until one side is empty
     * copy the rest to end of array
     */
    public int[] merge(int[] left, int[] right)
    {
        int[] merged = new int [left.length+right.length];
        
        int index1=0;
        int index2=0;
        int x = 0;
        while (index1<left.length && index2<right.length)
        {
           if (left[index1]<right[index2])
           {
               merged[x] = left[index1];
               index1++;
               x++;
           }
           else
           {
               merged[x] = right[index2];
               index2++;
               x++;
           }
        }
        for (int i=index1;i<left.length;i++)
        {
            merged[x] = left[index1];
            index1++;
            x++;
        }
        for (int i=index2;i<right.length;i++)
        {
            merged[x] = right[index2];
            index2++;
            x++;
        }
        return merged;
    }
    
    public static void main(String [ ] args)
    {
        int[] toSort = {5, 39, 27, 2, 59, 21, 94, 19};
        MergeSort sorter = new MergeSort();
        System.out.println(" Before Sort: "+Arrays.toString(toSort));
        sorter.sort(toSort);
        System.out.println(" After Sort: "+Arrays.toString(toSort));
    }
}
