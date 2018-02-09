
public class Celle {

	char x; int y;
	char type;
	
	public Celle(char x, int y, char type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public Celle(char x, int y) {
		this.x = x;
		this.y = y;
		this.type = '.';
	}
	
	public char getType() {
		return type;
	}

}
