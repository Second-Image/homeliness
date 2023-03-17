package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.pojo.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层开发，增删改方法返回boolean类型，告知方法执行成功与否
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        //insert方法返回操作影响的行数，判断是否大于0来确定执行成功与否
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        //传值null，表示无条件查询
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int PageSize) {
        IPage<Book> page = new Page<>(currentPage,PageSize);
        return bookDao.selectPage(page,null);
    }
}
