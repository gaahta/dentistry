package br.com.dentistry.exception;

public class DentistaResourceException extends Exception {

  private static final long serialVersionUID = -6681777147239341684L;

  public DentistaResourceException() {
    super();
  }

  public DentistaResourceException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public DentistaResourceException(String message, Throwable cause) {
    super(message, cause);
  }

  public DentistaResourceException(String message) {
    super(message);
  }

  public DentistaResourceException(Throwable cause) {
    super(cause);
  }

}
