import java.util.Vector;

public class word {
	
	Vector<String> Words = new Vector<String>();
	@SuppressWarnings("rawtypes")
	Vector count = new Vector();
	
	@SuppressWarnings("unchecked")
	void insertWord(String w)
	{
		Words.add(w) ;
		count.add(1) ;
	}
	void display()
	{
		System.out.println(Words);
		System.out.println(count);
	}
	@SuppressWarnings("unchecked")
	void increaseCount(String a)
	{
		int temp1=Words.indexOf(a);
		int temp2=(int)count.elementAt(temp1);
		temp2++;
		count.set(temp1,temp2);
	}
	boolean search(String a)
	{
		for(int i=0;i<Words.size();i++)
		{
			if(a.equals(Words.elementAt(i)))
				return false;
		}
		return true;
	}
	public boolean querySearch(String a,Vector<String> b)
	{
		for(int i=0;i<b.size();i++)
		{
			if(a.compareTo(b.elementAt(i))==0)
				return true;
		}
		return false;	
	}

}
