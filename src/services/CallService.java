package services;

import java.util.ArrayList;

import models.Call;
import repositories.Parser;

public class CallService {

    public void init(){
        Parser.allCalls=Parser.readCalls();
    }

    public ArrayList<Call> getAllCalls(){
        return (ArrayList<Call>)Parser.allCalls.stream().filter((call)->call.archived).toList();
       
    }
    
    public Call getCallById(String callId){
        var calls=Parser.allCalls;
        for(Call call:calls){
            if(call.id==callId){
                return call;
            }
        }
        return null;//If id not found, return null
    }
    public Call archiveCall(String callId){
        Call call=getCallById(callId);
        if(call==null){
            return null;
        }
        call.archived=true;
        return call;
    }

}
