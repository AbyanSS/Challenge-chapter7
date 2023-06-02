package com.example.challenge_chapter_4.Controller;

import com.example.challenge_chapter_4.Model.TransactionEntity;
import com.example.challenge_chapter_4.Response.CommonResponse;
import com.example.challenge_chapter_4.Response.CommonResponseGenerator;
import com.example.challenge_chapter_4.Service.TransactionService;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Transaction")
public class TransactionController {

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public TransactionEntity addTransaction(@RequestBody TransactionEntity entity) {
        TransactionEntity transactionEntity = transactionService.addTransaction(entity);
        return transactionEntity;
    }

}
