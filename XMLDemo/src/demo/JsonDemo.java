package demo;

import org.json.simple.JSONObject;

public class JsonDemo {
	public static void main(String[] args) {
		JSONObject jo = new JSONObject();
		
		jo.put("username", "ncuy");
		jo.put("password", "ncuy");
		System.out.println(jo);
		System.out.println(jo.get("username"));
	}
}
