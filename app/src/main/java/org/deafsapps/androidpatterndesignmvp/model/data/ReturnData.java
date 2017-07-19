package org.deafsapps.androidpatterndesignmvp.model.data;

import org.deafsapps.androidpatterndesignmvp.MainContract;
import org.deafsapps.androidpatterndesignmvp.presenter.MainActivityPresenter;

import java.util.Date;

/**
 * This class represents the model of this sample app. Due to its simplicity, it consists of a
 * {@link String} value with some information, and a {@link Date} value with the update timestamp.
 *
 * @author psor1i
 * @since 1.0
 */
public class ReturnData {

	private String returnText;
	private Date returnDate;

	public ReturnData(String returnText) {
		this.returnText = returnText;
		this.returnDate = new Date();
	}

	public ReturnData(MainContract.Presenter presenter) {
	}

	public String getReturnText() {
		return this.returnText;
	}

	public void setReturnText(String returnText) {
		this.returnText = returnText;
	}

	@Override
	public String toString() {
		if (this.returnText != null && this.returnDate != null) {
			return "Message: " + this.returnText + "; returned on: " + this.returnDate;
		} else {
			return "No register available!";
		}
	}
}
