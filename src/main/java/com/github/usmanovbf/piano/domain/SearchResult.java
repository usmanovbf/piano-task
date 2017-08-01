package com.github.usmanovbf.piano.domain;

import java.util.Date;

/**
 * Each item from /search method of API
 */
public class SearchResult {
    private Date dateOfQuestion;
    private String title;
    private String username;
    private String link;
    private boolean isAnswered;


    public SearchResult() {
    }

    public Date getDateOfQuestion() {
        return dateOfQuestion;
    }

    public void setDateOfQuestion( Date dateOfQuestion ) {
        this.dateOfQuestion = dateOfQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getLink() {
        return link;
    }

    public void setLink( String link ) {
        this.link = link;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered( boolean answered ) {
        isAnswered = answered;
    }

}
