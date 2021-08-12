public class Player {
    private String name;
    private int bestScore = 0;
    public Player (String name){
        this.name = name;
    }
    public Player(){
        this.name = "";
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getBestScore(){
        return this.bestScore;
    }
    public void setBestScore(int newBestScore){
        this.bestScore = newBestScore;
    }
    
}
