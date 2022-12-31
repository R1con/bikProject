package com.telegram.bot.bik.service;

import com.telegram.bot.bik.enums.CallbackNameEnum;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.Collection;

public interface HandleCallback {
    BotApiMethod<?> buildMessageByCallback(CallbackQuery callbackQuery);

    default boolean isSupportFor(String type) {
        return getSupportedCallback().contains(CallbackNameEnum.valueOf(type));
    }

    Collection<CallbackNameEnum> getSupportedCallback();
}
