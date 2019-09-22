package tennis;

public class main {
	public static void main(String[] args) {
		Game G = new Game();
		Thread runner = new Thread(G);
		runner.start();
	}
}
