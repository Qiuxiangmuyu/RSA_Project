public class Encrypt {
	
	public static String getCryptOgraph(String s,int f1,int N)
	{
		//将原文进行Base64编码
		byte[] byteArticle = s.getBytes();
		String base64Article = Base64Convert.encode(byteArticle);
		System.out.println("Base64编码后的原文："+base64Article);
		
		
		//将Base64编码后的原文转化为以“,”隔开的一长串ASCII码
		String longAsciiArticle = ASCIIConvert.stringToAscii(base64Article);
		System.out.println("ASCII编码的Base64编码的原文："+longAsciiArticle);
		
		//将一长串ASCII码转化为保存着ASCII码的字符串数组
		String[] asciiOfEachCharacter = longAsciiArticle.split(",");	
		
		//将每个ASCII码依次进行RSA加密
		String[] encryptAsciiOfEachCharacter = new String[asciiOfEachCharacter.length];
		for(int i=0;i!=asciiOfEachCharacter.length;i++)
		{
			int num = (int)Long.parseLong(asciiOfEachCharacter[i]);			
			int encryptNum = Mod.getMod(num, f1, N);
			String encryptCharacter = String.valueOf(encryptNum);
			encryptAsciiOfEachCharacter[i] = encryptCharacter;
		}
		
		//对RSA加密后的每个ASCII码重新连接成“，”隔开的长串，方便传输
		StringBuffer sbu = new StringBuffer();
		for(int i=0;i!=encryptAsciiOfEachCharacter.length;i++)
		{	
			if(i!=encryptAsciiOfEachCharacter.length-1)
				sbu.append(encryptAsciiOfEachCharacter[i]).append(",");
			else
				sbu.append(encryptAsciiOfEachCharacter[i]);
		}
		
		String cryptOgraph = sbu.toString();
		System.out.println("RSA加密的ASCII编码的Base64编码的原文："+cryptOgraph);
		
		return cryptOgraph;
	}
	
	public static String getOriginWord(String s,int f2,int N)
	{		
		//将RSA加密的ASCII编码的Base64编码的原文分割成ASCII码String数组
		String[] encryptAsciiOfEachCharacter = s.split(",");
		String[] asciiOfEachCharacter = new String[encryptAsciiOfEachCharacter.length];
		
		//对数组中的加密过的ASCII码依次进行RSA解密
		for(int i=0;i!=encryptAsciiOfEachCharacter.length;i++)
		{
			int encryptNum = (int)Long.parseLong(encryptAsciiOfEachCharacter[i]);
			int num = Mod.getModLoop(encryptNum, f2, N);
			String asciiOfCharacter = String.valueOf(num);
			asciiOfEachCharacter[i] = asciiOfCharacter;
		}		
		
		//将数组重新连接成ASCII码长串，方面进行ASCII逆编码
		StringBuffer sbu = new StringBuffer();
		for(int i=0;i!=asciiOfEachCharacter.length;i++)
		{
			if(i!=asciiOfEachCharacter.length-1)
				sbu.append(asciiOfEachCharacter[i]).append(",");
			else
				sbu.append(asciiOfEachCharacter[i]);
		}
		
		System.out.println("ASCII编码的Base64编码的原文："+sbu);
		
		//对ASCII编码的长文进行逆编码，得到Base64编码的原文
		String longAsciiArticle = new String();
		longAsciiArticle = sbu.toString();
		
		String base64Article = ASCIIConvert.asciiToString(longAsciiArticle);
		System.out.println("Base64编码的原文："+base64Article);
		
		//对Base64编码的原文进行逆编码，得到原文
		byte[] base64ByteArticle = base64Article.getBytes();
		String article = Base64Convert.decode(base64ByteArticle);
		
		return article;
	}

}

