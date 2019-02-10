package system;

public class Driver {
	String filePath = "../../ciphertext/cipher1.txt";
	
	public static void main(String[] args) {
		InputFile fileToOpen = new InputFile();
		
		fileToOpen.readFile("./ciphertext/cipher1.txt");
	}
}
