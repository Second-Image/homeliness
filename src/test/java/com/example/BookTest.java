package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void testAdd(){
        Book book = new Book();
        book.setType("哲学");
        book.setName("逻辑学");
        book.setDescription("黑格尔逻辑学著作");
        bookDao.insert(book);
    }

    @Test
    public void testPage(){
        IPage page = new Page(2,3);
        bookDao.selectPage(page,null);
    }

    @Test
    public void testQuery(){
        String name = "学";
        //常规条件查询
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.like(name != null,"name","学");
//        bookDao.selectList(queryWrapper);
        //Lambda条件查询，要确定泛型类型
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        //condition类型为boolean，为true时执行条件，为false时不执行条件
        lqw.like(name != null,Book::getName,name);
        bookDao.selectList(lqw);
    }
}
