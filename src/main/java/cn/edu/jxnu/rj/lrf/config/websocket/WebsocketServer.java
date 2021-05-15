package cn.edu.jxnu.rj.lrf.config.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;


/**
 * @Classname WebsocketServer
 * @Description TODO websocket启动类,配置Netty启动和销毁
 * @Date 2021/5/12 20:36
 * @Created by 刘荣飞
 */
//@Component
public class WebsocketServer {
    private Logger logger = LoggerFactory.getLogger(WebsocketServer.class);
    //初始化主线程
    NioEventLoopGroup mainGroup = new NioEventLoopGroup();
    //初始化从线程
    NioEventLoopGroup subGroup = new NioEventLoopGroup();

    /**
     * @Description //TODO 启动Netty
     * @Param []
     * @return void
     **/
    @PostConstruct
    public void init(){
        try{
            //创建服务启动器
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //指定使用主线程和从线程
            serverBootstrap.group(mainGroup,subGroup)
                    //指定使用NIO通道类型
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(9001))
                    //保持长连接
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    //指定通道初始化器，指明当Channel收到消息后如何进行业务处理
                    .childHandler(new WsServerInitializer());
            //绑定端口启动服务器，并等待服务启动
            ChannelFuture future = serverBootstrap.bind().sync();
            if(future.isSuccess()){
                logger.info("Netty启动成功！");
            }
            //等待服务器关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description //TODO 关闭Netty
     * @Param []
     * @return void
     **/
    @PreDestroy
    public void destroy(){
        mainGroup.shutdownGracefully().syncUninterruptibly();
        subGroup.shutdownGracefully().syncUninterruptibly();
        logger.info("关闭Netty成功！");
    }
}
