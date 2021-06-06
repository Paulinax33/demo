package pl.deren.demo.Java;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Bee bee = new Bee();
        bee.getFly();
// nie rozumiem czemu podswietla "replies" przy wpisaniu replys bylo tak samo
//        Skype skype = new Skype();
//        for (Reply reply : replies){
//            reply.getCall();
//            reply.getMessage();
//        }
    }

    @PostConstruct
    public void test1() {
        Optional<String> optionalAnimals = Optional.ofNullable(extracted());
        optionalAnimals
                .map(Integer::valueOf)
                .filter(x -> x > 5)
                .filter(x -> x < 10)
                .flatMap(x -> modify(x))
                .ifPresent(x -> {
                    System.out.println(x);
                });
    }

    private String extracted() {
        return "5";
    }

    private Optional<Integer> modify(Integer i) {
        return Optional.ofNullable(i)
                .map(x -> x + 1);
    }

    @PostConstruct
    public void test2() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Not bad");
            }
        });
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("That is nice");
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
    }

    @PostConstruct
    public void executorCheckOut() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hi" + Thread.currentThread().getName());
            }
        });
        Future<Integer> submit = executorService.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(15);
                return 100;
            } catch (InterruptedException e) {
                return 0;
            }
        });
        while (!submit.isDone()) {
            try {
                TimeUnit.MILLISECONDS.sleep(30);
                System.out.println("Wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void test3() {
        MyFunction<String, String, String, Integer> myFunction = (String x, String y, String z) -> Integer.valueOf(x) + Integer.valueOf(y) + Integer.valueOf(z);
        Integer apply = myFunction.apply("5", "10", "15");
        System.out.println(apply);
    }

    @PostConstruct
    public void test4() {
        Map<String, String> animals = List.of(
                List.of("dog", "cat", "hamster"),
                List.of("spider", "scorpio", "snake")
        ).stream()
                .flatMap(animal -> animal.stream())
                .filter(animal -> animal.length() > 1)
                .collect(Collectors.toMap(animal -> animal, animal -> animal + "  scary"));

        System.out.println(animals);
    }
}
