package com.example.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //声明配置类
public class MPconfig {

    @Bean  //第三方Bean的配置方式
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //创建拦截器对象
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
