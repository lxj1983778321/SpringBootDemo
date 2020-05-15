package com.example.demo.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class NioServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead is Running......");
        String str =(String) msg;
        System.out.println("client 发送过来的消息为: "+ str);
        ctx.channel().writeAndFlush("server 接收信息 success$");
        System.out.println("Server channelRead end");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exceptionCaught is Running");
        ctx.close();
        System.out.println("server exceptionCaught end");
    }
}
