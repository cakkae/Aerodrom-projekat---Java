import java.util.*;
public class Zadatak {
private static Scanner unos;
public static void main(String[] args) {
unos = new Scanner(System.in);
int[] niz = new int[10];
System.out.println("Unesite broj A:");
int a = unos.nextInt(), i;
for(i=0;i<10;i++)
{
niz[i] = unos.nextInt();
if(niz[i] % a == 0) 
System.out.println(niz[i]);
}
}
}