package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.polls.model.EditText;

public interface TextEditorRepository extends JpaRepository<EditText,Long> {

}
