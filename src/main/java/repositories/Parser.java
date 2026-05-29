package repositories;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import models.Call;
import models.Note;

public class Parser {
    public static ArrayList<Call> allCalls;
    public static ArrayList<Call> readCalls(){
        String fileContent=FileIO.readFile("src/main/java/data/example.json");
        JSONArray array=new JSONArray(fileContent);
        var callsList=new ArrayList<Call>();
        for(int i=0;i<array.length();i++){
            Call call=new Call();
            JSONObject currentCall=array.getJSONObject(i);
            call.archived=currentCall.getBoolean("is_archived");
            call.call_type=currentCall.getString("call_type");
            call.created_at=currentCall.getString("created_at");
            call.direction=currentCall.getString("direction");
            call.from=currentCall.getString("from");
            call.to=currentCall.getString("to");
            call.id=currentCall.getString("id");
            call.duration=currentCall.getLong("duration");
            if(currentCall.has("notes")){
                JSONArray notes=currentCall.getJSONArray("notes");
                
                for(int j=0;j<notes.length();j++){
                    Note note=new Note();
                    note.content=notes.getJSONObject(j).getString("content");
                    note.id=notes.getJSONObject(j).getString("id");
                    note.call_id=call.id;
                    call.notes.add(note);
                }
                
            }
            callsList.add(call);
        }
        return callsList;
    }
}
