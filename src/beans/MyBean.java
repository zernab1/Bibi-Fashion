package beans;

import java.beans.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.text.DateFormat;
import java.util.*;

public class MyBean {
	Vector v = new Vector();
	String submit = null;
	String dress = null;

	private void addDress(String name) {
		v.addElement(name);
	}

	private void removeDress(String name) {
		v.removeElement(name);
	}

	public void setDress(String name) {
		dress = name;
	}

	public void setSubmit(String s) {
		submit = s;
	}

	public String[] getDresses() {
		String[] s = new String[v.size()];
		v.copyInto(s);
		return s;
	}

	public void processRequest(HttpServletRequest request) {
		// null value for submit - the user hit enter instead of clicking on
		// "add" or "remove"
		if (submit == null)
			addDress(dress);

		if (submit.equals("add"))
			addDress(dress);
		else if (submit.equals("remove"))
			removeDress(dress);

		// reset at the end of the request
		reset();
	}

	// reset
	private void reset() {
		submit = null;
		dress = null;
	}
}
