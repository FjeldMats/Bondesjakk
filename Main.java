
import java.util.Scanner;

public class Main {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Brett brett1 = new Brett();
		
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv inn spillernes navn:");
		System.out.print("1: ");
		String p1 = scan.nextLine();
		System.out.print("2: ");
		String p2 = scan.nextLine();
		
		String[] players = new String[2];
		char[] type = new char[2];
		
		players[0] = p1;
		type[0] = 'X';
		players[1] = p2;
		type[1] = 'O';
		
		
		
		int ind = 0;
		
		while(running == true) {
			System.out.println("");
			brett1.skrivUt();
			
			System.out.println(players[ind] + " det er din tur" + "( "+ type[ind]+" )");
			System.out.print("velg rad: ");
			String rad = scan.nextLine();
			System.out.print("velg kolonne: ");
			String col = scan.nextLine();
			
			if(brett1.leggTilCelle( rad.charAt(0), Integer.parseInt(col), type[ind]) == true) {
				if(brett1.checkDiagonal(type[ind]) || brett1.checkHorAndVer(type[ind])){
					running = false;
					brett1.skrivUt();
					System.out.println(players[ind] + " vinner med " + type[ind]);
				}else {
					if(brett1.checkIfFull()) {
						System.out.println("ingen vinner - brettet er fult");
						running = false;
					}
					ind = nextPlayer(ind);
				}
			}else {
				System.out.println(rad + " - " + col + " er ikke gyldig, prov igjen");
			}
		}
		
	}
	
	public static int nextPlayer(int ind) {
		if(ind == 1) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
