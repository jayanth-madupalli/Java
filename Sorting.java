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
            for(int j = i; j > 0; j--)
                if(less(arr[j], arr[j-1]))
                    swap(arr, j, j-1);
                else 
                    break;
    }


    public static void main(String args[]){
        Integer[] a = {3, 2, 1, 6, 1, 8};
        Sorting.insertion_sort(a);

        for(Integer i:a)
            System.out.println(i);
    }


}