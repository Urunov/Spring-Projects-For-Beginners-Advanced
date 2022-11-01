package uz.edu.biblatekaservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.biblatekaservice.model.Book;
import uz.edu.biblatekaservice.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService{
    //
    @Autowired
    private BookRepository repository;

    @Override
    public Book storeBook(Book book) {
        return repository.save(book);
    }
}
