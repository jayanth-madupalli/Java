import java.util.Scanner;
public class SearchAlgos{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int a[] = {11, 20, 35, 42, 51, 67};
        System.out.print("Enter element: ");
        int k = sc.nextInt();
        int pos = rec_bsearch(a, 0, a.length-1, k);

        if(pos == -1)
            System.out.println("Element not found.");
        else
            System.out.println("Element found at position: "+(pos+1));

        sc.close();
    }

    static int  bsearch(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high)/2;

        int f = 0;

        while(low <= high){
            if(arr[mid] > k)
                high = mid -1;
            else if(arr[mid] < k)
                low = mid + 1;
            else{ 
                f = 1;
                break;
            }

            mid = (low + high)/2;
        }

        if(f == 0)
            return -1;
        else
            return mid;
    }

    static int rec_bsearch(int arr[], int l, int h, int k){
        if(l > h)
            return -1;

        int mid = (l+h)/2;

        if(arr[mid] > k)
            return rec_bsearch(arr, l, mid-1, k);
        else if(arr[mid] < k)
            return rec_bsearch(arr, mid+1, h, k);
        else
            return mid;
    }

    static int lsearch(int arr[], int k){
        for(int i=0;i<arr.length;i++)
            if(arr[i] == k)
                return i+1;
        return -1;
    }
}
