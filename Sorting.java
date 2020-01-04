import java.util.Random;
public class Sorting{

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selection_sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++)
                if(less(arr[j], arr[min]))
                    min = j;
            swap(arr, min, i);
        }
    }

    public static void bubble_sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            boolean swapped = false;
            for(int j = 0; j < n-i-1; j++)
                if(less(arr[j+1], arr[j])){
                    swap(arr, j, j+1);
                    swapped = true;
                }
                
            if(swapped == false)
                    break;
        }
        
    }

    public static void insertion_sort(Comparable[] arr){

        /* best case is O(n), average & worst is O(n^2)
           faster for smaller arrays, best case is when the array is already sorted.
        */
        int n = arr.length;
        for(int i = 1; i < n; i++)
            for(int j = i; j > 0 && less(arr[j], arr[j-1]); j--)
                    swap(arr, j, j-1);
    }

    public static void shell_sort(Comparable[] arr){

        /* modified version of insertion sort */

        int n = arr.length;
        int h = 1;
        while(h < n/3)
            h = 3 * h + 1; // 3x+1 increments
        
        while(h >= 1){

            for(int i = h; i < n; i++)
                for(int j = i; j >= h && less(arr[j], arr[j-h]); j -= h)
                    swap(arr, j, j-h);
            
            h /= 3;
        }
    }

    public static void knuth_shuffle(Comparable[] arr){

        int n = arr.length;
        Random r = new Random();

        for(int i = 1; i < n; i++)
            swap(arr, i, r.nextInt(i+1));

    }

    static class MergeSort{

        /*
            O(n log n)
            39% fewer comparisions than quicksort's best case, but more data movement hence expensive.
            Out of place sorting and stable.
        */



        static void merge(Comparable[] a, Comparable aux[], int lo, int mid, int hi){
            int i = lo, j = mid + 1;

            for(int k = lo; k <= hi; k++)
                aux[k] = a[k];

            for(int k = lo; k <= hi; k++){
                if(i > mid)     a[k] = aux[j++];
                else if (j > hi)    a[k] = aux[i++];
                else if(less(aux[j], aux[i]))      a[k] = aux[j++];
                else    a[k] = aux[i++];
            }
        }
        static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
            if(hi <= lo)    return;
            int mid = lo + (hi-lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid+1, hi);
            if(!less(a[mid+1], a[mid])) return; //simple optimization
            merge(a, aux, lo, mid, hi);
        }
        static void sort(Comparable[] a){
            Comparable aux[] = new Comparable[a.length];
            sort(a, aux, 0, a.length-1);
        }
    }

    static class QuickSort{

        /* Average case scenario 1.39 N log N comparisions.
           Worst case (if already sorted or reverse sorted), 1/2 N^2 i.e quadratic (shuffling prevents this).
           More comparisions than mergesort but, doesn't involve any data movement.. hence, faster.
           Inplace & unstable.
        */



        static void sort(Comparable[] a){
            knuth_shuffle(a);   //for picking efficient pivot.
            sort(a, 0, a.length-1);
        }

        static void sort(Comparable[] a, int lo, int hi){
            if(lo >= hi)    return;

            int k = partition(a, lo, hi);
            sort(a, 0, k-1);
            sort(a, k+1, hi);

        }
        static int partition(Comparable[] a, int lo, int hi){
            int i = lo, j = hi;

            while(true){
                while(less(a[i], a[lo]))
                    i++;
                
                while(less(a[lo], a[j]))
                    j--;
                
                if(i >= j) break;
                swap(a, i, j);

            }
            swap(a, lo, j);
            return j;
        }

    }

    static Comparable quick_select(Comparable[] a, int k){
        k--;
        knuth_shuffle(a);
        int lo = 0, hi = a.length - 1;
        while(lo < hi){
            int j = QuickSort.partition(a, lo, hi);
            if(j < k) lo = j + 1;
            else if(j > k) hi = j - 1;
            else return a[k];
        }

        return a[k];

    }
    
    public static void main(String args[]){
        Integer[] a = {1, 0, 2, 5, 7, -1, 3};
        //Sorting.QuickSort.sort(a);
        System.out.println(quick_select(a, 3));
       
    }


}