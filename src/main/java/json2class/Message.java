package json2class;

import org.json.JSONObject;
import org.json.JSONArray;

public class Message {
	Thing[] things;
	
	public void print() {
		System.out.println("things:");
		for(int k=0; k<things.length;k++) {
			things[k].print();
		}
	}
	
	public Message(String messageJson) {
		try {
			JSONObject m = new JSONObject(messageJson);
			JSONObject body = m.getJSONObject("body");
			JSONArray t = body.getJSONArray("things");
			if (t.length()>0) {
				things = new Thing[t.length()];
				for(int k=0;k<t.length();k++){
					JSONObject thingJsonobject = t.getJSONObject(k);
					things[k] = new Thing(thingJsonobject);
				}
			}else {
				things = null;
			}
			
		}
		catch(Exception e) {
			System.out.println("message.java:");
			System.out.println(e);
		}
	}
}


