package com.telegram.bot.bik.service.callback;

import com.telegram.bot.bik.enums.CallbackNameEnum;
import com.telegram.bot.bik.service.HandleCallback;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.Collection;
import java.util.Set;

import static com.telegram.bot.bik.enums.CallbackNameEnum.SPECIALIZATION;

@Service
public class CallbackGeneratorGroupByName implements HandleCallback {
    private static final Set<CallbackNameEnum> CALLBACKS = Set.of(SPECIALIZATION);
    @Override
    public BotApiMethod<?> buildMessageByCallback(CallbackQuery callbackQuery) {
        return null;
    }

    @Override
    public Collection<CallbackNameEnum> getSupportedCallback() {
        return CALLBACKS;
    }
}
