package dev.kit2512.oop_sms.domain.usecases;

public interface BaseUseCase<T extends Object> {
     T execute() throws Exception;
}
