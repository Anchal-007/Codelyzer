package com.eduthrill.codelyser.Exception;

public class ResultException extends RuntimeException{

        private static final long serialVersionUID = 1L;

        public ResultException(String message){
            super(message);
        }

        public ResultException(String message, Throwable throwable){
            super(message, throwable);
        }
}

