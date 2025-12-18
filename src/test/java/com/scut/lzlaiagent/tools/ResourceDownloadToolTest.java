package com.scut.lzlaiagent.tools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ResourceDownloadToolTest {

    @Test
    public void testDownloadResource() {
        ResourceDownloadTool tool = new ResourceDownloadTool();
        String url = "https://wallpaperaccess.com/full/1109526.jpg";
        String fileName = "laker.png";
        String result = tool.downloadResource(url, fileName);
        assertNotNull(result);
    }
}
