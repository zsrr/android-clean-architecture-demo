package com.stephen.friendsnotebook.data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class Friend extends DataSupport {
    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phoneNumber;

    private String expression;
    private String githubUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }
}
