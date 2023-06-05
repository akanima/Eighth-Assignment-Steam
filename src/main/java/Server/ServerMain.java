package Server;
import Client.User;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ServerMain {
    private static final int portNo=8888;
    public static ArrayList<User> users=new ArrayList<>();
    public static ArrayList<Game> games=new ArrayList<>();
    static String url="jdbc:mysql://localhost:3306/steam";
    static String username="root";
    static String password="nima1383";
    private static ArrayList<clientRunner> clients=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        loadingUsers();
        loadingGameData();
        ServerSocket listener = new ServerSocket(portNo);
        while(true) {
            System.out.println("[SERVER] waiting for client....");
            Socket client = listener.accept();
            System.out.println("[SERVER] connected to client");
            clientRunner clientThread=new clientRunner(client);
            clients.add(clientThread);
            new Thread(clientThread).start();
        }
    }
    public static void loadingUsers(){
        try{
            con= DriverManager.getConnection(url,username,password);
            Statement stat= con.createStatement();
            ResultSet resultSet=stat.executeQuery("select * from users");
            while (resultSet.next()){
                User user=new User(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3));
                users.add(user);
            }
            con.close();
            stat.close();
        }catch (SQLException e){
            System.out.println("m");
        }
    }
    public static void loadingGameData(){
        try{
            con=DriverManager.getConnection(url,username,password);
            Statement statement= con.createStatement();
            ResultSet rs=statement.executeQuery("select * from gamedata");
            while (rs.next()){
                Game availableGame=new Game(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
                games.add(availableGame);
            }
        }catch (SQLException e){}
    }
    static Connection con=null;
}
