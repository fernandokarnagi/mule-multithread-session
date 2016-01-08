package sessionvars;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

import asia.omron.bean.SessionBean;

public class SyncAggregrator implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		while (true) {
			SessionBean sessionBean = eventContext.getMessage().getProperty("omronSessionVars", PropertyScope.SESSION);
			System.out.println("sessionBean.getTotalOriginalRecords() : " + sessionBean.getTotalOriginalRecords()
					+ ", sessionBean.getTotalRecords: " + sessionBean.getTotalRecords());
			if (sessionBean.getTotalOriginalRecords() > sessionBean.getTotalRecords()) {
				System.out.println("Wait for 1 second");
				Thread.sleep(1000);

			} else {
				break;
			}
		}

		System.out.println("Resume thread");
		return eventContext.getMessage().getOriginalPayload();
	}
}
