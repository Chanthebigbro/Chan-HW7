
import java.net.URL;
import java.util.Scanner;

public class URLReader {
	
	private String urlString;
	private String theURLContents;
	
	public URLReader(String urlString)
	{
		
		this.urlString = urlString;
		this.theURLContents = "";
		
		this.readFromURL();
		
	}
	
	private void readFromURL()
	{
		
		String line = "";
		try 
		{
			URL url = new URL(this.urlString);
			Scanner input = new Scanner(url.openStream());
			
			while(input.hasNext())
			{
				line += input.nextLine();
			}
			
			input.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			line = "Can't Connecct";
		}
		this.theURLContents = line;
		
		
	}
	
	public String getTheURLContents()
	{
		return theURLContents;
	}
		
	

}
