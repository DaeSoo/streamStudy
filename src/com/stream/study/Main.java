package com.stream.study;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
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


    }
}
