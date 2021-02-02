package com.mazj.websocket;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@ServerEndpoint(value = "/websocket") //接受websocket请求路径
@Component  //注册到spring容器中
public class MySocket {
    /**
     * 在线人数
     */
    public static int onlineNumber = 0;

    /**
     * 所有的对象
     */
    public static List<MySocket> webSockets = new CopyOnWriteArrayList<MySocket>();

    /**
     * 会话
     */
    private Session session;

    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) throws InterruptedException {
        onlineNumber++;
        webSockets.add(this);

        this.session = session;

        System.out.println("有新连接加入！ 当前在线人数" + onlineNumber);
        int num = 0;
        while (true) {
            Thread.sleep(5000);
            num++;
            sendMessage("加入了" + num);
        }
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose()
    {
        onlineNumber--;
        webSockets.remove(this);
        System.out.println("有连接关闭！ 当前在线人数" + onlineNumber);
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
        System.out.println("来自客户端消息：" + message);

        sendMessage("欢迎连接");
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
//    @Scheduled(fixedRate = 1000 * 5)//每隔30秒向客户端发送一次数据
    public void sendMessage(String message)
    {
        try
        {
            session.getBasicRemote().sendText(message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
