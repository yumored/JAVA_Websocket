#使用方法
 *变量data为接收到的数据，可以使用while循环来一直获取服务器发送的信息
 *变量WebsocketCode为Websocket连接状态，连接成功则为true
 *初始化连接需要调用Websocket方法来连接Websocket服务器，url值为Websocket服务器地址
 * 方法PutData为给服务器发送信息值为发送信息内容
 * 方法onClose为断开Websocket服务器连接。
