package com.scut.lzlaiagent.rag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.rag.retrieval.search.DocumentRetriever;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.Filter;
import org.springframework.ai.vectorstore.filter.FilterExpressionBuilder;

/**
 * 自定义RAG检索增强顾问的工厂
 */
@Slf4j
public class LoveAppRagCustomAdvisorFactory {

    /**
     * 创建自定义RAG检索增强顾问
     * @param vectorStore 向量数据库
     * @param status 文档状态
     * @return 自定义RAG检索增强顾问
     */
    public static Advisor createLoveAppRagCustomAdvisor(VectorStore vectorStore, String status) {
        // 过滤特定状态文档
        Filter.Expression expression = new FilterExpressionBuilder()
                .eq("status", status)
                .build();
        //创建文档检索器
        DocumentRetriever documentRetriever = VectorStoreDocumentRetriever.builder()
                .vectorStore(vectorStore)
                .filterExpression(expression) // 添加过滤条件
                .similarityThreshold(0.3) // 设置相似度阈值
                .topK(3) // 设置返回文档数量
                .build();
        return RetrievalAugmentationAdvisor.builder()
                .documentRetriever(documentRetriever)
                .build();
    }
}
