package com.example.userService.exception;

public class UserNotFoundExistException extends RuntimeException {

  public UserNotFoundExistException(String message)
  {
    super(message);
  }
}
