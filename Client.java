package module11;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       try{
           Socket socket=new Socket("localhost",8080);
           
           DataInputStream inputStream=new DataInputStream(socket.getInputStream());
           DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());

           // USER INPUT
           System.out.print("\nEnter a Number : ");
           int num = scan.nextInt();
           
           // WRITING INTEGER TO SERVER
           
           outputStream.writeInt(num);
           String ans = (String)inputStream.readUTF();
           System.out.println("Is number "+num+
                   " a prime number: "+ans);
           outputStream.flush();
           outputStream.close();
           socket.close();
       }
       catch(Exception e){
           System.out.println(e);
       }
       scan.close();
   }
}