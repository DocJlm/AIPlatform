package com.example.zqccodefatheraiplatform.service;

import com.example.zqccodefatheraiplatform.model.dto.app.AppQueryRequest;
import com.example.zqccodefatheraiplatform.model.entity.User;
import com.example.zqccodefatheraiplatform.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.example.zqccodefatheraiplatform.model.entity.App;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/DocJlm/DocJlm">DocJlm</a>
 */
public interface AppService extends IService<App> {

    AppVO getAppVO(App app);

    String deployApp(Long appId, User loginUser);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);
}
