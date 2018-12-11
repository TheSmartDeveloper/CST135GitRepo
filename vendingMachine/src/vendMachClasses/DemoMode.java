package vendMachClasses;
import java.util.LinkedList; 
import java.util.Queue;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class fakePeople
{
	String FName = "";
	String PName = "";
	int num = 0;
	
	public fakePeople()
	{
		
	}
	public fakePeople(String first, String Prod, int howMany)
	{
		this.FName = first;
		this.PName = Prod;
		this.num = howMany;
	}
	public String getFName()
	{
		return FName;
	}
	public void setFName(String fName)
	{
		FName = fName;
	}
	public String getPName()
	{
		return PName;
	}
	public void setPName(String pName)
	{
		PName = pName;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	
}
public class DemoMode
{
	//Queue<fakePeople> demoQ = new LinkedList<>();
	public void readQ(Queue<fakePeople> demoQ) throws FileNotFoundException, IOException
	{
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader("q.csv"));
		while((line = br.readLine()) != null)
		{
			String[] Qcsv = line.split(",");
			fakePeople peeps = new fakePeople();
			peeps.setFName(Qcsv[0]);
			peeps.setPName(Qcsv[1]);
			peeps.setNum(Integer.parseInt(Qcsv[2]));
			demoQ.add(peeps);
		}
		br.close();
		
	}
}
