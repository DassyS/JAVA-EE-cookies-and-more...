package colorChangeCookies;

import javax.servlet.http.Cookie;

/** Cookie that persists 1 year. Default Cookie doesn't
 *  persist past current browsing session.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

public class LongLivedCookie extends Cookie {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static final int SECONDS_PER_YEAR = 60*60*24*365;
  
  public LongLivedCookie(String name, String value) {
    super(name, value);
    setMaxAge(SECONDS_PER_YEAR);
  }
  
  public LongLivedCookie(String name, int value) {
	    super(name, value);
	    setMaxAge(SECONDS_PER_YEAR);
	  }
	}
}
