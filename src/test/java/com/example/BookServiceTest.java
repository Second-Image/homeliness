package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pojo.Book;
import com.example.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void getPage(){
        IPage<Book> page = bookService.getPage(2,3);
    }
}
