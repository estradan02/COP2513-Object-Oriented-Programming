package Game;
import java.util.Scanner;

public class Winner {
	
	static Player[] players;
	static int num_players;
	
	public static void main(String[] args) {
		
		num_players = init_game();
		find_winner(players, num_players);
	}
	
	public static int init_game() {		
		Scanner user_input = new Scanner(System.in);
		boolean isNumber;
	
		System.out.print("How many players will be playing? (Enter a number) ");	
	
	do {	
		if(user_input.hasNextInt()) {
			num_players = user_input.nextInt();
			isNumber = true;
		}else {
			System.out.println("Invalid Format: Enter A Number");
			isNumber = false;
			user_input.next();
		}
	} while (!(isNumber)); 
		players = new Player[num_players];
		
		for(int i = 0; i < num_players; i++)
		{
			players[i] = new Player(i+1, Math.random());
		}
		
		System.out.println("Players:\n");
		
		for(int i = 0; i < num_players; i++)
		{
			System.out.printf("Player ID: %d, Value %.2f\n",  players[i].getId(), players[i].getVal());
			
		}
			
		return num_players;
	}
	
	public static void find_winner(Player[] players, int num_players) {
		int i, n = 0;
		
		for(i = 1; i < num_players; i++) 
		{
			if(players[i].getVal() > players[n].getVal())
			{
				n = i;
			}
		}
		
		System.out.printf("The Winner is...Player ID: %d, With a Value of %.2f!!!", players[n].getId(), players[n].getVal());
	}

}
