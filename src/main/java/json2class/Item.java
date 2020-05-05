package json2class;

import org.json.JSONObject;
import org.json.JSONArray;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Item {
	String[] bad;
	String ts;
	Map<String, Float> properties;
	
	public void print() {
		System.out.print("		bad: [ ");		
		for (int k=0;k<bad.length;k++){
			System.out.print(bad[k]+" ");
		}
		System.out.println("]");

		System.out.print("		ts: ");	
		System.out.println(ts);
		
		System.out.print("		properties: ");	
		System.out.println(properties);
	}

	public Item(JSONArray qbadArray, long ts2, JSONObject properties2) {
		ts = getStringDate(ts2);
		
		bad = new String[qbadArray.length()];
		for (int k=0;k<qbadArray.length();k++){
			bad[k] = qbadArray.getString(k);
		}
		
		String[] names = JSONObject.getNames(properties2);
		properties = new HashMap<String, Float>();
		for (int i = 0; i < names.length; i++) {
			float value = Float.parseFloat(properties2.getString(names[i]));
			properties.put(names[i],value);
		}
	}

	public static String getStringDate(Long timeMillies){
		Date date = new Date();
		date.setTime(timeMillies);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		return sdf.format(date);
	}
}
