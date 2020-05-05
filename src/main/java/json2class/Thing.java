package json2class;

import org.json.JSONObject;
import org.json.JSONArray;

public class Thing {
	String id;
	String type;
	Item[] record;
	
	public void print() {
		System.out.print("	id: ");
		System.out.println(id);
		
		System.out.print("	type: ");
		System.out.println(type);
		
		System.out.println("	items: ");
		for(int k=0; k<record.length;k++) {
			record[k].print();
		}
	}
	
	public Thing(JSONObject t) {
		try {
			id = t.getString("id");
			type = t.getString("thingType");

			JSONArray i = t.getJSONArray("items");
			record = new Item[i.length()];
			for(int k=0;k<i.length();k++){
				JSONObject tempJson=i.getJSONObject(k);
				
				JSONArray qbadArray = tempJson.getJSONArray("qbad");
				long ts = tempJson.getLong("ts");
				JSONObject properties = tempJson.getJSONObject("properties");
				
				Item item = new Item(qbadArray, ts, properties);
				
				record[k] = item;
			}
		}
		catch(Exception e) {
			System.out.println("thing.java:");
			System.out.println(e);
		}
	}
	
}


