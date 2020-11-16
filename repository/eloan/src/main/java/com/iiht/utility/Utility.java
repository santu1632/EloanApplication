package com.iiht.utility;
/*This class is used to handle utility functions */

public class Utility {
	
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

	
	public static void main(String a[])
	{
		String usernam = "";
		System.out.println(isNullOrEmpty(usernam));
	}
}
