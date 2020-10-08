package com.java.study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 10. 08
 */
public class OptionalApp {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

//        OnlineClass springBoot = new OnlineClass(6, "Spring Boot", true);
//        Duration studyDuration = springBoot.getProgress().getStudyDuration();
//        System.out.println(studyDuration);

        Optional<OnlineClass> optionalOnlineClass = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("rest"))
                .findFirst();

        boolean present = optionalOnlineClass.isPresent();
        System.out.println(present);

        boolean empty = optionalOnlineClass.isEmpty();  // java11부터 제공
        System.out.println(empty);

        if (optionalOnlineClass.isPresent()) {
            OnlineClass onlineClass = optionalOnlineClass.get();
            System.out.println(onlineClass.getTitle());
        }

        optionalOnlineClass.ifPresent(onlineClass -> System.out.println(onlineClass.getTitle()));

        OnlineClass onlineClass1 = optionalOnlineClass.orElse(createNewClass());
        System.out.println(onlineClass1.getTitle());

        OnlineClass onlineClass2 = optionalOnlineClass.orElseGet(OptionalApp::createNewClass);
        System.out.println(onlineClass2.getTitle());

        OnlineClass onlineClass3 = optionalOnlineClass.orElseThrow(IllegalArgumentException::new);
        System.out.println(onlineClass3.getTitle());

        Optional<OnlineClass> onlineClass4 = optionalOnlineClass.filter(onlineClass -> !onlineClass.isClosed());
        System.out.println(onlineClass4.isEmpty());

        Optional<Integer> integer = optionalOnlineClass.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Progress> progress = optionalOnlineClass.flatMap(OnlineClass::getProgress);
        Optional<Optional<Progress>> progress1 = optionalOnlineClass.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());
    }

    private static OnlineClass createNewClass() {
        System.out.println("create new class");
        return new OnlineClass(10, "New Class", false);
    }

}
