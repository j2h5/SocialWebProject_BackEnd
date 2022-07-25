//package com.bit.fin.repository;
//
//
//import com.bit.fin.model.Class;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface ClassRepository extends JpaRepository<Class, Long> {
//    List<Class> findAllByOrderByModifiedAtDesc();
//
//    List<Class> findByTitleContainingOrContentContainingOrderByModifiedAtDesc(String title, String title1);
//}
