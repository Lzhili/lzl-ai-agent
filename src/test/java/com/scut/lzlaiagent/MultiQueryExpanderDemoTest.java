package com.scut.lzlaiagent;

import com.scut.lzlaiagent.demo.rag.MultiQueryExpanderDemo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.ai.rag.Query;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MultiQueryExpanderDemoTest {

    @Resource
    private MultiQueryExpanderDemo multiQueryExpanderDemo;

    @Test
    void test() {
        List<Query> queries = multiQueryExpanderDemo.expand("如何提升自己的魅力？");
        Assertions.assertNotNull(queries);
    }
}
