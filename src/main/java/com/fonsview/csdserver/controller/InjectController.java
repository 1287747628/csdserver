package com.fonsview.csdserver.controller;

import com.alibaba.fastjson.JSON;
import com.fonsview.csdserver.service.ReplyService;
import com.fonsview.csdserver.vo.InjectTask;
import com.fonsview.csdserver.vo.ReplyTask;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class InjectController {

    @Resource
    private ReplyService replyService;

    @RequestMapping(value = "/csd/api/contentDeleteReq", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public String injectTask(@RequestBody InjectTask task) {
        long startTime = System.currentTimeMillis();
        //
        replyService.addTask(task);
        //
        Map<String, String> resp = new HashMap<>();
        resp.put("resultCode", "0");
        resp.put("description", "success");
        //
        int urlNum = task.getContentUrls() == null ? 0 : task.getContentUrls().size();
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("receive task:" + task.getTaskid() + " ,size:" + urlNum + " ,cost:" + costTime + "ms");
        return JSON.toJSONString(resp);
    }

    @RequestMapping(value = "/csd/api/fcrsup", method = RequestMethod.POST, produces = "application/json")
    public String fInjectTask(@RequestBody String taskStr) {
        long startTime = System.currentTimeMillis();
        Map<String, String> resp = new HashMap<>();
        resp.put("resultCode", "0");
        resp.put("description", "success");
        //
        ReplyTask task = JSON.parseObject(taskStr, ReplyTask.class);
        int urlNum = task.getContentUrls() == null ? 0 : task.getContentUrls().size();
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("fcrs result:" + task.getTaskid() + " ,size:" + urlNum + " ,cost:" + costTime + "ms");
        return JSON.toJSONString(resp);
    }


}
