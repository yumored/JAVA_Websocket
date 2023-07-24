package com.Websocket;
/*
 *Java作为客户端连接Websocket
 *版本:1.0.0
 *作者:雨莫
 * QQ：2789599771
 *使用方法
 *变量data为接收到的数据，可以使用while循环来一直获取服务器发送的信息
 *变量WebsocketCode为Websocket连接状态，连接成功则为true
 *初始化连接需要调用Websocket方法来连接Websocket服务器，url值为Websocket服务器地址
 * 方法PutData为给服务器发送信息值为发送信息内容
 * 方法onClose为断开Websocket服务器连接。
 */
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;
public class ExampleClient  {
    private static WebSocketClient client;
    private static String data;//接收数据
    private static Boolean WebsocketCode=false;//Websocket连接状态
    public static void Websocket(String url) {
        try {
            client = new WebSocketClient(new URI(url)) {
                @Override
                public void onOpen(ServerHandshake handshakeData) {
                    WebsocketCode=true;
                }

                @Override
                public void onMessage(String message) {
                    data = message;
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                }

                @Override
                public void onError(Exception e) {
                }
            };
            client.connect();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public static Boolean PutData(String data){
        client.send(data);
        return true;
    }
    public static Boolean onClose(){
        client.close();
        client = null;
        WebsocketCode=false;
        return true;
    }
}