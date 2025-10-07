import java.util.Scanner;
public class LCS{
    static char[] lcs(String s1, String s2){
        char[][] pos = new char[s1.length()+1][s2.length()+1];
        int[][] arr = new int[s1.length()+1][s2.length()+1];
        for(int i =0; i<=s2.length(); i++){
            pos[0][i] = 'E';
            arr[0][i] = 0;
        }
        for(int j =0; j<=s1.length(); j++){
            pos[j][0] = 'E';
            arr[j][0] = 0;
        }
        for(int i =0; i<s2.length(); i++){
            for(int j =0; j<s1.length(); j++){
                if(s1.charAt(j) == s2.charAt(i)){
                    pos[j+1][i+1] = 'S';
                    arr[j+1][i+1] = arr[j][i] + 1; 
                }
                else{
                    if(arr[j+1][i] > arr[j][i+1]){
                        arr[j+1][i+1] = arr[j+1][i];
                        pos[j+1][i+1] = 'U';
                    }
                    else{
                        arr[j+1][i+1] = arr[j][i+1];
                        pos[j+1][i+1] = 'L';
                    }
                }
            }
        }
        char[] res = new char[arr[s1.length()][s2.length()]];
        int i = res.length-1;
        int[] ptr = {s1.length(),s2.length()};
        while(arr[ptr[0]][ptr[1]] != 0){
            if(pos[ptr[0]][ptr[1]] == 'S'){
                res[i] = s1.charAt(ptr[0]-1);
                ptr[0]--;
                ptr[1]--;
                i--;
            }
            else{
                if(pos[ptr[0]][ptr[1]] == 'L'){
                    ptr[0]--;
                }
                else{
                    ptr[1]--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String s1, s2;
        System.out.print("Enter string 1 : ");
        s1 = sc.next(); 
        System.out.print("Enter string 2 : ");
        s2 = sc.next();
        char[] res = lcs(s1, s2);
        System.out.print("The Lowest common subsequence is : ");
        for(int i =0; i<res.length; i++){
            System.out.print(res[i]);
        }
    }
}
