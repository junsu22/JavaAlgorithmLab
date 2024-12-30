package ch01;

/**
 * 배열에서 최솟값과 최댓값을 찾고 그 위치를 출력하는 프로그램.
 */
public class MinMaxProblem {

    public static void main(String[] args) {
        // 배열 초기화
        int[] numbers = {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};

        // 최솟값과 최댓값, 위치 초기화
        int min = numbers[0]; // 최솟값
        int max = numbers[0]; // 최댓값
        int minPos = 0;       // 최솟값의 위치
        int maxPos = 0;       // 최댓값의 위치

        // 배열을 순회하며 최솟값과 최댓값 찾기
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];   // 새로운 최솟값 갱신
                minPos = i + 1;     // 위치는 1부터 시작하므로 +1
            }
            if (numbers[i] > max) {
                max = numbers[i];   // 새로운 최댓값 갱신
                maxPos = i + 1;     // 위치는 1부터 시작하므로 +1
            }
        }

        // 결과 출력
        System.out.println("가장 큰 값은 " + max + "이고, 위치는 " + maxPos + "번째 입니다.");
        System.out.println("가장 작은 값은 " + min + "이고, 위치는 " + minPos + "번째 입니다.");
    }
}
