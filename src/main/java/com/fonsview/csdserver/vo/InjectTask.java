package com.fonsview.csdserver.vo;

import java.util.List;

public class InjectTask {

    private String taskid;
    private String spid;
    private String cpid;
    private List<String> contentUrls;
    private String notifydst;
    private String injectdst;

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

    public List<String> getContentUrls() {
        return contentUrls;
    }

    public void setContentUrls(List<String> contentUrls) {
        this.contentUrls = contentUrls;
    }

    public String getNotifydst() {
        return notifydst;
    }

    public void setNotifydst(String notifydst) {
        this.notifydst = notifydst;
    }

    public String getInjectdst() {
        return injectdst;
    }

    public void setInjectdst(String injectdst) {
        this.injectdst = injectdst;
    }
}
