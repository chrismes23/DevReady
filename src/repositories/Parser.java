package repositories;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import models.Call;

public class Parser {
    public static ArrayList<Call> readCalls(){
        String fileContent=FileIO.readFile("data/example.json");
        JSONArray array=new JSONArray(fileContent);
        var callsList=new ArrayList<Call>();
        for(int i=0;i<array.length();i++){
            Call call=new Call();
            JSONObject currentCall=array.getJSONObject(i);
            call.archived=currentCall.getString("is_archived");
            call.call_type=currentCall.getString("call_type");
            call.created_at=currentCall.getString("created_at");
            call.direction=currentCall.getString("direction");
            call.from=currentCall.getString("from");
            call.to=currentCall.getString("to");
            call.id=currentCall.getString("id");
            callsList.add(call);
        }
        return callsList;
    }
}
