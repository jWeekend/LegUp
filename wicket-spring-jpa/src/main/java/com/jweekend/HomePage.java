package com.jweekend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.jweekend.pages.EventPage;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is invoked when page is invoked without a em.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public HomePage(final PageParameters parameters) {
		super(parameters);

		// Add the simplest type of label
		add(new BookmarkablePageLink<Void>("event", EventPage.class));
	}
}
