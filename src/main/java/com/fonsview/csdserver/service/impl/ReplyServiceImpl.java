package com.fonsview.csdserver.service.impl;

import com.fonsview.csdserver.service.ReplyService;
import com.fonsview.csdserver.service.SendTaskService;
import com.fonsview.csdserver.vo.InjectTask;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private SendTaskService sendTaskService;
    //
    private LinkedBlockingQueue<InjectTask> taskQueue;

    @PostConstruct
    private void init() {
        ReplyTaskThread taskThread = new ReplyTaskThread();
        taskThread.start();
    }

    @Override
    public void addTask(InjectTask task) {
        this.taskQueue.add(task);
    }

    private class ReplyTaskThread extends Thread {
        @Override
        public void run() {
            taskQueue = new LinkedBlockingQueue<>();
            //
            while (true) {
                try {
                    InjectTask task = taskQueue.take();
                    sendTaskService.sendTask(task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
