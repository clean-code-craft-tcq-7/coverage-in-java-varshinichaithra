package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{
    @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(TypewiseAlert.inferBreach(12, 20, 30) ==
        BreachType.TOO_LOW);
      assertTrue(TypewiseAlert.inferBreach(32, 20, 30) ==
    	        BreachType.TOO_HIGH);
        assertTrue(TypewiseAlert.inferBreach(22, 20, 30) ==
    	        BreachType.NORMAL);
    }
    
    @Test
    public void checkAndAlert_Contorller_Test()
    {
    	assertTrue(TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER, CoolingType.HI_ACTIVE_COOLING, 40));
    	assertTrue(TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER, CoolingType.MED_ACTIVE_COOLING, 35));
    	assertTrue(TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER, CoolingType.PASSIVE_COOLING, 30));
    }
    
    @Test
    public void checkAndAlert_Email_Test()
    {
    	assertTrue(TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, CoolingType.HI_ACTIVE_COOLING, 40));
    	assertTrue(TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, CoolingType.MED_ACTIVE_COOLING, 35));
    	assertTrue(TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, CoolingType.PASSIVE_COOLING, 30));
    }
    
}
