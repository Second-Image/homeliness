package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookDao;
import com.example.pojo.Book;
import com.example.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl01 extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize,Book queryBook) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        //非空条件
        lqw.like(Strings.isNotEmpty(queryBook.getType()),Book::getType,queryBook.getType());
        lqw.like(Strings.isNotEmpty(queryBook.getName()),Book::getName,queryBook.getName());
        lqw.like(Strings.isNotEmpty(queryBook.getDescription()),Book::getDescription,queryBook.getDescription());

        IPage<Book> page = new Page<>(currentPage,pageSize);
        return bookDao.selectPage(page,lqw);
    }
}
