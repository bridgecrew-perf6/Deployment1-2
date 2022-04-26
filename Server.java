package module11;

import java.io.*;
import java.net.*;
public class Server {
   public static String isPrime(int num) {
       if(num<2) {
           return "No";
       }
       int i=2;
       while(i<num) {
           if(num%i==0) {
               return "No";
           }
           i++;
       }
       return "Yes";      
   }
   public static void main(String[] args){
       try{
           ServerSocket serverSocket=new ServerSocket(8080);
           
           //establishes connection
           
           Socket socket =serverSocket.accept();
           
           DataInputStream inputStream=new DataInputStream(socket.getInputStream());
           DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());

           int num = (int)inputStream.readInt();
           
           // CALLING FUNCTION AND
           // WRITING RETURN VALUE TO CLIENT
           
           outputStream.writeUTF(isPrime(num));
           outputStream.flush();

           outputStream.close();
           serverSocket.close();
       }
       catch(Exception e){
           System.out.println(e);
       }
   }
}