/*
 * @(#)LabelValue.java
 */
package com.emerson.value.user;

/**
 * LabelValue Class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class LabelValue {
    /** label */
    private String label;
    /** value */
    private String value;

	/**
     * accessor method for label
	 * @return label
	 */
	public String getLabel() {
		return this.label;
	}

    /**
     * setter method for label
     * @param string
     */
    public void setLabel(String string) {
        this.label = string;
    }

	/**
     * accessor method for value
	 * @return value
	 */
	public String getValue() {
		return this.value;
	}

	/**
     * setter method for value
	 * @param string
	 */
	public void setValue(String string) {
		this.value = string;
	}
}
