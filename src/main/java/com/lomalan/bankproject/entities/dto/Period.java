package com.lomalan.bankproject.entities.dto;

/**
 * <p>
 *     This class represented simple Dto to handle period between two dates.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

public class Period {
    private String from;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
