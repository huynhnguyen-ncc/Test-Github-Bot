package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Ví dụ nâng cao về Annotation.
 * - Sử dụng Annotation trên nhiều vị trí (Field, Method, Type).
 * - Xử lý Annotation tại thời điểm Runtime bằng Reflection.
 * - Demo Annotation kế thừa và lặp lại.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Repeatable(RuntimeAnnotations.class)
@interface AdvancedAnnotation {
    String description() default "Không có mô tả";
    int priority() default 1;
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@interface RuntimeAnnotations {
    AdvancedAnnotation[] value();
}

@AdvancedAnnotation(description = "Lớp xử lý nâng cao", priority = 10)
public class RuntimeAnnotationAdvanced {

    @AdvancedAnnotation(description = "Trường dữ liệu quan trọng")
    private String data;

    @AdvancedAnnotation(description = "Phương thức thực thi chính", priority = 5)
    public void execute() {
        System.out.println("Đang thực thi...");
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = RuntimeAnnotationAdvanced.class;

        // Xử lý Class annotation
        if (clazz.isAnnotationPresent(AdvancedAnnotation.class)) {
            AdvancedAnnotation ann = clazz.getAnnotation(AdvancedAnnotation.class);
            System.out.println("Lớp: " + clazz.getSimpleName() + " - " + ann.description());
        }

        // Xử lý Method annotation
        Method method = clazz.getMethod("execute");
        AdvancedAnnotation methodAnn = method.getAnnotation(AdvancedAnnotation.class);
        System.out.println("Phương thức: " + method.getName() + " - Priority: " + methodAnn.priority());

        // Xử lý Field annotation
        Field field = clazz.getDeclaredField("data");
        AdvancedAnnotation fieldAnn = field.getAnnotation(AdvancedAnnotation.class);
        System.out.println("Trường: " + field.getName() + " - Mô tả: " + fieldAnn.description());
    }
}
