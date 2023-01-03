package com.example.belajarSpring.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String judul;
    private String penulis;
    private String penerbit;
    private int stok;
    private String namaKategori;
}
