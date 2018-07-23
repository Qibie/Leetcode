package com.leetcode.zbf;

/**
 * Created by qibie-pc on 2018/6/21.
 */
public class Test {
    public static void main(String[] args) {
        //String str = "2015年5月，百科个人中心改版，透过百度百科的“数字窗口”，让人们能够更便捷地认知世界。123 [16]\n";
        String str = "ESB的基本概念\n" +
                "企业服务总线（EnterpriseServiceBus，ESB）从面向服务体系架构（Service-OrientedArchitecture，SOA）发展而来，是传统中间件技术与XML、Web服务等技术结合的产物。\n" +
                "ESB提供了网络中最基本的连接中枢，是构筑企业神经系统的必要元素。ESB采用了“总线”这样一种模式来管理和简化应用之间的集成拓扑结构，以广为接受的开放标准为基础来支持应用之间在消息、事件和服务级别上动态的互连互通，是一种在松散耦合的服务和应用之间标准的集成方式。它可以作用于：\n" +
                "①面向服务的架构—分布式的应用由可重用的服务组成；\n" +
                "②面向消息的架构—应用之间通过ESB发送和接受消息；\n" +
                "③事件驱动的架构—应用之间异步地产生和接收消息。\n" +
                "ESB的出现改变了传统的软件架构，可以提供比传统中间件产品更为低廉的解决方案，同时它还可以消除不同应用之间的技术差异，让不同的应用服务器协调运作，实现了不同服务之间的通信与整合。从功能上看，ESB提供了事件驱动和文档导向的处理模式，以及分布式的运行管理机制，它支持基于内容的路由和过滤，具备了复杂数据的传输能力，并可以提供一系列的标准接口。";
        System.out.println(getWrapedString(str, 0));
    }

    private static final String spilitCharacter = "\n";

    /**
     * 换行宽度
     */
    public static final int lineWidth = 50;

    public static String getWrapedString(String oldString, int lineWidth) {
        String words = handleString(oldString, 55);
        return words;
    }

    private static String handleString(String oldString, int lineWidth) {
        String[] strings = oldString.split("\n");
        if (strings.length == 1)
            return strings[0];
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            int start = 0;
            while ((start + lineWidth) < s.length()) {
                stringBuilder.append(s.substring(start, start + lineWidth)).append("\n");
                start += lineWidth;
            }
            if (start < s.length()) {
                stringBuilder.append(s.substring(start)).append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
