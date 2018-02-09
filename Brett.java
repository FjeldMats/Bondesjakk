import java.util.Arrays;
import java.util.List;

public class Brett {
	
	Celle[][] brett;
	
	public Brett() {
		
		brett = new Celle[3][3];
		
		for(int i = 0; i<brett.length;i++) {
			for(int j = 0; j < brett.length; j++) {
				brett[i][j] = new Celle(intToChar(i),j);
			}
		}
	}
	
	public void skrivUt() {
		char line= 'a';
		System.out.println("   1    2   3");
		for(int i = 0; i<brett.length;i++) {
			System.out.print( line + "  ");
			line++;
			for(int j = 0; j < brett.length; j++) {
				if(brett[i][j] != null) {
					System.out.print(brett[i][j].getType() + "    ");
				}else {
					System.out.print("  .  ");
				}	
			}
			
			System.out.print("\n \n");
		}
	}
	
	public boolean leggTilCelle(char bok, int tall, char type) {
		int tall1 = tall -1;
		int tall2 = charToInt(bok) - 1;
		if( (tall1 <= 2 && tall1 >= 0) && (tall2 <= 2 && tall2 >= 0)
				&& brett[tall2][tall1].getType() == '.'){
			brett[tall2][tall1] = new Celle(bok, tall, type);
			
			return true;
		}
			return false;
	}
	
	public int charToInt(char bok) {
		
		List<Character> boks = Arrays.asList('a', 'b', 'c');
		
		for(int i = 0;i<boks.size(); i++) {
			if(boks.get(i) == bok) {
				return i+1;
			}
		}
		
		return 0;
	}
	
	public char intToChar(int tall) {
		List<Character> boks = Arrays.asList('a', 'b', 'c');
		
		return boks.get(tall);
	}

	public int antNabo(char type, int x, int y) {
		
		int ant = 0;
		
		for(int i = Math.max(0, x-1); i <=  Math.min(x+1, brett.length);i++) {
			for(int j = Math.max(0, y-1); j <= Math.min(y+1, brett[0].length);j++) {
				if(j != y || i != x){
					System.out.println(brett[i][j].getType() + " i:"+i + " j:"+j);
					if(brett[i][j].getType() == type) {
						ant++;
					}
				}
			}
		}
		return ant;
	}
	
	public boolean checkIfFull() {
		for(int i = 0; i<brett.length;i++) {
			for(int j = 0; j < brett.length; j++) {
				if(brett[i][j].getType() == '.') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkHorAndVer(char type) {
		int row = 0;
		int col = 0;
		for(int i = 0; i<brett.length;i++) {
			row = 0;
			col = 0;
			for(int j = 0; j < brett.length; j++) {
				
				if(brett[i][j].getType() == type) {
					row++;
					if(row == 3) {
						System.out.println("Horisonal");
						return true;
					}	
				}
				
				if(brett[j][i].getType() == type) {
					col++;
					if(col == 3) {
						System.out.println("Vertical");
						return true;
					}
				}
			}
		}
		return false;
	}
		
	public boolean checkDiagonal(char type) {
		int row = 0;
		int j = 0;
		
		for(int i = 0;i < brett.length;i++) {
			if(brett[i][j].getType() == type) {
				row++;
			}
			j++;
		}
		
		if(row == 3) {
			System.out.println("Diagonal1");
			return true;
		}
		
		row = 0;
		j = 2;
		for(int i = 0; i < brett.length ;i++) {
			if(brett[i][j].getType() == type) {
				row++;
			}
			j--;
		}
		if(row == 3) {
			System.out.println("Diagonal2");
			return true;
		}
		
		return false;
	}

}
