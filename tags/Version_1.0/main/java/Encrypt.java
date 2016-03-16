public class Encrypt {
	
	public static String getCryptOgraph(String s,int f1,int N)
	{
		//��ԭ�Ľ���Base64����
		byte[] byteArticle = s.getBytes();
		String base64Article = Base64Convert.encode(byteArticle);
		System.out.println("Base64������ԭ�ģ�"+base64Article);
		
		
		//��Base64������ԭ��ת��Ϊ�ԡ�,��������һ����ASCII��
		String longAsciiArticle = ASCIIConvert.stringToAscii(base64Article);
		System.out.println("ASCII�����Base64�����ԭ�ģ�"+longAsciiArticle);
		
		//��һ����ASCII��ת��Ϊ������ASCII����ַ�������
		String[] asciiOfEachCharacter = longAsciiArticle.split(",");	
		
		//��ÿ��ASCII�����ν���RSA����
		String[] encryptAsciiOfEachCharacter = new String[asciiOfEachCharacter.length];
		for(int i=0;i!=asciiOfEachCharacter.length;i++)
		{
			int num = (int)Long.parseLong(asciiOfEachCharacter[i]);			
			int encryptNum = Mod.getMod(num, f1, N);
			String encryptCharacter = String.valueOf(encryptNum);
			encryptAsciiOfEachCharacter[i] = encryptCharacter;
		}
		
		//��RSA���ܺ��ÿ��ASCII���������ӳɡ����������ĳ��������㴫��
		StringBuffer sbu = new StringBuffer();
		for(int i=0;i!=encryptAsciiOfEachCharacter.length;i++)
		{	
			if(i!=encryptAsciiOfEachCharacter.length-1)
				sbu.append(encryptAsciiOfEachCharacter[i]).append(",");
			else
				sbu.append(encryptAsciiOfEachCharacter[i]);
		}
		
		String cryptOgraph = sbu.toString();
		System.out.println("RSA���ܵ�ASCII�����Base64�����ԭ�ģ�"+cryptOgraph);
		
		return cryptOgraph;
	}
	
	public static String getOriginWord(String s,int f2,int N)
	{		
		//��RSA���ܵ�ASCII�����Base64�����ԭ�ķָ��ASCII��String����
		String[] encryptAsciiOfEachCharacter = s.split(",");
		String[] asciiOfEachCharacter = new String[encryptAsciiOfEachCharacter.length];
		
		//�������еļ��ܹ���ASCII�����ν���RSA����
		for(int i=0;i!=encryptAsciiOfEachCharacter.length;i++)
		{
			int encryptNum = (int)Long.parseLong(encryptAsciiOfEachCharacter[i]);
			int num = Mod.getModLoop(encryptNum, f2, N);
			String asciiOfCharacter = String.valueOf(num);
			asciiOfEachCharacter[i] = asciiOfCharacter;
		}		
		
		//�������������ӳ�ASCII�볤�����������ASCII�����
		StringBuffer sbu = new StringBuffer();
		for(int i=0;i!=asciiOfEachCharacter.length;i++)
		{
			if(i!=asciiOfEachCharacter.length-1)
				sbu.append(asciiOfEachCharacter[i]).append(",");
			else
				sbu.append(asciiOfEachCharacter[i]);
		}
		
		System.out.println("ASCII�����Base64�����ԭ�ģ�"+sbu);
		
		//��ASCII����ĳ��Ľ�������룬�õ�Base64�����ԭ��
		String longAsciiArticle = new String();
		longAsciiArticle = sbu.toString();
		
		String base64Article = ASCIIConvert.asciiToString(longAsciiArticle);
		System.out.println("Base64�����ԭ�ģ�"+base64Article);
		
		//��Base64�����ԭ�Ľ�������룬�õ�ԭ��
		byte[] base64ByteArticle = base64Article.getBytes();
		String article = Base64Convert.decode(base64ByteArticle);
		
		return article;
	}

}

