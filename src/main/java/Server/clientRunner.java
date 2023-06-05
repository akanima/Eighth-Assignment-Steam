package Server;
import Shared.Response;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class clientRunner implements Runnable{
    Socket Client;
    private BufferedReader in;
    private PrintWriter out;
    public clientRunner(Socket clientSocket)throws IOException {
        this.Client=clientSocket;
        in=new BufferedReader(new InputStreamReader(Client.getInputStream()));
        out=new PrintWriter(Client.getOutputStream(),true);
    }
    @Override
    public void run()  {
        out.println(Response.firstMenuRes());
        String request;
        try{
            while ((request=in.readLine())!=null) {
                if(!request.equals(null)) {
                    JSONObject req=new JSONObject(request);
                    if(req.getString("type").equals("logout")){
                        Client.close();
                    }
                    String response=Response.creatingRes(req);
                    out.println(response);
                }
            }

        }catch (IOException e){

        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
