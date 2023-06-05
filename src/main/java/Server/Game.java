package Server;

public class Game {
    private int id;
    private String title;
    private String developer;
    private String genre;
    private double price;
    private int releaseYear;
    private int controllerSupport;
    private int reviews;
    private int size;
    private String filePath;

    public Game(int id,String title, String developer,String genre,double price,int releaseYear,int controllerSupport,int reviews,int size,String filePath){
        this.id=id;
        this.title=title;
        this.developer=developer;
        this.genre=genre;
        this.price=price;
        this.releaseYear=releaseYear;
        this.controllerSupport=controllerSupport;
        this.reviews=reviews;
        this.size=size;
        this.filePath=filePath;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public String getDeveloper() {
        return developer;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public void setControllerSupport(int controllerSupport) {
        this.controllerSupport = controllerSupport;
    }
    public int getControllerSupport() {
        return controllerSupport;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    public int getReviews() {
        return reviews;
    }
}

