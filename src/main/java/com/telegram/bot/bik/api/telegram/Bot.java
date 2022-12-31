package com.telegram.bot.bik.api.telegram;

import com.telegram.bot.bik.api.telegram.commands.HandleCommand;
import com.telegram.bot.bik.config.properties.TelegramProperties;
import com.telegram.bot.bik.map.CallbackMap;
import com.telegram.bot.bik.map.CommandMap;
import com.telegram.bot.bik.service.HandleCallback;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private final TelegramProperties telegramProperties;
    private final CallbackMap callbackMap;
    private final CommandMap commandMap;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (update.hasCallbackQuery()) {
            HandleCallback callback = callbackMap.getCallback(update.getCallbackQuery().getData().split("/")[0]);
            execute(callback.buildMessageByCallback(update.getCallbackQuery()));
        }else if (update.hasMessage()) {
            if (message.getText().startsWith("/")) {
                HandleCommand command = commandMap.getCommand(message.getText().split("/")[1]);
                execute(command.buildMessageByCommand(message));
            }
        }
    }

    @Override
    public String getBotUsername() {
        return telegramProperties.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramProperties.getToken();
    }
}
