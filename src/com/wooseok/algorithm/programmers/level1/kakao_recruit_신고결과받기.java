package com.wooseok.algorithm.programmers.level1;

import java.util.*;

/**
 * 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.
 *
 * 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 **     신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 **     한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 * k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 **     유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 */
public class kakao_recruit_신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportTarget = new HashMap<>();    // 신고 당한 사람 (신고 중복 방지(<SET>))
        Map<String, Integer> reportOwner = new HashMap<>();         // 신고 한 사람

        for (String s : id_list) {
            reportTarget.put(s, new HashSet<>());               // 신고 당한 사람 세팅
            reportOwner.put(s, 0);                              // 신고 한 사람 카운트 세팅
        }
        for (String str : report) {
            String[] strings = str.split(" ");            // "무지 프로도" -> 구분
            reportTarget.get(strings[1]).add(strings[0]);       // 무지(strings[0])가 프로도(strings[1])를 신고 했다.
        }

        for (String key : id_list) {
            Set<String> reportList = reportTarget.get(key);     // 해당 key(유저 이름) 신고 한 사람 조회
            if (reportList.size() >= k) {
                for (String ownerKey : reportList) {
                    reportOwner.put(ownerKey, reportOwner.get(ownerKey) + 1);       // 메일 보내면 카운트 업 [ 메일 발송 조건 = k ]
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportOwner.get(id_list[i]);                            // 제출할 정답에 넣기
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = solution(id_list, report, 2);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
