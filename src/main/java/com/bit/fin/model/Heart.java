//package com.bit.fin.model;
//
//import lombok.Getter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//
//public class Heart {
//    @Id @GeneratedValue
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    //@JoinColumn(name = "USER_ID")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    //@JoinColumn(name = "BOARD_ID")
//    private Board board;
//
//
//    public void addUser(User user) {
//        this.user = user;
//        user.getHearts().add(this);
//    }
//
//    public void deleteUser(User user) {
//        this.user = null;
//        user.getHearts().remove(this);
//    }
//
//    public void addBoard(Board board) {
//        this.board = board;
//        board.getHearts().add(this);
//    }
//
//    public void deleteBoard(Board board) {
//        this.board = null;
//        board.getHearts().remove(this);
//    }
//}
