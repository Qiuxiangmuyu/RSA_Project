
public class RSAEncrypt {
	public static void doRSA(String str)
	{
		//取两个随机大质数e1，e2
		Prime p = new Prime();
		int e[] = p.getTwoBigPrime();
		int e1 = e[0];
		int e2 = e[1];
		System.out.println("e1:" + e1);
		System.out.println("e2:" + e2);

		//根据e1，e2计算出N和r
		int N = e1 * e2;
		int r = (e1 - 1) * (e2 - 1);
		System.out.println("N:" + N);
		System.out.println("r:" + r);

		//取一个小于r的随机质数f1和它的模反元素f2，且有限制条件f1>0且f2<6500
		int f1;
		int f2;
		do{
			do {
				f1 = p.getRandomPrime();
				if (f1 < r)
					break;
			} while (true);
	
			System.out.println("f1:" + f1);
	
			f2 = MMI.getMMI(f1, r);
			System.out.println("f2:"+f2);
		}while(f2<=0||f2>6500);
		
		//得到私钥和公钥
		System.out.println("公钥：("+N+","+f1+")");
		System.out.println("私钥：("+N+","+f2+")");
		
		//输出加密和解密过程及结果
		System.out.println("原文："+str);
		String cryptOgraph = Encrypt.getCryptOgraph(str, f1, N);
		
		String originWord = Encrypt.getOriginWord(cryptOgraph, f2, N);
		System.out.println("解密结果："+originWord);
	}

}
