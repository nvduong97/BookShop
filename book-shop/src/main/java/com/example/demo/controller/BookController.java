package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.dto.ResponseResult;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.BookMapper;
import com.example.demo.model.request.CreateBookReq;
import com.example.demo.model.request.UpdateBookReq;
import com.example.demo.model.request.UpdateUserReq;
import com.example.demo.model.request.UploadFile;
import com.example.demo.service.BookService;
import com.example.demo.service.FileStorageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        BookDto bookDto = bookService.getBookById(id);
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping("")
    public ResponseEntity<?> createBook(@Valid @RequestBody CreateBookReq req){
        ResponseResult result = new ResponseResult();
        try {
            bookService.createBook(req);
            result.setSuccess(true);
            result.setMessage("Thêm sách thành công");
        } catch (Exception e) {
            e.getMessage();
            result.setSuccess(false);
            result.setMessage("Đã xảy ra lỗi");
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@Valid @RequestBody UpdateBookReq req, @PathVariable int id) {
        BookDto result = bookService.updateBook(req, id);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        String result;
        try {
            bookService.deleteBook(id);
            result = "Xóa thành công";
        }catch (Exception e){
            result = "Đã xảy ra lỗi";
        }
        return ResponseEntity.ok(result);
    }


//    @GetMapping("")
//    public String getBookByName(Model model,
//                                @RequestParam(required = false, defaultValue = "") String keyword,
//                                @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                                @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {
//        List<BookDto> result = new ArrayList<>();
//        Page<Book> books = bookService.getBooksByName(keyword.trim(), PageRequest.of(page, size));
//        for (Book book: books.getContent()) {
//            result.add(BookMapper.toBookDto(book));
//        }
//        model.addAttribute("page", books);
//        model.addAttribute("books", result);
//        return "products";
//    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        ResponseResult result = new ResponseResult();
        try {
            String newFilename = fileStorageService.store(file);
            result.setSuccess(true);
            result.setData("/books/file/" +
                    newFilename);
        } catch (Exception e) {
            e.getMessage();
            result.setSuccess(false);
            result.setMessage("Đã xảy ra lỗi");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileStorageService.loadFile(filename);
        MediaType type = MediaType.ALL;

        if(filename.toLowerCase().endsWith("png")) {
            type = MediaType.IMAGE_PNG;
        } else if (filename.toLowerCase().endsWith("jpg") || filename.toLowerCase().endsWith("jpeg")) {
            type = MediaType.IMAGE_JPEG;
        } else {
            type = MediaType.IMAGE_GIF;
        }

        return ResponseEntity.ok()
                .contentType(type)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
