package com.scut.lzlaiagent;

import cn.hutool.core.lang.UUID;
import com.scut.lzlaiagent.app.LoveApp;
import com.scut.lzlaiagent.pojo.LoveReport;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();

        String message = "你好，我是学生小明";
        String answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);

        message = "我想让我的另一半（小红）更爱我";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);

        message = "我的另一半叫什么来着？刚跟你说过，帮我回忆一下";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithReport() {
        String chatId = UUID.randomUUID().toString();

        String message = "你好，我是学生小明，我想让另一半（小红）更爱我，但我不知道该怎么做";
        LoveReport loveReport = loveApp.doChatWithReport(message, chatId);
        Assertions.assertNotNull(loveReport);
    }

    @Test
    void doChatWithRag() {
        String chatId = UUID.randomUUID().toString();
        String message = "我是单身的，怎么样提升魅力吸引异性？";
        String answer =  loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(answer);
    }
}

