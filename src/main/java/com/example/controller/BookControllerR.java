package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.pojo.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookControllerR {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R insert(@RequestBody Book book){
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));//通过ID更改
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));//通过ID删除
    }

    @GetMapping("{id}") //@PathVariable从路径中获取变量
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
        //controller层不进行相关业务操作，通过调用业务层进行业务处理
//        IPage<Book> page = new Page<>(currentPage,pageSize);
//        return bookService.page(page);

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //当最后一页只有一个数据时，若删除数据，当前页码值大于总页码值，当重新执行查询操作时，应把当前页面改为总页码值、或者跳到第一页
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize,book);
            //page = bookService.getPage(1,pageSize);
        }
        return new R(page != null,page);
    }
}
