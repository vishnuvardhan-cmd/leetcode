package Data_structures;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinarySearch {
     /* if x is present in arr[] then returns the index of
        FIRST occurrence of x in arr[0..n-1], otherwise
        returns -1 */

    public static int first(int arr[], int low, int high,
                            int x, int n)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || x > arr[mid - 1])
                    && arr[mid] == x)
                return mid;
            else if (x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }

    /* if x is present in arr[] then returns the index of
    LAST occurrence of x in arr[0..n-1], otherwise
    returns -1 */
    public static int last(int arr[], int low, int high,
                           int x, int n)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == n - 1 || x < arr[mid + 1])
                    && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, low, (mid - 1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }

    public static int findFirst(int[] arr,int low,int high,int n,int x){
        if(high>=low){
            int mid=low+(high-low)/2;
            if(mid==0||arr[mid-1]<x&&arr[mid]==x){
                return mid;
            }
            else if(arr[mid]<x){
                return findFirst(arr,mid+1,high,n,x);
            }
            else{
                return findFirst(arr,0,mid-1,n,x);
            }
        }
        return -1;
    }
    public static int findLast(int [] arr,int low,int high,int n,int x){
        if(high>=low){
            int mid=low+(high-low)/2;
            if(mid==n-1||x<arr[mid+1] && arr[mid]==x){
                return mid;
            }
            else if (x < arr[mid])
                return last(arr, low, (mid - 1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }
    public void Test(){
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };

//
        List<Integer> list=List.of(3,242,21,4,1,54,83,1,357,52,-23,-234);
        System.out.println(list.stream().filter(e-> Collections.frequency(list,e)>1).collect(Collectors.toSet()));
        System.out.println(list.stream().
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
                entrySet().stream().filter(e->e.getValue()>1).map(k->k.getKey()).collect(Collectors.toSet()));

        list.stream().sorted(Comparator.reverseOrder());
        list.stream().max((o1, o2) -> o1>o2?o1:o2);
        int n = arr.length;
        int x = 8;
        System.out.println("First Occurrence = "
                + first(arr, 0, n - 1, x, n));
        System.out.println("Last Occurrence = "
                + last(arr, 0, n - 1, x, n));
        System.out.println("Firstfind Occurrence = "
                + findFirst(arr, 0, n - 1, n, x));
        System.out.println("Firstlast Occurrence = "
                + findLast(arr, 0, n - 1, n, x));
    }
}
