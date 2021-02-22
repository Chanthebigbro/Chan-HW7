
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Driver {

	public static void main (String[] args)
	{
		
		URLReader hearthstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		HearthstoneCard[] theMinions = new HearthstoneCard[1924];
		
		ArrayList<String> Cards = new ArrayList<String>();
		
		if(obj instanceof JSONArray)
		{
			JSONArray array = (JSONArray)obj;
			for(int i = 0; i<array.size(); i++)
			{
				JSONObject cardData = (JSONObject)array.get(i);
				if(cardData.countainsKey("type") && cardData.containsKey("MINION"))
				{
					String tmp_name = cardData.get("name");
					String tmp_cost = (String)cardData.get("cost");
					String tmp_attack = (String)cardData.get("attack");
					String tmp_health = (String)cardData.get("health");
					
					HearthstoneCard_String objt = new HearthstoneCard_String(tmp_name, tmp_cost, tmp_attack, tmp_health);
					Cards.add(objt);
					
				}
			}
		}
	System.out.println(Cards);
	
	}
	
}
