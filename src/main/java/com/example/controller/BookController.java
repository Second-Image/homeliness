package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public Boolean insert(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);//通过ID更改
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.removeById(id);//通过ID删除
    }

    @GetMapping("{id}") //@PathVariable从路径中获取变量
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        //controller层不进行相关业务操作，通过调用业务层进行业务处理
////        IPage<Book> page = new Page<>(currentPage,pageSize);
////        return bookService.page(page);
//        return bookService.getPage(currentPage,pageSize);
//    }
}
