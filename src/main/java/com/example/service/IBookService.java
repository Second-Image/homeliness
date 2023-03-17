package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pageSize,Book queryBook);
}
