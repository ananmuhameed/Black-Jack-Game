
package blackjack;
import java.util.Scanner;


public class BlackJack 
{
    
   static Game g1 =new Game();
   static BlackJack b1=new BlackJack();
   Scanner input=new Scanner(System.in);
   static GUI gui = new GUI();

    
    public static void main(String [] args){
        g1.generateCards();
        g1.setInfo();
        gui.runGUI( g1.getCardDeck(), g1.player_arr[0].getArr(), g1.player_arr[1].getArr(), g1.player_arr[2].getArr(), g1.player_arr[3].getArr() );
        b1.startGame();
        b1.decision();
        
        
       
    }
    
    
    public void startGame(){
        player1();
        player2();
        player3();
        dealer();
        
    }
    
    
    
    
    public void player1(){
       Card g;
        Card arr[]=new Card[6];
        int i=2;
        int limit;

        while(true)
        {
            System.out.println("player1");
          System.out.println("Hit or Stand");
          char ans=input.next().charAt(0);

          if(ans=='s')
          {
              break;
          }
          
            g=g1.drawCard();
            arr[i]=g;
            limit=g1.setPlayer1_hand(arr,i);
            gui.updatePlayerHand(g,0);
           if(limit>21){
               System.out.println("player1 busted");
               break;
           } 
           else if(limit==21){
                System.out.println("BlackJack");
               break;
           }
            i++;
            
        }
    }
        
        
        
      public void player2(){
       Card g;
        Card arr[]=new Card[6];
        int i=2;
        int limit;

        while(true)
        {
            System.out.println("player2");
          System.out.println("Hit or Stand");
          char ans=input.next().charAt(0);

          if(ans=='s')
          {
              break;
          }

            g=g1.drawCard();
            arr[i]=g;
            limit=g1.setPlayer2_hand(arr,i);
            gui.updatePlayerHand(g,1);
           if(limit>21){
               System.out.println("player2 busted");
               break;
           } 
           else if(limit==21){
                System.out.println("BlackJack");
               break;
           }
            i++;
            
        }
        
      } 
        
       public void player3(){
       Card g;
        Card arr[]=new Card[6];
        int i=2;
        int limit;
        
        while(true)
        {
            System.out.println("player3");
          System.out.println("Hit or Stand");
          char ans=input.next().charAt(0);

          if(ans=='s')
          {
              
              break;
          }

            g=g1.drawCard();
            arr[i]=g;
            limit=g1.setPlayer3_hand(arr,i);
            gui.updatePlayerHand(g,2);
           if(limit>21){
               System.out.println("player3 busted");
               break;
           } 
           else if(limit==21){
                System.out.println("BlackJack");
               break;
           }
            i++;
            
        }
        
      }
       
       public void dealer(){
        Card g;
        Card arr[]=new Card[6];
        int i=2;
        int limit;

        
            while(g1.getDealerScore()<=Game.getMax_score())
            {
                if(Game.getMax_score()!=21)
                {
                    g=g1.drawCard();
                    arr[i]=g;
                    limit=g1.setDealerHand(arr,i);
                    gui.updateDealerHand(g,g1.getCardDeck());
                    if(limit>21)
                    {
                        System.out.println("Dealer Busted");
                        break;
                    }
                }
            }
       }
       
       
       public void decision(){
           
            if(g1.player_arr[0].getScore()==Game.getMax_score()){
                if(g1.player_arr[0].getScore()==g1.player_arr[1].getScore() || g1.player_arr[0].getScore()==g1.player_arr[2].getScore()|| g1.player_arr[0].getScore()==g1.player_arr[3].getScore()){
                    System.out.println("PUSH");
                }else{
                    System.out.println("Player 1 won");
                }
           }else if(g1.player_arr[1].getScore()==Game.getMax_score()){
                if(g1.player_arr[1].getScore()==g1.player_arr[0].getScore() || g1.player_arr[1].getScore()==g1.player_arr[2].getScore()|| g1.player_arr[1].getScore()==g1.player_arr[3].getScore()){
                    System.out.println("PUSH");
                }else{
                    System.out.println("Player 2 won");
                }
           }else if(g1.player_arr[2].getScore()==Game.getMax_score()){
                if(g1.player_arr[2].getScore()==g1.player_arr[0].getScore() || g1.player_arr[2].getScore()==g1.player_arr[1].getScore()|| g1.player_arr[2].getScore()==g1.player_arr[3].getScore()){
                    System.out.println("PUSH");
                }else{
                    System.out.println("Player 3 won");
                }
           }else if(g1.player_arr[3].getScore()==Game.getMax_score()){
                if(g1.player_arr[3].getScore()==g1.player_arr[0].getScore() || g1.player_arr[3].getScore()==g1.player_arr[1].getScore()|| g1.player_arr[3].getScore()==g1.player_arr[2].getScore()){
                    System.out.println("PUSH");
                }else{
                    System.out.println("Dealer won");
                }
           }
           
           
       }
        
        
    
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        
    }
       
    

    
    
    
    
    
    
    
    

    
    
       
    

