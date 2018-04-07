package pro.helderlee.desafio.integration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PlanetaIntegration {
	
	private final Logger slf4jLogger = LoggerFactory.getLogger(PlanetaIntegration.class);

	public Integer buscarNumeroAparicoesSwapiPorId(BigInteger id) {
		Integer numero = 0;
		HttpResponse<JsonNode> planetResponse;
		try {
			planetResponse = Unirest.get("https://swapi.co/api/planets/" + id.toString()).asJson();
			JsonNode jsonNode = planetResponse.getBody();
			JSONObject jsonObject = jsonNode.getObject();
			Map<String, Object> planetMap;
			try {
				planetMap = jsonToMap(jsonObject);
				@SuppressWarnings("unchecked")
				List<String> listaAparicoes = (List<String>) planetMap.get("films");
				numero = listaAparicoes.size();
			} catch (JSONException e) {
				slf4jLogger.error("Erro JSON", e);
			}
		} catch (UnirestException e) {
			slf4jLogger.error("Erro Unirest", e);
		}
		return numero;

	}
	
	public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
	    Map<String, Object> retMap = new HashMap<String, Object>();

	    if(json != JSONObject.NULL) {
	        retMap = toMap(json);
	    }
	    return retMap;
	}

	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);

	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}	

}
