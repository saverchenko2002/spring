package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        System.out.println("Method main starts");
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);
        context.close();
        System.out.println("Method main ends");
    }
}
