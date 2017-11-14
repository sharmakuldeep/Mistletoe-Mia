package com.sharma.test;

public class Demo {

	public static void main(String ar[]) {
		//onceInArray();
		String s = "pppssssp";
		reducedString(s);
	}

	public static void onceInArray() {
		int arr[] = { 1, 2, 1, 3, 2, 3, 4, 7, 2, 4 };

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					temp++;
				}

			}
			if (temp == 0) {
				System.out.println("This is the element " + arr[i]);
				break;
			}

		}
	}
	
	public static void reducedString(String s){
	//	String s = "abbacdce"; cdce
		if(s.length()==0){
			System.out.println("Last string is blank");
		}
		else if(s.length()==1){
			System.out.println("Out String:"+s);
		}
		else{
			StringBuffer sb = new StringBuffer();
			
			
			
			for(int i=0;i<s.length();){
				int temp=0;
			
				for(int j=i;j<s.length();j++){
					if(s.charAt(i)==s.charAt(j)){
						temp++;
					}
					else{
						break;
					}
				}
				if(temp%2==0){
					
				}
				else{
					sb.append(s.charAt(i));					
				}
				i=i+temp;
			}
			System.out.println("out string from loop "+sb);
			
			if(s.equals(sb.toString())){
				System.out.println("Output String:  "+sb);
			}
			else{
				reducedString(sb.toString());
			}
		}
	}
}