package com.lms.order.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "book-service")
public interface BookServiceClient {

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
    BookDTO getBookById(@PathVariable("bookId") Long bookId);

}
