package models;

import java.util.ArrayList;

public class Call {
    public String id,direction,from,to,call_type,created_at;
    public boolean archived;
    public long duration;
    public ArrayList<Note> notes=new ArrayList<Note>();
}
