package com.wooseok.algorithm.programmers.level1;
import java.util.*;

/**
 * 네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 *
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 *
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
 *
 * 참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
 */
public class kakao_채용연계형_숫자문자열과영단어 {
//    public static int solution(String s) {
//        int answer = 0;
//        int i = 0;
//        do {
//            s = stringToInt(s);
//            i++;
//        } while (i != s.length());
//        answer = Integer.parseInt(s);
//        return answer;
//    }

    // 다른 사람 풀이
    public static int solution(String s) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            System.out.println("s = " + s);
            s = s.replaceAll(alphabets[i],digits[i]);
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args){
//        String s = "one4seveneight";            //1478
//        String s = "23four5six7";               //234567
        String s = "2three45sixseven";          //234567
//        String s = "123";                       //123
        solution(s);
    }

//    public static String stringToInt(String s){
//        if(s.contains("one")){
//            return s.replace("one", "1");
//        }
//        if(s.contains("two")){
//            return s.replace("two", "2");
//        }
//        if(s.contains("three")){
//            return s.replace("three", "3");
//        }
//        if(s.contains("four")){
//            return s.replace("four", "4");
//        }
//        if(s.contains("five")){
//            return s.replace("five", "5");
//        }
//        if(s.contains("six")){
//            return s.replace("six", "6");
//        }
//        if(s.contains("seven")){
//            return s.replace("seven", "7");
//        }
//        if(s.contains("eight")){
//            return s.replace("eight", "8");
//        }
//        if(s.contains("nine")){
//            return s.replace("nine", "9");
//        }
//        return s.replace("zero", "0");
//    }
}
