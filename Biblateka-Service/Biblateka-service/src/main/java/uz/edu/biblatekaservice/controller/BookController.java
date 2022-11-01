package uz.edu.biblatekaservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.edu.biblatekaservice.model.Book;
import uz.edu.biblatekaservice.service.BookService;

import javax.validation.Valid;

@RestController
public class BookController {
    //
    private BookService bookService;

       @PostMapping("/books")
    public Book  newBook(@Valid @RequestBody  Book newBook){
            return  bookService.storeBook(newBook);
    }
}
