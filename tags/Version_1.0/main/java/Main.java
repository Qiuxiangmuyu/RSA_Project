import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//����һ������
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ���ܵ����֣�");
		String article = sc.nextLine();
		sc.close();
		
		//ִ��RSA���ܺͽ����㷨
		RSAEncrypt.doRSA(article);

	}

}
