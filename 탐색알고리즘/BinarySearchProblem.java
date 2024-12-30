package ch02;

public class BinarySearchProblem {

    public static void main(String[] args) {
        // 정렬된 배열
        int[] numbers = {12, 25, 31, 48, 54, 66, 70, 83, 95, 108};

        // 찾고자 하는 값
        int target = 83;

        // 탐색 범위를 설정
        int left = 0;
        int right = numbers.length - 1;

        // 중간 인덱스 선언
        int mid = -1;
        boolean find = false;

        // 이진 탐색 시작
        while (left <= right) {
            mid = (left + right) / 2; // 중간 인덱스 계산
            int temp = numbers[mid];  // 중간값 가져오기

            if (target == temp) {
                find = true; // 값 찾음
                break;
            } else if (target < temp) {
                right = mid - 1; // 왼쪽 반으로 탐색 범위 축소
            } else {
                left = mid + 1; // 오른쪽 반으로 탐색 범위 축소
            }
        }

        // 결과 출력
        if (find) {
            System.out.println("찾는 수는 " + (mid + 1) + "번째에 있습니다.");
        } else {
            System.out.println("찾는 수가 없습니다.");
        }
    }
}
