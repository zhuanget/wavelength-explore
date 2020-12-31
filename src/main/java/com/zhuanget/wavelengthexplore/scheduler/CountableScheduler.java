package com.zhuanget.wavelengthexplore.scheduler;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import us.codecraft.webmagic.scheduler.MonitorableScheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CountableScheduler extends DuplicateRemovedScheduler implements MonitorableScheduler {

    private BlockingQueue<Request> queue = new LinkedBlockingQueue();

    private int count = -1;

    public CountableScheduler() {
    }

    public void pushWhenNoDuplicate(Request request, Task task) {
        this.queue.add(request);
    }

    @Override
    public Request poll(Task task) {
        if (count == -1) {
            return (Request)this.queue.poll();
        }
        if (count > 0) {
            count--;
            return (Request)this.queue.poll();
        }else {
            this.queue.clear();
            return null;
        }
//        return (Request)this.queue.poll();
    }

    @Override
    public int getLeftRequestsCount(Task task) {
        return this.queue.size();
    }

    @Override
    public int getTotalRequestsCount(Task task) {
        return this.getDuplicateRemover().getTotalRequestsCount(task);
    }

    public CountableScheduler setCount(int count) {
        if(count <= 0) {
            return this;
        }
        this.count = count + 1;
        return this;
    }
}
