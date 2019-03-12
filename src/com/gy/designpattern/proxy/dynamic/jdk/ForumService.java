package com.gy.designpattern.proxy.dynamic.jdk;

/**
 * ClassName: ForumService
 * Description:论坛服务
 * date: 2019/3/10 21:51
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public interface ForumService {

    void removeTopic(int topicId);

    void removeForum(int forumId);
}
