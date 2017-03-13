package com.cgs.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

/**
 * Created by Administrator on 2017/3/12.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    ServerBootstrap bootstrap = new ServerBootstrap();

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        ((ByteBuf)msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

    public static void main(String[] args) {

    }

}
