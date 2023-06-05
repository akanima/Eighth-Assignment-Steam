package Shared;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Scanner;

public class Request {
    public static String creatingReq(JSONObject response, Scanner sc){
        String typeOfReq=response.getString("type");
        if(typeOfReq.contains("create")){
            if(response.get("status").equals("approved")){
                return showUserMenu(response);
            } else if (response.get("status").equals("disapproved")) {
                System.out.println("this username already exists\ndo you want to try again? yes or no");
                if(sc.nextLine().equals("yes")){
                    return createAcc(sc);
                }
            }
            else {
                return showFirstMenu();
            }
        } else if (typeOfReq.contains("first")) {
            return firstMenuReqCreator(sc);
        } else if (typeOfReq.contains("user")) {
            return userMenuReqCreator(sc,response);
        } else if (typeOfReq.equals("login")) {
            if(response.get("status").equals("approved")){
                return showUserMenu(response);
            } else if (response.get("status").equals("disapproved")) {
                System.out.println("username or password is wrong\ndo you want to try again? yes or no");
                if(sc.nextLine().equals("yes"))
                    return login(sc);
            }
            else{
                return showFirstMenu();
            }
        } else if (typeOfReq.contains("available")) {
            return gameListReq(sc,response);
        }
        else if(typeOfReq.contains("info")){
            printInfo(response);
            System.out.println("do you want to download it? yes or no");
            if(sc.nextLine().equals("yes")){
                return downloadReq(response.getString("id"),response);
            }else {
                return showUserMenu(response);
            }
        }
        return null;
    }
    public static String createAcc(Scanner sc){
        JSONObject obj=new JSONObject();
        JSONObject userAtt=new JSONObject();
        obj.put("type","createAccount");
        System.out.println("please enter a username");
        String username=sc.nextLine();
        userAtt.put("username",username);
        System.out.println("please enter a password");
        String salt="$2a$10$tT242E7Kmnkg1JL3azdNA.";
        String pass=BCrypt.hashpw(sc.nextLine(),salt);
        userAtt.put("password",pass);
        System.out.println("please enter the year of your birth");
        int yearOfBirth= sc.nextInt();
        userAtt.put("yearOfBirth",yearOfBirth);
        obj.put("userAtt",userAtt);
        return obj.toString();
    }
    public static String showUserMenu(JSONObject response){
        JSONObject obj=new JSONObject();
        obj.put("type","userMenu");
        obj.put("userAtt", response.getJSONObject("userAtt"));
        return obj.toString();
    }
    public static String showFirstMenu(){
        JSONObject obj = new JSONObject();
        obj.put("type","firstMenu");
        return obj.toString();
    }
    public static String firstMenuReqCreator(Scanner sc){
        firstMenuPrinter();
        int choice=getInput(sc);
        switch (choice){
            case 1:
                return login(sc);
            case 2:
                return createAcc(sc);
            case 3:
                return logout();
        }
        return null;
    }

    private static void firstMenuPrinter() {
        System.out.println("        welcome to steam       ");
        System.out.println("       for login enter 1       ");
        System.out.println("for creating an account enter 2");
        System.out.println("    for logging out enter 3"    );
    }
    public static int getInput(Scanner sc){
        int choice=-1;
        while(choice<1 || choice>3){
            try{
                System.out.println("enter your choice: ");
                choice=Integer.parseInt(sc.nextLine());

            }
            catch(NumberFormatException e){
                System.out.println("invalid selection, try again");
            }

        }
        return choice;
    }
    public static String login(Scanner sc){
        JSONObject obj=new JSONObject();
        JSONObject userAtt=new JSONObject();
        obj.put("type","login");
        System.out.println("please enter your username");
        String username= sc.nextLine();
        userAtt.put("username",username);
        System.out.println("please enter your password");
        String salt="$2a$10$tT242E7Kmnkg1JL3azdNA.";
        String pass= BCrypt.hashpw(sc.nextLine(),salt);
        userAtt.put("password",pass);
        obj.put("userAtt",userAtt);
        return obj.toString();
    }
    private static String logout(){
        JSONObject obj=new JSONObject();
        obj.put("type","logout");
        return obj.toString();
    }
    public static String userMenuReqCreator(Scanner sc, JSONObject response){
        printUserMenu();
        int choice=getInput(sc);
        switch (choice){
            case 1:
                return viewAvailableGamesReq(response);
            case 2:
                return viewInfoAboutGameReq(response,sc);
            case 3:
                return logout();
        }
        return null;
    }
    public static String viewAvailableGamesReq(JSONObject response){
        JSONObject obj=new JSONObject();
        obj.put("type","availableGames");
        obj.put("userAtt",response.getJSONObject("userAtt"));
        return obj.toString();
    }
    public static String viewInfoAboutGameReq(JSONObject response,Scanner sc){
        JSONObject obj=new JSONObject();
        obj.put("type","Info");
        obj.put("userAtt",response.getJSONObject("userAtt"));
        System.out.println("please enter name of the game you are looking for");
        obj.put("title",sc.nextLine());
        return obj.toString();
    }

    private static void printUserMenu() {
        System.out.println("for viewing list of available games enter 1");
        System.out.println("for searching info about a specific game enter 2");
        System.out.println("for logging out enter 3");
    }
    public static void printInfo(JSONObject response){
        JSONObject info=response.getJSONObject("Info");
        System.out.println("name: " + info.getString("title"));
        System.out.println("developer: " + info.getString("developer"));
        System.out.println("genre: " + info.getString("genre"));
        System.out.println("price: " + info.getString("price"));
        System.out.println("release year: " + info.getString("release_year"));
        System.out.println("controller support: " + info.getString("controller_support"));
        System.out.println("reviews: " + info.getString("reviews"));
        System.out.println("size: " + info.getString("size"));
    }
    public static String downloadReq(String gameId,JSONObject response){
        JSONObject obj=new JSONObject();
        obj.put("type","download");
        obj.put("id",gameId);
        obj.put("userAtt",response.getJSONObject("userAtt"));
        return obj.toString();
    }
    public static String gameListReq(Scanner sc,JSONObject response){
        JSONArray games = response.getJSONArray("games");
        JSONArray gameIds=response.getJSONArray("gameIds");
        ArrayList<String> ids=new ArrayList<>();
        if(games!=null){
            for (int i=0 ; i<games.length(); i++){
                System.out.println(i+1+"."+games.get(i));
            }
        }
        if(gameIds!=null){
            for(int i=0 ; i<gameIds.length(); i++){
                ids.add(String.valueOf(gameIds.get(i)));
            }
        }
        System.out.println("do you want to choose a game? yes or no");
        if (sc.nextLine().equals("yes")){
            System.out.println("insert a number");
            String gameId = ids.get(Integer.parseInt(sc.nextLine()) - 1);
            System.out.println("what do you want to do with it?" );
            System.out.println("1.view details\n2.download");
            switch (Integer.parseInt(sc.nextLine())){
                case 1:
                    return viewDetailRequest(gameId,response);

                case 2:
                    return downloadReq(gameId,response);
            }
        }

        else{
            return showUserMenu(response);
        }

        return null;
    }
    public static String viewDetailRequest(String gameId,JSONObject response){
        JSONObject obj=new JSONObject();
        obj.put("type","view detail");
        obj.put("gameId",gameId);
        obj.put("userAtt",response.getJSONObject("userAtt"));
        return obj.toString();
    }

}
