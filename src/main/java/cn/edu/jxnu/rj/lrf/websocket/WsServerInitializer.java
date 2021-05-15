package cn.edu.jxnu.rj.lrf.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


/**
 * @Classname WsServerInitializer
 * @Description TODO Websocket通道初始化
 * @Date 2021/5/12 21:25
 * @Created by 刘荣飞
 */
public class WsServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
    }
}
