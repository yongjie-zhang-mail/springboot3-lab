package com.yj.lab.admin.util;

import com.yj.lab.common.model.rdb.entity.pg.Product;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Yongjie
 */
@Slf4j
public class HtmlParserUtil {


    @SneakyThrows
    public static void main(String[] args) {

        HtmlParserUtil.parseJdProductList("pytorch").forEach(System.out::println);

    }

    @SneakyThrows
    public static List<Product> parseJdProductList(String keyword) {
        List<Product> products = new ArrayList<>();
        String url = "https://search.jd.com/Search?keyword=".concat(keyword);
//        url = URLEncoder.encode(url, StandardCharsets.UTF_8);
        Document document = Jsoup.parse(new URL(url), 10000);
        Element jGoodsList = document.getElementById("J_goodsList");
        if (jGoodsList != null) {
            Elements lis = jGoodsList.getElementsByTag("li");
            for (Element li : lis) {
//                log.info(li.html());
                String id = li.attr("data-sku");
                String name = li.getElementsByClass("p-name").eq(0).text();
                String price = li.getElementsByClass("p-price").eq(0).text();
                String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
//                String price = li.getElementsByClass("p-price").get(0).getElementsByTag("i").eq(0).text();
//                log.info("id={},img={},price={},name={}", id, img, price, name);
                Product product = new Product(id, name, price, img);
                products.add(product);
            }
        }
        return products;
    }


}
