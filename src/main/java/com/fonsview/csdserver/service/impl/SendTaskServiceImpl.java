package com.fonsview.csdserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.fonsview.csdserver.service.SendTaskService;
import com.fonsview.csdserver.utils.http.HttpProtocolHandler;
import com.fonsview.csdserver.utils.http.HttpRequest;
import com.fonsview.csdserver.vo.InjectTask;
import com.fonsview.csdserver.vo.ReplyContent;
import com.fonsview.csdserver.vo.ReplyTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SendTaskServiceImpl implements SendTaskService {

    @Async
    @Override
    public void sendTask(InjectTask task) {
        long startTime = System.currentTimeMillis();
        ReplyTask replyTask = new ReplyTask();
        replyTask.setTaskid(task.getTaskid());
        replyTask.setSpid(task.getSpid());
        replyTask.setCpid(task.getCpid());
        replyTask.setInjectdst(task.getInjectdst());
        replyTask.setStatus(2);
        replyTask.setDescription("success");
        replyTask.setContentUrls(new ArrayList<>());
        if (task.getContentUrls() != null && !task.getContentUrls().isEmpty()) {
            for (String url : task.getContentUrls()) {
                ReplyContent replyContent = new ReplyContent();
                replyContent.setStatus(2);
                replyContent.setUrl(url);
                replyTask.getContentUrls().add(replyContent);
            }
        }
        String resp = JSON.toJSONString(replyTask);
        HttpRequest req = new HttpRequest(task.getNotifydst(), resp);
        HttpProtocolHandler.getInstance().execute(req);
        //
        long costTime = System.currentTimeMillis() - startTime;
        int urlNum = task.getContentUrls() == null ? 0 : task.getContentUrls().size();
        System.out.println("reply task:" + task.getTaskid() + " ,size:" + urlNum + " ,cost:" + costTime + "ms");
    }
}
