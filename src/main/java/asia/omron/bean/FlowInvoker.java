package asia.omron.bean;

import org.mule.DefaultMuleEvent;
import org.mule.MessageExchangePattern;
import org.mule.api.MuleEvent;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.construct.Flow;

public class FlowInvoker implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		Flow flow = (Flow) eventContext.getMuleContext().getRegistry().lookupFlowConstruct("vmtestFlow1");
		DefaultMuleEvent eventToSend = new DefaultMuleEvent(eventContext.getMessage(),
				MessageExchangePattern.REQUEST_RESPONSE, flow, eventContext.getSession());
		MuleEvent event = flow.process(eventToSend);
		MuleMessage message = event.getMessage();

		System.out.println("Payload: " + message.getPayloadAsString());
		return "OK";
	}

}
