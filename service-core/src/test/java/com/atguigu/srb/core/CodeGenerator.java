package com.atguigu.srb.core;

import org.junit.Test;

public class CodeGenerator {

    @Test
    public void genCode() {
        int i= reverse(-2147483648);
        System.out.println(i);
        //System.out.println(convert("PAYPALISHIRING",4));
    }
    public String convert(String s, int numRows) {
        StringBuffer newString =new StringBuffer();
        if (s.length()==1 || numRows==1)
        {
            return s;
        }
        for (int i =0;i<numRows;i++)
        {
            int seq= (numRows-i-1)*2;

            if (seq==0){
                seq=(numRows -1)*2;
            }

            for(int j=i;j<s.length();j=j+seq){
                newString.append(s.charAt(j));
                if (seq !=(numRows -1)*2){
                    seq =(numRows -1)*2-seq;
                }
            }

        }
        return newString.toString();
    }


    public int reverse(int x) {
        String a = x+"";
        String b="";
        int start=0;
        boolean isZero=false;
        if (x==0){
            return x;
        }
        if (a.charAt(0)=='-'){
            start=1;
            b="-";
        }

        for(int i=a.length()-1;i>=start;i--)
        {
            if (a.charAt(i)=='0' && (i==a.length()-1 || isZero)){
                isZero=true;
                continue;
            }
            isZero=false;
            b +=a.charAt(i);
        }
        long c = Long.parseLong(b);
        long d = c>=Math.pow(-2,31)?c:0;
        d = c<=(Math.pow(2,31)-1)?c:0;
        return (int)d;
    }
}
