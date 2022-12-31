package com.telegram.bot.bik.api.parser;

import com.telegram.bot.bik.config.properties.SiteProperties;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
@EqualsAndHashCode
public class ParserNameSpecialization {
    private final SiteProperties siteProperties;

    public Set<String> parseSpecialization() throws IOException {
        String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0";

        String urlSpecialization = siteProperties.getSchedule();
        Document document = Jsoup.connect(urlSpecialization)
                .userAgent(userAgent)
                .get();
        Elements elementsByClassShadow = document.getElementsByClass("modernsmall");
        Set<String> specialization = new HashSet<>();

        elementsByClassShadow.forEach(element -> {
            String name = element.text();
            String[] fullNameGroup = name.split(" ");
            specialization.add(fullNameGroup[1]);
        });

//        for (Element element : elementsByClassShadow) {
//            String name = element.text();
//            String[] fullNameGroup = name.split(" ");
//            specialization.add(fullNameGroup[1]);
//
//        }

        // TODO : алгоритм подойдет для конкретной группы, немного перепиисать и заебись
//        for (Element element : elementsByClassShadow) {
//            String href1 = element.attr("href"); // аттрибут href у тега a
//            String[] split = href1.split("=");
//            String text = element.text();
//            nameSpecializationNormal.put(split[1], text);
//        }


        return specialization;
    }

}
