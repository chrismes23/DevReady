import models.*;
import services.CallService;

class Main{
	public static void main(String args[]){
		CallService service=new CallService();
		service.init();
		var list=service.getAllCalls();
		for(Call call:list)
			printCall(call);
		Call exampleCall=service.getCallById("5");//Calling getCallById with id e.g. 5
		
		printCall(exampleCall);
		service.archiveCall("2");

	}

	public static void printCall(Call c){
		System.out.printf("#%s From %s to %s (%s) Type:%s %dsec\nCreated:%s\n",c.id,c.from,c.to,c.direction,c.call_type,(int)c.duration,c.created_at);
		for(Note n:c.notes){
			System.out.printf(" Note:%s\n",n.content);
		}
	}
}
