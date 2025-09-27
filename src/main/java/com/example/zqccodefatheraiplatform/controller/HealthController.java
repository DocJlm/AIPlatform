package com.example.zqccodefatheraiplatform.controller;

import com.example.zqccodefatheraiplatform.common.BaseResponse;
import com.example.zqccodefatheraiplatform.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZQC
 * @date 2025-09-27
 * @project zqc-codefather-aiplatform
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success( "ok");
    }
}


