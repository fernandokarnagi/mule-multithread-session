package sessionvars;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class SessionSync implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
	
		Object ob = eventContext.getSession().getProperty("myvar");
		System.out.println("1.obj: " + ob + ", hashcode: " + ob.hashCode());
		 
		Integer it = (Integer) ob;
		it = it + 1;
		System.out.println("2.obj: " + it + ", hashcode: " + it.hashCode());
		
		eventContext.getSession().setProperty("myvar", it);
		
		return eventContext.getMessage().getOriginalPayload();
	}

}
