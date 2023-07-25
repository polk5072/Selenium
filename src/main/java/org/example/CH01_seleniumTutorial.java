package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // 엑셀 파일을 생성하고 조작하기 위해 사용되는 라이브러리
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;

public class CH01_seleniumTutorial {

    public static void main(String[] args) {

        CH01_seleniumTutorial test = new CH01_seleniumTutorial();
        test.run();

    }

    void run(){

        try {
            // 엑셀파일 조작을 위해 XSSFWorkbook 선언
            Workbook workbook = new XSSFWorkbook();
            FileOutputStream outputStream = new FileOutputStream("C:/Selenium_Java/Selenium/news_title.xlsx");

            // 네이버 뉴스 기사 제목 이라는 Sheet 생성
            Sheet sheet = workbook.createSheet("네이버 뉴스 기사 제목");
            int rowNum = 0;

            // 3페이지까지 크롤링하려면 page 변수를 1부터 3까지 반복하도록 설정

            for (int page = 1; page <= 3; page++) {

                //네이버 기사의 url을 저장한 후
                String url = "https://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105&page=" + page;

                // url을 Document 형식으로 변환하여 저장하는 코드
                Document doc = Jsoup.connect(url).get();

                // 반복문의 매개체로 사용하기 위해 newsHeadline의 CssQuery를 저장한다
                Elements newsHeadlines = doc.select(".cluster_text_headline");

                for (Element element : newsHeadlines) {

                    // 헤드라인 뉴스 기사 제목을 String형 title 변수에 저장한다.
                    String title = element.text();

                    // 위에서 만든 엑셀 파일에 행을 추가한다.
                    Row row = sheet.createRow(rowNum++);

                    // 생성한 행에 title -> 헤드라인 기사 제목을 저장한다.
                    row.createCell(0).setCellValue(title);

                    // 저장된 newsHeadlines 갯수만큼 이를 반복한다.
                }
            }

            workbook.write(outputStream);

            outputStream.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
