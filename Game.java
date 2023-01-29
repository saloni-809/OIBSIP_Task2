import java.util.*;

class Game
{
   
    public static void main(String args[])
    {
        int num=1+(int)(100*Math.random());
        int i, guess=0,trial=5;
        String play="yes";
        Scanner sc=new Scanner(System.in);
		while(play.equals("yes"))
		{
        for( i=0;i<trial;i++)
        {
            System.out.println("Guess the number between 1 to 100");
            guess=sc.nextInt();

            if(guess==num)
            {
                System.out.println("Congratulations you have found the number:"+num);
                System.out.println("Do you want to play again?");
				System.out.println("Type Yes or No");
				play=sc.next().toLowerCase();
				
            }
            else if(guess<num && i!=trial-1)
            {
                System.out.println("The number is greater than "+guess);
            }
            else if(guess>num && i!=trial-1)
            {
                System.out.println("The number is less than "+guess);
            }

		}
        
         if( i==trial && guess!=num)
            {
                System.out.println("All trials have finished......You lost!!");
                System.out.println("The number is:"+num);
				System.out.println("Do you want to play again?");
				System.out.println("Type Yes or No.");
				play=sc.next().toLowerCase();
                
            }
		
		}
    }
    
}