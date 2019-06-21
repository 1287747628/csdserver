package com.fonsview.csdserver.vo;

import java.util.List;

public class ReplyTask {

    private String taskid;
    private String spid;
    private String cpid;
    private String injectdst;
    private List<ReplyContent> contentUrls;
    private Integer status;
    private String description;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
    }

    public String getInjectdst() {
        return injectdst;
    }

    public void setInjectdst(String injectdst) {
        this.injectdst = injectdst;
    }

    public List<ReplyContent> getContentUrls() {
        return contentUrls;
    }

    public void setContentUrls(List<ReplyContent> contentUrls) {
        this.contentUrls = contentUrls;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
