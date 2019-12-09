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
        int n = arr.length;
        for(int i = 1; i < n; i++)
            for(int j = i; j > 0 && less(arr[j], arr[j-1]); j--)
                    swap(arr, j, j-1);
    }

    public static void shell_sort(Comparable[] arr){
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
            merge(a, aux, lo, mid, hi);
        }
        static void sort(Comparable[] a){
            Comparable aux[] = new Comparable[a.length];
            sort(a, aux, 0, a.length-1);
        }
    }
    
    public static void main(String args[]){
       
    }


}