
package blackjack;
import java.util.Random;
import java.util.Scanner;


public class Game {

    public Player player_arr[]=new Player[4];
    private Card[] cardDeck=new Card[52];
    private static int max_score=0;
    private Card dealerHand[]=new Card[10];   
    private Card player1_hand[]=new Card[10];
    private Card player2_hand[]=new Card[10];
    private Card player3_hand[]=new Card[10];
    int x=0 ,y=0 ,z=0 ,w=0;
    Random rand=new Random();
    Scanner input=new Scanner(System.in);
    
    
    
    public void generateCards(){
        int z=0;
           for (int i=0;i<4;i++){
               for(int j=0;j<13;j++){
                int k;
                  if(j<10){
                      k=j+1;
                  }
                  else{
                      k=10;
                  }
                  Card c1 = new Card(i,j,k);
                  cardDeck[z]=c1;
                  z++;
               }
           }
        
    }
    
    public Card drawCard(){
        Card c2;
        
        while (true){
            int randomChoice=rand.nextInt(52);
            System.out.println(randomChoice);
            
                if(cardDeck[randomChoice]!=null){
                    c2=cardDeck[randomChoice];
                    cardDeck[randomChoice]=null;
                    break;
                }

        }
       
    
        return c2;
    }
    
    
    
    public void setInfo(){
        for (int i=0;i<3;i++){
            System.out.println("Player "+(i+1) +" name: ");
            String Name = input.next();
            player_arr[i]=new Player();
            player_arr[i].setName(Name);
   
        }
       
        
        System.out.println("Dealer name: ");
        String Name = input.next(); 
        player_arr[3]=new Player();
        player_arr[3].setName(Name);
        
        
        
        
        for(int i=0;i<2;i++){
           player1_hand[i]=drawCard();
           player2_hand[i]=drawCard();
           player3_hand[i]=drawCard(); 
           dealerHand[i]=drawCard();
        
        }
        
        for(int i=0;i<2;i++){
            player_arr[0].setArr(player1_hand,i);
            player_arr[1].setArr(player2_hand,i);
            player_arr[2].setArr(player3_hand,i); 
            player_arr[3].setArr(dealerHand,i);
        
        }
        
        
            for(int i=0;i<2;i++){

                x += player1_hand[i].getValue();
                player_arr[0].setScore(x);

                y += player2_hand[i].getValue();
                player_arr[1].setScore(y);

                z += player3_hand[i].getValue();
                player_arr[2].setScore(z);

                w += dealerHand[i].getValue();
                player_arr[3].setScore(w);

                updateScore();
                
            }
            
        
    
    }
    
    
    public void updateScore(){
        
        if(player_arr[0].getScore()>=player_arr[1].getScore())
        {
            if(player_arr[0].getScore()>=player_arr[2].getScore())
            {
                max_score=player_arr[0].getScore();
            }
            else
            {
                max_score=player_arr[2].getScore();
            }
        }else
        {
            if(player_arr[1].getScore()>=player_arr[2].getScore())
            {
                max_score=player_arr[1].getScore();
            }
        }
        
    }
    
    
   
    
    

    public int setPlayer1_hand(Card[] player1_hand,int i ) {
        this.player1_hand[i] = player1_hand[i];
        player_arr[0].setArr(player1_hand,i);
        

      
            int s=player_arr[0].getScore();
            s+=player1_hand[i].getValue();
            player_arr[0].setScore(s);
            System.out.println("player1 score: "+s);
            if(s<21){
            updateScore();
            }
            System.out.println("max"+max_score);
            
        
            return s;
    }
    
    
    

    public int setPlayer2_hand(Card[] player2_hand,int i) {
        this.player2_hand[i] = player2_hand[i];
         player_arr[1].setArr(player2_hand,i);
        

      
            int s=player_arr[1].getScore();
            s+=player2_hand[i].getValue();
            player_arr[1].setScore(s);
            System.out.println("player2 score: "+s);
            if(s<21){
            updateScore();
            }
            System.out.println(max_score);
        
            return s;
    }

    
    
    
    public int setPlayer3_hand(Card[] player3_hand,int i) {
        this.player3_hand[i] = player3_hand[i];
        player_arr[2].setArr(player3_hand,i);

         int s=player_arr[2].getScore();
            s+=player3_hand[i].getValue();
            player_arr[2].setScore(s);
            System.out.println("player3 score: "+s);
            if(s<21){
            updateScore();
            }
            System.out.println(max_score);
        
            return s;
    }

    public int setDealerHand(Card[] dealerHand ,int i) {
        this.dealerHand[i] = dealerHand[i];
        player_arr[3].setArr(dealerHand,i);
        
        int s=player_arr[3].getScore();
            s+=dealerHand[i].getValue();
            player_arr[3].setScore(s);
            System.out.println("Dealer score: "+s);
            
            return s;
        
        
    }

    public Player[] getPlayer_arr() {
        return player_arr;
    }

    public Card[] getCardDeck() {
        return cardDeck;
    }

    
    
    
    public static int getMax_score() {
        return max_score;
    }

    public int getDealerScore() {
        return player_arr[3].getScore();
    }

    public int getPlayer1Score() {
        return player_arr[0].getScore();
    }
    
    public int getPlayer2Score() {
        return player_arr[1].getScore();
    }
    
    public int getPlayer3Score() {
        return player_arr[2].getScore();
    }
    
    
    
    
    
    

    
    
    
    
    
    
    
}
