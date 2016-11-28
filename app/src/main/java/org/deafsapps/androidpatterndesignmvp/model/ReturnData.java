package org.deafsapps.androidpatterndesignmvp.model;

import java.util.Date;

/**
 * Created by Pablo L on 28/11/2016.
 */
public class ReturnData {

    private String mReturnText;
    private Date mReturnDate;

    public ReturnData(String returnString) {
        this.mReturnText = returnString;
        this.mReturnDate = new Date();
    }

    public ReturnData(String returnString, Date returnDate) {
        this.mReturnText = returnString;
        this.mReturnDate = returnDate;
    }

    public String getmReturnText() {
        return mReturnText;
    }

    public void setmReturnText(String mReturnText) {
        this.mReturnText = mReturnText;
    }

    public Date getmReturnDate() {
        return mReturnDate;
    }

    public void setmReturnDate(Date mReturnDate) {
        this.mReturnDate = mReturnDate;
    }

    @Override
    public String toString() {
        super.toString();
        return "Message: " + this.mReturnText + "; returned on: " + this.mReturnDate;
    }
}
