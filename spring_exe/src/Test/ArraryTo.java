package Test;

import java.util.ArrayList;
import java.util.List;

public class ArraryTo {
		static int[][] array=new int[4][10];
		static{
			for(int i=0;i<4;i++){
				for(int j=0;j<10;j++){
					array[i][j]=(i+1)*10+j+1;
				}
			}
			
		}
		public static int GetRowColData(int n,int m){
			
			return array[n-1][m-1];
		}
	public static void main(String[] args){
		System.out.println( GetRowColData(3,4));
	}
}

 
	