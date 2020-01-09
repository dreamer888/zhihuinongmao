package com.yq.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Created by fineTu on 2016/09/27.
 */
public class JsonUtil {


    public static Map<String,Object> parse(String jsonStr) throws IOException {
        Map<String,Object> resMap = new HashMap<String, Object>();
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = mapper.readTree(jsonStr);
        resMap = parseNode2Obj(rootNode);
        return resMap;
    }


    private static Map<String,Object> parseNode2Obj(JsonNode jsonNode){
        Map<String,Object> resMap = new HashMap<String, Object>();
        if(jsonNode.isValueNode()){
            Object value = parseValue(jsonNode);
            resMap.put("",value);
            return resMap;
        }else if(jsonNode.isArray()){
            List<Object> list = new ArrayList<Object>();
            Iterator<JsonNode> it = jsonNode.iterator();
            while( it.hasNext()){
                Map<String,Object> child = parseNode2Obj(it.next());
                if (child.keySet().size() == 1 && child.keySet().contains("")){
                    list.add(child.get(""));
                }else{
                    list.add(child);
                }
            }
            resMap.put("",list);
            return resMap;
        }else {
            Iterator<Map.Entry<String,JsonNode>> it = jsonNode.fields();
            while( it.hasNext()){
                Map.Entry<String,JsonNode> entry = it.next();
                Map<String,Object> child = parseNode2Obj(entry.getValue());
                if (child.keySet().size() == 1 && child.keySet().contains("")){
                    resMap.put(entry.getKey(),child.get(""));
                }else{
                    resMap.put(entry.getKey(),child);
                }
            }
            return resMap;
        }
    }


    private static Object parseValue(JsonNode valueNode){
        if(valueNode.isTextual()){
            return valueNode.asText();
        }else if(valueNode.isInt()){
            return valueNode.asInt();
        }else if(valueNode.isBigInteger() || valueNode.isLong()){
            return valueNode.asLong();
        }else if(valueNode.isFloat() || valueNode.isDouble()){
            return valueNode.asDouble();
        }else if(valueNode.isBoolean()){
            return valueNode.asBoolean();
        }
        return valueNode.asText();
    }
    public static void main(String[] args){
        String jsonStr = "{\"a\":12,\"b\":\"foobar\",\"c\":[\"tom\",\"peter\",\"joe\"],\"d\":{\"da\":\"1123\",\"db\":456,\"dc\":[{\"name\":\"super man\",\"id\":1},{\"name\":\"bat man\",\"id\":2}]}}";
        try {
            Map<String,Object> resMap = JsonUtil.parse(jsonStr);
            System.out.println(resMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}