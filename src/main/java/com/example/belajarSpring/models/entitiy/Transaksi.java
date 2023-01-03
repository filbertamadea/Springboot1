package com.example.belajarSpring.models.entitiy;

import jakarta.persistence.*;

@Entity
@Table(name = "Transaksis")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String peminjam;
    private String tglDipinjam;
    private String tglDibalikan;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_buku")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_action")
    private Action action;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public String getTglDipinjam() {
        return tglDipinjam;
    }

    public void setTglDipinjam(String tglDipinjam) {
        this.tglDipinjam = tglDipinjam;
    }

    public String getTglDibalikan() {
        return tglDibalikan;
    }

    public void setTglDibalikan(String tglDibalikan) {
        this.tglDibalikan = tglDibalikan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

}

