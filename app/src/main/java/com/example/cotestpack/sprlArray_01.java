import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        //System.out.println(sc.next());

        int param = 0;
        boolean chk = false;
        int[][] rslt = {};
        
        if(sc != null){
            String text = sc.next();

            for(int i=0; i<text.length(); i++){
                String num = text.substring(i,i+1);
                if(!numTypeChk(num)){
                    //System.out.println("Number type ERROR"+num);
                    chk = true;
                    break;
                }
            }

            if(!chk){
                rslt = mainTest(text);
            
            }else{
                 System.out.println("Number type ERROR");
            }
            
            displayAnswer(rslt);
        }else{
            System.out.println("no data");
        }
        

    }

    //숫자 타입 체크. 타입변환 에러 대비
    public static boolean numTypeChk (String num){
        boolean rslt = false;
        String[] ztn = {"0","1","2","3","4","5","6","7","8","9"};
        int sz = ztn.length;

        for(int i=0; i<sz; i++){
            if(ztn[i].equals(num)){
                System.out.println("chk : "+ztn[i]);
                rslt=true;
                break;
            }            
        }
        
        return rslt;
    }

    //메인 test
    public static int[][] mainTest (String num){
        int n = Integer.parseInt(num);
        int[][] arr = new int[n][n];
        int rowStr = 0;
        int rowEnd = n;
        int colStr = 0;
        int colEnd = n;
        
        for(int i=1; i<(n*n)+1; i+=0){   
            
            for(int j=colStr; j<colEnd; j++){
                arr[rowStr][j] = i++;
            }//for j
            rowStr++;
             //System.out.println("1"+Arrays.deepToString(arr));

            for(int s=rowStr; s<rowEnd; s++){
                arr[s][colEnd-1] = i++;
            }//for s
            colEnd--;
             //System.out.println("2"+Arrays.deepToString(arr));

            for(int j=colEnd-1; j>=colStr; j--){
                arr[rowEnd-1][j] = i++;
            }//for j
            rowEnd--;
             //System.out.println("3"+Arrays.deepToString(arr));

            for(int s=rowEnd-1; s>=rowStr; s--){
                arr[s][colStr] = i++;
            }//for s
            colStr++;
             //System.out.println("4"+Arrays.deepToString(arr));
            
        } //for i

        //System.out.println(Arrays.deepToString(arr));
        return arr;
    }

    //화면에 값 찍기
    public static void displayAnswer (int[][] answer){
        int[][] arr = answer;
        int sz = arr.length;

        System.out.println(Arrays.deepToString(arr));

        for (int i=0;i<sz; i++) {
            for(int j=0;j<sz; j++){
                 System.out.print(arr[i][j]+" "); 
            }
            System.out.println("");
        }
        
    }

}