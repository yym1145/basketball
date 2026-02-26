package server.service;

import com.basketball.result.Result;
import org.springframework.data.redis.core.script.ReactiveScriptExecutor;

public interface EventService {
    /**
     * 删除赛事
     * @param id
     */
    Result deleteEvent(Long id);
}
