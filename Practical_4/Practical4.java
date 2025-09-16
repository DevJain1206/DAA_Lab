import java.util.Scanner;

public class Practical4{
    static int MaxSum(int low, int high, int [] arr){
        if(low == high){
            return high;
        }
        else{
            int l_s = MaxSum(low, (low + high)/2, arr);
            int r_s = MaxSum((low + high)/2 + 1, high, arr);
            int c_s = MaxCrossing(low, (low + high)/2, high, arr);
            return Math.max(l_s, Math.max(c_s, r_s));
        }
    }
    static int MaxCrossing(int low, int mid, int high, int [] arr){
        int sum = 0;
        int lSum = Integer.MIN_VALUE;
        for(int i = mid; i>= low; i--){
            sum+= arr[i];
            if(sum > lSum){
                lSum = sum;
            }
        }
        sum = 0;
        int rSum = Integer.MIN_VALUE;
        for(int i = mid + 1; i < high+1; i++){
            sum+= arr[i];
            if(sum > rSum){
                rSum = sum;
            }
        }
        return lSum + rSum ;
    }
    public static void main(String[] args) {
        System.out.print("Enter the length of the array : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.print("Enter the array : ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int MaximumSum = MaxSum(0, n-1, arr);
        System.out.println("The maximum sum will be : " + MaximumSum);
    }
}
