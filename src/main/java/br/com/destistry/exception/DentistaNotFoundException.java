package br.com.dentistry.exception;

public class DentistaNotFoundException extends Exception {

  private static final long serialVersionUID = -7630009569979446777L;

  public DentistaNotFoundException() {
    super();
  }

  public DentistaNotFoundException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public DentistaNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public DentistaNotFoundException(String message) {
    super(message);
  }

  public DentistaNotFoundException(Throwable cause) {
    super(cause);
  }

}