package com.limouren.springsecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
@RestController
@RequestMapping("/resource")
public class ResouceController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String listTasks(){
        return "resource";
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public String newTasks(){
        return "创建了一个新的resource";
    }

    @PutMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId")Integer id){
        return "更新了一下id为:"+id+"的resource";
    }

    @DeleteMapping("/{taskId}")
    public String deleteTasks(@PathVariable("taskId")Integer id){
        return "删除了id为:"+id+"的resource";
    }

}
