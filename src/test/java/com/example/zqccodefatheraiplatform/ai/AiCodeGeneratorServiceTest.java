package com.example.zqccodefatheraiplatform.ai;

import com.example.zqccodefatheraiplatform.ai.model.HtmlCodeResult;
import com.example.zqccodefatheraiplatform.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZQC
 * @date 2025-10-04
 * @project zqc-codefather-aiplatform
 */
@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode("做个程序员zqc的工作记录小工具，输出不超过20行");
        Assertions.assertNotNull(result);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult multiFileCode = aiCodeGeneratorService.generateMultiFileCode("做个程序员zqc的留言板，输出不超过20行");
        Assertions.assertNotNull(multiFileCode);
    }
}
