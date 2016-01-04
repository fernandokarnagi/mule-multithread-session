package sessionvars;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class SyncAggregrator implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
	
		System.out.println("Sleep...");
		Thread.sleep(5000);
		
		System.out.println("wakeup...");
		return eventContext.getMessage().getOriginalPayload();
	}

}
