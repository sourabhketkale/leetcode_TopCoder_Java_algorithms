package com.problems.miscellaneous;

public class Atoi {

public static int myAtoi(String str) {
        
        str = str.trim();
        char[] arr = str.toCharArray();
        long count = 0;
        int negative = 1;
        
        for(int i=0;i<arr.length;i++){
          if(i == 0 && arr[i] == '-') negative = -1;
          else if(i == 0 && arr[i] == '+') continue;
          else{
              if( arr[i]-'0' >= 0 && arr[i]-'0' <= 9 ) count = count*10 + arr[i] - '0';
              else break;
              if(count*negative < Integer.MIN_VALUE){ 
                    count=Integer.MIN_VALUE;
                    break;
              }    
              if(count*negative > Integer.MAX_VALUE){
                    count=Integer.MAX_VALUE;
                    break;    
              }
          }
        }

        if(negative == -1){
            return (int)count*-1;
        }
        return (int)count;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Atoi.myAtoi("1235"));
	}

}
