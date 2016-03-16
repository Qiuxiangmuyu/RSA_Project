import java.util.*;

public class Prime {
	//质数表
	private ArrayList primeList = new ArrayList();
	
	//质数上限为...
	private int PrimeUpperLimit = 200; 
	
	//初始化时构造质数表
	public Prime()
	{
		seekPrime();
	}
	
	//向质数表中添加质数
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

	//判断一个数是否是质数
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
	
	//随机获得两个不相同的大质数
	public int[] getTwoBigPrime() {
		int[] twoBigPrime = new int[2];
		
		//质数下标的范围
		int MinIndex = 19;
		int MaxIndex = primeList.size()-1;

		//取得第一个质数e1
		int randomIndex1 = MinIndex+(int)(Math.random()*(MaxIndex-MinIndex));
		Integer integerE1 = (Integer) primeList.get(randomIndex1);
		int e1 = integerE1.intValue();

		//取得第二个质数e2，且有限制条件e2!=e1
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

	//随机获得一个质数
	public int getRandomPrime() {
		int randomIndex = (int)(Math.random()*(primeList.size()-1));
		Integer integer = (Integer) primeList.get(randomIndex);
		int result = integer.intValue();

		return result;
	}
}
