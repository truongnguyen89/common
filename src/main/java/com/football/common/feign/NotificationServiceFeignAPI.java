package com.football.common.feign;

import com.football.common.constant.Constant;
import com.football.common.model.notification.NotificationQueue;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 21-Dec-18 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(Constant.FEIGN_CLIENT.SERVICE_NOTIFICATION)
public interface NotificationServiceFeignAPI {
    String URL_PATH_NOTIFICATION = "/notification/";

    @RequestMapping(path = URL_PATH_NOTIFICATION, method = POST)
    NotificationQueue create(
            @RequestParam(value = "title", required = true, defaultValue = "Tieu de thong bao") String title,
            @RequestParam(value = "content", required = true, defaultValue = "Noi dung thong bao") String content,
            @RequestParam(value = "type", required = true, defaultValue = "1") int type,
            @RequestParam(value = "userId", required = true, defaultValue = "1") long userId
    ) throws Exception;
}
