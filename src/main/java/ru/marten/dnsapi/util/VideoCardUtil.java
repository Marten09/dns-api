package ru.marten.dnsapi.util;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ru.marten.dnsapi.model.VideoCard;
import ru.marten.dnsapi.parser.Parser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VideoCardUtil {
    private final Parser parser;

    public List<VideoCard> convertFromHtmlToList() {
        Elements elements = parser.getAllElementsFromHtmlPage();
        List<VideoCard> list = new ArrayList<>();
        for (Element element : elements) {
            int price = Integer.parseInt(element.attr("data-meta-price"));
            VideoCard videoCard = new VideoCard();
            videoCard.setPrice(price);
            videoCard.setDate(LocalDate.now());
            list.add(videoCard);
        }
        return list;
    }

    public double getAveragePrice() {
        Elements elements = parser.getAllElementsFromHtmlPage();
        return elements.stream()
                .mapToInt(element -> Integer.parseInt(element.attr("data-meta-price")))
                .sorted()
                .limit(3)
                .average().orElseThrow();
    }
}
