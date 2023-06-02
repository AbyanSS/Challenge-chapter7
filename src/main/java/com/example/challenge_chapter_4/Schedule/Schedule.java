package com.example.challenge_chapter_4.Schedule;

import com.example.challenge_chapter_4.Service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class Schedule {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private static final String resetData = "13:59:20";

    private final TransactionService transactionService;

    @Autowired
    public Schedule(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
    public void runScheduledTask() throws ParseException {
        Time currentTime = new Time(System.currentTimeMillis());
        System.out.println(currentTime);

        try {
            Date reset = sdf.parse(resetData);
            Date current = sdf.parse(String.valueOf(currentTime));

            Date resetDate = new Date(reset.getTime());
            Date currentDate = new Date(current.getTime());

            int result = resetDate.compareTo(currentDate);
            if (result < 0) {
                System.out.println("resetDate is before currentDate");
                boolean isBefore = resetDate.before(currentDate);
                System.out.println("Is resetDate before currentDate? " + isBefore);
            } else if (result > 0) {
                System.out.println("resetDate is after currentDate");
                boolean isAfter = resetDate.after(currentDate);
                System.out.println("Is resetDate after currentDate? " + isAfter);
            } else {
                System.out.println("resetDate is equal to currentDate");
                boolean isEqual = resetDate.equals(currentDate);
                System.out.println("Is resetDate equal to currentDate? " + isEqual);
                transactionService.truncate();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}