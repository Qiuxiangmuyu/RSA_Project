import java.util.*;

public class Prime {
	//������
	private ArrayList primeList = new ArrayList();
	
	//��������Ϊ...
	private int PrimeUpperLimit = 200; 
	
	//��ʼ��ʱ����������
	public Prime()
	{
		seekPrime();
	}
	
	//�����������������
	private void seekPrime() {
		for(int num=3;num<=PrimeUpperLimit;num++)
		{
			if(isPrime(num) == true)
			{
				Integer integerN = Integer.valueOf(num);
				primeList.add(integerN);
			}
		}
	}

	//�ж�һ�����Ƿ�������
	private boolean isPrime(int num)
	{
		boolean result = true;
		int factor = 2;
		while(factor < num)
		{
			if(num%factor == 0)
				break;
			factor++;
		}
		if(factor == num)
			result = true;
		else
			result = false;
		
		return result;
	}
	
	//��������������ͬ�Ĵ�����
	public int[] getTwoBigPrime() {
		int[] twoBigPrime = new int[2];
		
		//�����±�ķ�Χ
		int MinIndex = 19;
		int MaxIndex = primeList.size()-1;

		//ȡ�õ�һ������e1
		int randomIndex1 = MinIndex+(int)(Math.random()*(MaxIndex-MinIndex));
		Integer integerE1 = (Integer) primeList.get(randomIndex1);
		int e1 = integerE1.intValue();

		//ȡ�õڶ�������e2��������������e2!=e1
		int randomIndex2;
		int e2 = 0;
		do
		{
			randomIndex2 = MinIndex+(int)(Math.random()*(MaxIndex-MinIndex));
			Integer integerE2 = (Integer)primeList.get(randomIndex2);
			e2 = integerE2.intValue();
		}while(e1==e2);

		twoBigPrime[0] = e1;
		twoBigPrime[1] = e2;

		return twoBigPrime;
	}

	//������һ������
	public int getRandomPrime() {
		int randomIndex = (int)(Math.random()*(primeList.size()-1));
		Integer integer = (Integer) primeList.get(randomIndex);
		int result = integer.intValue();

		return result;
	}
}
