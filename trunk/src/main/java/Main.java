import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//输入一段文字
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要加密的文字：");
		String article = sc.nextLine();
		sc.close();
		
		//执行RSA加密和解密算法
		RSAEncrypt.doRSA(article);

	}

}
