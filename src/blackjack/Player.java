
package blackjack;


public class Player {
    
    private String Name;
    private int Score;
    public Card arr[]=new Card[11];
    private boolean blackjack;
    private boolean lost;

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setScore(int Score) {
        if(Score<=21){
        this.Score = Score;
        }
    }

    public void setArr(Card[] arr,int i) {
        this.arr[i] = arr[i];
        System.out.println(arr[i].getSuit() +","+ arr[i].getRank() +","+ arr[i].getValue());
    }
    

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public Card[] getArr() {
        return arr;
    }

    
    
    

    

    


    
}
