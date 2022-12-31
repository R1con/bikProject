package com.telegram.bot.bik.map;

import com.telegram.bot.bik.service.HandleCallback;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CallbackMap {
    private static final Map<String, HandleCallback> CALLBACK_MAP = new HashMap<>();

    public CallbackMap(List<HandleCallback> callbacks) {
        callbacks.forEach(c -> c.getSupportedCallback()
                .forEach(c1 -> CALLBACK_MAP.put(c1.name(), c)));
    }

    public HandleCallback getCallback(String keyCallback) {
        return CALLBACK_MAP.get(keyCallback);
    }

}
