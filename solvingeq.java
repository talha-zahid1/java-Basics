/*Problem Statement:
Write a Java program that uses the bisection method to find a root of the quadratic equation  within a given interval . The program should repeatedly bisect the interval until the approximate root is found. */
import java.util.Scanner;

public class solvingeq {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float a,b,c;
        System.out.println("Enter a ");
        a=sc.nextFloat();
        System.out.println("Enter b ");
        b=sc.nextFloat();
        //to calculate midpoint
        c=(a+b)/(float)2;
        System.out.println("C"+c);
        float x=0;
        float y=(x*x)-5*x+6;
        float ya=0,yb=0,yc=0;
        ya=(a*a)-5*a+6;
        yb=(b*b)-5*b+6;
        yc=(c*c)-5*c+6;
        while (!(Math.abs(ya)<0.00001 || Math.abs(yb)<0.00001 || Math.abs(yc)<0.00001)) {
            if (ya>0 && yc>0) {
                a=c;
                c=(a+b)/2;
            }else if (yb>0 && yc>0) {
                b=c;
                c=(a+b)/2;                
            }
        ya=(a*a)-5*a+6;
        yb=(b*b)-5*b+6;
        yc=(c*c)-5*c+6;
        }
        if (Math.abs(ya)<0.00001) {
            System.out.println("The Solution of equation exists at point a = "+a );
        }else if (Math.abs(yb)<0.00001) {
            System.out.println("The Solution of equation exists at point b = "+b );
        }else if (Math.abs(yc)<0.00001) {
            System.out.println("The Solution of equation exists at point c = "+c );
        }
    }
}