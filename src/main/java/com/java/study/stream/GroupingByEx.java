package com.java.study.stream;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 25
 */
public class GroupingByEx {

    public static void main(String[] args) {
        City suwon = new City("경기도", "수원", 1000);
        City osan = new City("경기도", "오산", 500);
        City ilsan = new City("경기도", "일산", 1500);
        City busan = new City("경상남도", "부산", 5000);
        City pohang = new City("경상남도", "포항", 4000);

        List<City> cityList = new ArrayList<>();
        cityList.add(suwon);
        cityList.add(osan);
        cityList.add(ilsan);
        cityList.add(busan);
        cityList.add(pohang);

        Map<String, Long> stateCountMap = cityList.stream().collect(
                groupingBy(City::getState, counting())
        );
        System.out.println(stateCountMap.get("경기도"));

        Map<String, Integer> stateToCityPopulation = cityList.stream().collect(
                groupingBy(
                        City::getState,
                        summingInt(City::getPopulation)
                )
        );
        System.out.println(stateToCityPopulation.get("경기도"));

        Map<String, Optional<City>> stateToLargestCity = cityList.stream().collect(
                groupingBy(
                        City::getState,
                        maxBy(Comparator.comparing(City::getPopulation))
                )
        );

        stateToLargestCity.get("경기도")
                .ifPresentOrElse(
                        city -> System.out.println(city.getName()),
                        () -> System.out.println("없음")
                );

        stateToLargestCity.get("경상남도")
                .ifPresentOrElse(
                        city -> System.out.println(city.getName()),
                        () -> System.out.println("없음")
                );

        Map<String, Set<String>> stateToName = cityList.stream().collect(
                groupingBy(
                        City::getState,
                        mapping(City::getName, toSet())
                )
        );
        System.out.println(stateToName.get("경기도"));

        Map<String, IntSummaryStatistics> stateToCityPopulationSummary =
                cityList.stream().collect(
                        groupingBy(
                                City::getState,
                                summarizingInt(City::getPopulation))
                );
        System.out.println(stateToCityPopulationSummary.get("경기도"));
    }

}
