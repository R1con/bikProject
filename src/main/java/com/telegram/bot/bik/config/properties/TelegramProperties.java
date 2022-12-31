package com.telegram.bot.bik.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "telegram")
public class TelegramProperties {
    String botName;
    String token;
}


