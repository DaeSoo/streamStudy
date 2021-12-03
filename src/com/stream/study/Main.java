package com.stream.study;

import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
    // https://wakestand.tistory.com/419
	// write your code here
        int [] arr = {1,1,10,30,2};
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        //Stream을 사용하지 않았을 경우
        for(int i =0; i<arr.length; i++){
            set.add(arr[i]);
        }

        Iterator<Integer> iter =  set.iterator();

        for(int i = 0; iter.hasNext(); i++){
            list.add(iter.next());
        }

        list.sort(Comparator.reverseOrder());

        System.out.println("Stream 사용하지 않을 경우 : "+list.toString());

        System.out.println("Stream을 이용한 출력 : "+
                Arrays.stream(arr).boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
        );

        // 숫자 배열 Stream 사용 시 여러 메소드를 쓰기 위한 boxed 처리
        System.out.println(Arrays.stream(arr).boxed());

        // count() 배열, 컬렉션 크기 확인
        System.out.println("count() 배열, 컬렉션 크기 확인");
        System.out.println(Arrays.stream(arr).count());
        System.out.println(list.stream().count());

        // sorted() 정렬
        System.out.println("sorted() 정렬");
        System.out.println(Arrays.stream(arr).boxed().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().sorted().collect(Collectors.toList()));

        // sorted(Comparator.reverseOrder()) 역정렬
        System.out.println("sorted(Comparator.reverseOrder()) 역정렬");
        System.out.println(Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        // findFirst() 처음 값
        System.out.println("findFirst() 처음 값");
        System.out.println(Arrays.stream(arr).findFirst().getAsInt());
        System.out.println(list.stream().findFirst().get());

        // skip(배열크기 - 1).findFirst() 마지막 값
        System.out.println("skip(배열크기 - 1).findFirst()");
        System.out.println(Arrays.stream(arr).skip(arr.length - 1).findFirst().getAsInt());
        System.out.println(list.stream().skip(list.size() - 1).findFirst().get());

        // skip(값) N개 생략하고
        System.out.println("skip(값) N개 생략하고");
        System.out.println(Arrays.stream(arr).boxed().skip(1).collect(Collectors.toList()));
        System.out.println(list.stream().skip(1).collect(Collectors.toList()));

        // limit(값) N개 까지
        System.out.println("limit(값) N개 까지");
        System.out.println(Arrays.stream(arr).boxed().limit(2).collect(Collectors.toList()));
        System.out.println(list.stream().limit(2).collect(Collectors.toList()));

        // distinct() 중복 생략
        System.out.println("distinct() 중복 생략");
        System.out.println(Arrays.stream(arr).boxed().distinct().collect(Collectors.toList()));
        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        // max(데이터타입::compare) 최대값
        System.out.println("max(데이터타입::compare) 최대값");
        System.out.println(Arrays.stream(arr).boxed().max(Integer::compare).get());
        System.out.println(list.stream().max(Integer::compare).get());

        // min(데이터타입::compare) 최소값
        System.out.println("min(데이터타입::compare) 최소값");
        System.out.println(Arrays.stream(arr).boxed().min(Integer::compare).get());
        System.out.println(list.stream().min(Integer::compare).get());

        // average() 평균
        System.out.println("average() 평균");
        System.out.println(Arrays.stream(arr).average().getAsDouble());
        System.out.println(list.stream().mapToDouble(Integer::doubleValue).average().getAsDouble());

        // sum() 합계
        System.out.println("sum() 합계");
        System.out.println(Arrays.stream(arr).sum());
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        // 람다(Lambda)를 이용한 가공
        // map(값을 원하는대로 가공)
        System.out.println("map 1이면 true 아니면 false 예제");
        System.out.println(Arrays.stream(arr).boxed().map(val -> val == 1).collect(Collectors.toList()));
        System.out.println(list.stream().map(val -> val == 1).collect(Collectors.toList()));

        // map 값마다 10 더하기 예제
        System.out.println("map 값마다 10 더하기 예제");
        System.out.println(Arrays.stream(arr).boxed().map(val -> val = val + 10).collect(Collectors.toList()));
        System.out.println(list.stream().map(val -> val = val + 10).collect(Collectors.toList()));

        // map 값 반올림 예제
        System.out.println("map 값 반올림 예제");
        System.out.println(Arrays.stream(arr).boxed().map(val -> Math.round(val*10)/10.0).collect(Collectors.toList()));
        System.out.println(list.stream().map(val -> Math.round(val*10)/10.0).collect(Collectors.toList()));

        // forEach(모든 값마다 입력한 내용 수행)
        System.out.println("forEach(모든 값마다 입력한 내용 수행)");
        Arrays.stream(arr).boxed().forEach(val -> System.out.println("ForEach 출력! : " + val));
        list.stream().forEach(val -> System.out.println("ForEach 출력! : " + val));

        // anyMatch(스트림에서 조건이 하나라도 맞으면)
        System.out.println("anyMatch(스트림에서 조건이 하나라도 맞으면) TRUE");
        System.out.println(Arrays.stream(arr).anyMatch(val -> val == 1));
        System.out.println(list.stream().anyMatch(val -> val == 1));

        // noneMatch(스트림에서 조건이 하나도 안맞으면)
        System.out.println("noneMatch(스트림에서 조건이 하나도 안맞으면) TRUE");
        System.out.println(Arrays.stream(arr).noneMatch(val -> val == 99));
        System.out.println(list.stream().noneMatch(val -> val == 99));

        // allMatch(스트림의 값이 모두 조건과 맞아야)
        System.out.println("allMatch(스트림의 값이 모두 조건과 맞아야) TRUE");
        System.out.println(Arrays.stream(arr).allMatch(val -> val == 1));
        System.out.println(list.stream().allMatch(val -> val == 1));

        // filter (특정 값만 허용)
        System.out.println("filter (특정 값만 허용)");
        System.out.println(Arrays.stream(arr).boxed().filter(val -> val == 10).collect(Collectors.toList()));
        System.out.println(list.stream().filter(val -> val == 10).collect(Collectors.toList()));

        // reduce (스트림 값을 모두 하나로 합치기)
        System.out.println("reduce (스트림 값을 모두 하나로 합치기) 다 합치고 5 더하기 예제");
        System.out.println(Arrays.stream(arr).reduce(5, Integer::sum));
        System.out.println(list.stream().reduce(5, Integer::sum));



        // 스트림 반환방법 예제
        int[] arr2 = {1,1,10,30,2};
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(10);
        list2.add(30);
        list2.add(2);

        System.out.println(Arrays.stream(arr2).boxed().distinct()); // 반환하기 전
        System.out.println(list2.stream().max(Integer::compare)); // 반환하기 전

        int[] arr3 = Arrays.stream(arr2).distinct().toArray(); // 배열로 반환
        List<Integer> list3 = Arrays.stream(arr2).boxed().distinct().collect(Collectors.toList()); // List로 반환
        int val2 = list2.stream().max(Integer::compare).get(); // 값 하나 반환
        long val3 = list2.stream().collect(Collectors.counting()); // 해당하는 갯수 반환

        String[] strArr = {"10", "20", "30"};

        // 컬렉션 내 모든 값을 |를 붙여서 반환
        // | 없이 붙여줄려면 ""로 변경
        System.out.println(Arrays.stream(strArr)
                .collect(Collectors.joining("|")));

        Double val4 = Arrays.stream(strArr) // Int 형태로 평균값 반환 (배열이 String일 경우)
                .collect(Collectors.averagingInt(val -> Integer.parseInt(val)));
        Double val5 = Arrays.stream(strArr) // Long 형태로 평균값 반환(배열이 String일 경우)
                .collect(Collectors.averagingDouble(val -> Double.parseDouble(val)));
        Double val6 = Arrays.stream(strArr) // Long 형태로 평균값 반환(배열이 String일 경우)
                .collect(Collectors.averagingLong(val -> Long.parseLong(val)));
        System.out.println("val4 : " + val4);
        System.out.println("val4 : " + val5);
        System.out.println("val4 : " + val6); // 값 확인

        String[] getGroupParti = {"zeebra", "cobra", "cobra", "dog"};

        // 이름, 갯수로 Group으로 묶어 담아줌
        Map<String, Long> map = Arrays.stream(getGroupParti)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("cobra : " + map.get("cobra"));

        // 조건에 맞으면 true, 아니면 false의 list 형태로 담아줌
        Map<Boolean, List<String>> map2 = Arrays.stream(getGroupParti)
                .collect(Collectors.partitioningBy(val -> val == "cobra"));

        System.out.println(map2.get(true));

//https://ahndding.tistory.com/23
//        //선언
//        // 컬렉션에서 스트림 생성
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        Stream<Integer> stream = list.stream();
//        stream.forEach(System.out::println); // forEach() 메소드를 이용한 스트림 요소의 순차 접근
//
//
//
//        // 배열에서 스트림 생성
//        String[] arr = new String[]{"넷", "둘", "셋", "하나"};
//        Stream<String> stream1 = Arrays.stream(arr);
//        stream1.forEach(e -> System.out.print(e + " "));
//        System.out.println();
//
//
//
//    // 배열의 특정 부분만을 이용한 스트림 생성
//        Stream<String> stream2 = Arrays.stream(arr, 1, 3);
//        stream2.forEach(e -> System.out.print(e + " "));
//
//
//
//    // 가변 매개변수에서 스트림 생성
//        Stream<Double> stream = Stream.of(4.2, 2.5, 3.1, 1.9);
//        stream.forEach(System.out::println);
//
//
//
//    // 지정된 범위의 연속된 정수에서 스트림 생성
//        IntStream stream1 = IntStream.range(1, 4);
//        stream1.forEach(e -> System.out.print(e + " "));
//        System.out.println();
//        IntStream stream2 = IntStream.rangeClosed(1, 4);
//        stream2.forEach(e -> System.out.print(e + " "));
//
//
//
//    // 특정 타입의 난수로 이루어진 스트림 생성
//        IntStream stream = new Random().ints(4);
//        stream.forEach(System.out::println);
//
//
//
//    // 람다 표현식
//        IntStream stream = Stream.iterate(2, n -> n + 2); // 2, 4, 6, 8, 10, ...
//
//
//
//    // 파일
//        String<String> stream = Files.lines(Path path); // 라인 단위로 접근
//
//
//
//    // 빈 스트림 생성
//        Stream<Object> stream = Stream.empty();
//        System.out.println(stream.count()); // 스트림의 요소의 총 개수를 출력함.

//// filter(), distinct()
//        IntStream stream1 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
//        IntStream stream2 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
//// stream에서 중복된 요소를 제거함.
//        stream1.distinct().forEach(e -> System.out.print(e + " "));	// 7 5 2 1 3 4 6
//        System.out.println();
//// stream에서 홀수만을 골라냄.
//        stream2.filter(n -> n % 2 != 0).forEach(e -> System.out.print(e + " "));	// 7 5 5 1 3 5
//        System.out.println();
//
//
//
//// map(), flatMap()
//        Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
//        stream.map(s -> s.toLowerCase()).forEach(System.out::println); //해당 스트림의 요소들을 주어진 함수에 인수로 전달하여, 그 반환값들로 이루어진 새로운 스트림을 반환
//        /*
//         * html
//         * css
//         * java
//         * javascript
//         */
//        String[] arr = {"I study hard", "You study JAVA", "I am hungry"};
//        Stream<String> stream = Arrays.stream(arr);
//        stream.flatMap(s -> Stream.of(s.split(" +"))).forEach(System.out::println); // 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변환
        /*
         * I
         * study
         * hard
         * You
         * study
         * JAVA
         * I
         * am
         * hungry
         */



//// limit(), skip()
//        IntStream stream1 = IntStream.range(0, 10);
//        IntStream stream2 = IntStream.range(0, 10);
//        IntStream stream3 = IntStream.range(0, 10);
//        stream1.skip(4).forEach(n -> System.out.print(n + " ")); // 스트림의 첫번째 요소부터 전달된 개수만큼 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림
//        System.out.println(); // 4 5 6 7 8 9
//        stream2.limit(5).forEach(n -> System.out.print(n + " ")); // 첫 번째 요소부터 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림
//        System.out.println(); // 0 1 2 3 4
//        stream3.skip(3).limit(5).forEach(n -> System.out.print(n + " ")); // 3 4 5 6 7
//
//
//
//// sorted()
//        Stream<String> stream1 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
//        Stream<String> stream2 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
//        stream1.sorted().forEach(s -> System.out.print(s + " ")); // 해당 스트림을 주어진 비교자(comparator)를 이용하여 정렬
//// CSS HTML JAVA JAVASCRIPT
//        System.out.println();
//        stream2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " ")); // 역순으로 정렬
// JAVASCRIPT JAVA HTML CSS


//// forEach()
//        Stream<String> stream = Stream.of("넷", "둘", "셋", "하나");
//        stream.forEach(System.out::println); // 각 요소를 출력
//        /*
//         * 넷
//         * 둘
//         * 셋
//         * 하나
//         */
//
//
//
//// reduce()
//        Stream<String> stream1 = Stream.of("넷", "둘", "셋", "하나");
//        Stream<String> stream2 = Stream.of("넷", "둘", "셋", "하나");
//        Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2);
//        result1.ifPresent(System.out::println); // 넷++둘++셋++하나
//        String result2 = stream2.reduce("시작", (s1, s2) -> s1 + "++" + s2);
//        System.out.println(result2); // 시작++넷++둘++셋++하나
//
//
//
//// findFirst(), findAny()
//        IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
//        IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
//        OptionalInt result1 = stream1.sorted().findFirst(); //stream의 모든 요소를 정렬한 후, 첫 번째에 위치한 요소를 출력
//        System.out.println(result1.getAsInt()); // 1
//        OptionalInt result2 = stream2.sorted().findAny(); // stream의 모든 요소를 정렬한 후, 첫 번째에 위치한 요소를 출력
//        System.out.println(result2.getAsInt()); // 1
//
//
//
//// anyMatch(), allMatch(), noneMatch()
//        IntStream stream1 = IntStream.of(30, 90, 70, 10);
//        IntStream stream2 = IntStream.of(30, 90, 70, 10);
//        System.out.println(stream1.anyMatch(n -> n > 80)); // 일부 요소에 대해 n > 80 인지 - true
//        System.out.println(stream2.allMatch(n -> n > 80)); // 모든 요소에 대해 n > 80 인지 - false
//
//
//
//// count(), min(), max()
//        IntStream stream1 = IntStream.of(30, 90, 70, 10);
//        IntStream stream2 = IntStream.of(30, 90, 70, 10);
//        System.out.println(stream1.count()); // 모든 요소의 갯수 - 4
//        System.out.println(stream2.max().getAsInt()); // 모든 요소의 최대값 - 90
//
//
//
//// sum(), average()
//        IntStream stream1 = IntStream.of(30, 90, 70, 10);
//        DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);
//        System.out.println(stream1.sum()); // 모든 요소의 총합 - 200
//        System.out.println(stream2.average().getAsDouble()); // 모든 요소의 평균 - 50.5
//
//
//
//// collect()
//        Stream<String> stream = Stream.of("넷", "둘", "하나", "셋");
//        List<String> list = stream.collect(Collectors.toList()); // 스트림을 리스트로 변환
//        Iterator<String> iter = list.iterator();
//        while(iter.hasNext()) {
//            System.out.print(iter.next() + " "); // 넷 둘 하나 셋
//        }
//
//// Collectors 클래스의 partitioningBy()
//        Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "PHP");
//        Map<Boolean, List<String>> patition = stream.collect(Collectors.partitioningBy(s -> (s.length() % 2) == 0));
//// 해당 stream의 각 요소별 글자 수에 따라 홀수와 짝수로 나누어 저장
//        List<String> oddLengthList = patition.get(false);
//        System.out.println(oddLengthList); // [CSS, PHP]
//        List<String> evenLengthList = patition.get(true);
//        System.out.println(evenLengthList); // [HTML, JAVA]
//

    }
}
