package Shared;

import Client.User;
import Server.ServerMain;
import org.json.JSONArray;
import org.json.JSONObject;


import java.sql.*;

public class Response {
    public static String creatingRes(JSONObject request){
        String type=request.getString("type");
        if(type.equals("createAccount")){
            return createAccRes(request);
        }
        else if(type.equals("login")){
            return loginRes(request);
        } else if (type.equals("firstMenu")) {
            return firstMenuRes();
        } else if (type.equals("userMenu")) {
            return userMenuRes(request);
        } else if (type.equals("availableGames")) {
            return viewAvailableGamesRes(request);
        }else if(type.equals("Info")){
            return viewInfoRes(request);
        } else if (type.equals("download")) {
           // return downloadRes(request);
        }
        return null;
    }
    public static String  viewInfoRes(JSONObject request){
        String title=request.getString("title");
        JSONObject obj=new JSONObject();
        obj.put("type","Info");
        obj.put("title",title);
        obj.put("userAtt",request.getJSONObject("userAtt"));
        JSONObject Info=new JSONObject();
        for(int i=0; i<ServerMain.games.size(); i++){
            if(ServerMain.games.get(i).getTitle().equals(title)){
                Info.put("title",title);
                Info.put("developer",ServerMain.games.get(i).getDeveloper());
                Info.put("genre",ServerMain.games.get(i).getGenre());
                Info.put("price",ServerMain.games.get(i).getPrice());
                Info.put("release_year",ServerMain.games.get(i).getReleaseYear());
                Info.put("controller_support",ServerMain.games.get(i).getControllerSupport());
                Info.put("reviews",ServerMain.games.get(i).getReviews());
                Info.put("size",ServerMain.games.get(i).getSize());
            }
        }
        obj.put("Info",Info);
        return obj.toString();
    }
    public static String viewAvailableGamesRes(JSONObject request){
        JSONObject obj=new JSONObject();
        obj.put("userAtt",request.getJSONObject("userAtt"));
        obj.put("type","availableGames");
        JSONArray games=new JSONArray();
        JSONArray gameIds=new JSONArray();
        for(int i=0 ; i<ServerMain.games.size(); i++){
            games.put(ServerMain.games.get(i).getTitle());
        }
        for (int i=0 ; i<ServerMain.games.size(); i++){
            gameIds.put(ServerMain.games.get(i).getId());
        }
        obj.put("gameIds",gameIds);
        obj.put("games",games);
        return obj.toString();
    }
    public static String userMenuRes(JSONObject request){
        JSONObject obj = new JSONObject();
        obj.put("type","userMenu");
        obj.put("userAtt",request.getJSONObject("userAtt"));
        return obj.toString();
    }
    public static String firstMenuRes(){
        JSONObject obj=new JSONObject();
        obj.put("type","firstMenu");
        return obj.toString();
    }
    public static String loginRes(JSONObject request){
        JSONObject obj=new JSONObject();
        obj.put("type","login");

        if(checkingUsernameAndPassword(request)){
            obj.put("status","approved");
        }else {
            obj.put("status","disapproved");
        }
        obj.put("userAtt",request.getJSONObject("userAtt"));
        return obj.toString();
    }
    public static String createAccRes( JSONObject request){
        JSONObject obj=new JSONObject();
        if(!checkingUsername(request)){
            addingNewUsersToDataBase(request);
            obj.put("status","approved");

        }
        else {
            obj.put("status","disapproved");
        }
        obj.put("type","createAccount");
        obj.put("userAtt",request.getJSONObject("userAtt"));
        return obj.toString();
    }
    public static boolean checkingUsername(JSONObject request){
        JSONObject userAtt=request.getJSONObject("userAtt");
        String username=userAtt.getString("username");
        for(int i = 0; i< ServerMain.users.size(); i++){
            if(username.equals(ServerMain.users.get(i))){
                return true;
            }
        }
        return false;
    }
    public static void addingNewUsersToDataBase(JSONObject request){
        JSONObject userAtt=request.getJSONObject("userAtt");
        String pass=userAtt.getString("password");
        User user=new User(userAtt.getString("username"),pass,userAtt.getInt("yearOfBirth"));
        try{
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/steam","root","nima1383");
            String sql = " insert into users (username, password, yearOfBirth)" + " values (?, ?, ?)";
            PreparedStatement stat=connection.prepareStatement(sql);
            stat.setString(1, user.getUsername());
            stat.setString(2, user.getPassword());
            stat.setInt(3,user.getYearOfBirth());
            stat.executeUpdate();
            connection.close();
        }catch (SQLException e){
        }
    }
    public static boolean checkingUsernameAndPassword(JSONObject request){
        JSONObject userAtt=request.getJSONObject("userAtt");
        for(int i=0 ; i<ServerMain.users.size(); i++){
            if(userAtt.getString("username").equals(ServerMain.users.get(i)) && userAtt.getString("password").equals(ServerMain.users.get(i))){
                return true;
            }
        }
        return false;
    }

}
