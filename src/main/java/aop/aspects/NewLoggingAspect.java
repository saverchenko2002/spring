package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String aop.UniLibrary.returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

//        long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();

        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
            targetMethodResult = "Неизвестное название книги";
//            throw e; RETHROW
        }
//        long end = System.currentTimeMillis();
//        targetMethodResult = "Преступление и наказание";
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
//        System.out.println("roundReturnBookLoggingAdvice:" +
//                " метод returnBook выполнил работу за " + (end-begin) + " миллисекунд");
        return targetMethodResult;
    }
}
