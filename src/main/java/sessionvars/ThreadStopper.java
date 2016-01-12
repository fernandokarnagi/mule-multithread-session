package sessionvars;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class ThreadStopper implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		Thread.sleep(100);
		System.out.println("Resume thread");
		return eventContext.getMessage().getOriginalPayload();
	}
}
