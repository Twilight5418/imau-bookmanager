package org.example.imaubookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private int bookId;
    private String bookName;
    private String bookIsbn;
    private Double bookPrice;
    private String bookWriter;
}
