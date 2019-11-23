package com.br.codenation.application.controller;

import com.br.codenation.application.domain.entity.User;
import com.br.codenation.application.domain.vo.UserVO;
import com.br.codenation.application.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
@Api(value = "User Controller")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    @ApiOperation(value = "Method to create a new user in system.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list")
    })
    public ResponseEntity createUser(@ApiParam(value = "User") @RequestBody UserVO user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
}
