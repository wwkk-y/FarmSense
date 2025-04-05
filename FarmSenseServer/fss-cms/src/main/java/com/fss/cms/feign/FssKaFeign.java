package com.fss.cms.feign;

import com.fss.common.api.RResult;
import com.fss.common.vo.KaMsgSendVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "fss-keep-alive") // name 服务名
public interface FssKaFeign {
    @PostMapping("/public/msg/send")
    RResult<Boolean> send(KaMsgSendVo msgSendVo);
}
