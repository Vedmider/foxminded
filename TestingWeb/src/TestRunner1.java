
import junit.runner.Version;


import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner1 {
   public static void main(String[] args) {
      JUnitCore jUnitCore = new JUnitCore();
      Request request = Request.aClass(TestServerResponse1.class);
	  Result result = jUnitCore.run(request);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println("JUnit version is: " + Version.id());	
      System.out.println(result.wasSuccessful());
   }
}  	