package Client;
import Shared.Request;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientMain {
    private static final String Server_IP="127.0.0.1";
    private static final int Server_Port=8888;
    public static Scanner sc=new Scanner(System.in);
    public static boolean allowance=false;


    public static void main(String[] args)throws IOException {
        Socket socket=new Socket(Server_IP,Server_Port);
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response=null;
        while ((response=reader.readLine())!=null){
            if(!response.equals(null)){
                String request=Request.creatingReq(new JSONObject(response),sc);
                out.println(request);
            }
        }
        socket.close();
        System.exit(0);
    }
}
