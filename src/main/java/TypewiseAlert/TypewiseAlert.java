package TypewiseAlert;

import TypewiseAlert.BatteryCharacter;
import TypewiseAlert.BreachType;
import TypewiseAlert.CoolingType;
import TypewiseAlert.AlertTarget;

public class TypewiseAlert 
{
   
    public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
      if(value < lowerLimit) {
        return BreachType.TOO_LOW;
      }
      if(value > upperLimit) {
        return BreachType.TOO_HIGH;
      }
      return BreachType.NORMAL;
    }
    
    
    public static boolean checkAndAlert(
        AlertTarget alertTarget, CoolingType coolingType, double temperatureInC) {

      BreachType breachType = inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
      
      return alertActionSuccessful(breachType, alertTarget);
    }

   
	private static boolean alertActionSuccessful(BreachType breachType, AlertTarget alertTarget) {
		// TODO Auto-generated method stub
		switch(alertTarget)
	{
        case TO_CONTROLLER:
          return sendToController(breachType);
        case TO_EMAIL:
          return sendToEmail(breachType);
      }
		return false;
    }
    
    
    
    public static boolean sendToController(BreachType breachType) {
      int header = 0xfeed;
      printControllerMsg(breachType, header);
	return true;
    }
    
    public static boolean sendToEmail(BreachType breachType) {
      String recepient = "a.b@c.com";
        	printEmail(recepient,breachType);
        	return true;
      }
    
    public static void printEmail(String recepient, BreachType breachType) {
    	System.out.println("To: "+ recepient);
        System.out.println("Hi, the temperature is  "+breachType.getType()+" \n");
    }
    
    public static void printControllerMsg(BreachType breachType, int header){
    	System.out.println( header+" : "+breachType);
    }
}
