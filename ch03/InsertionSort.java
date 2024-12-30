package ch03;

/**
 * 삽입 정렬(Insertion Sort)을 구현한 클래스.
 */
public class InsertionSort {

    /**
     * 삽입 정렬 알고리즘.
     *
     * @param arr   정렬할 배열
     * @param count 배열의 크기
     */
    public static void insertionSort(int[] arr, int count) {
        int i, j, temp;

        // 정렬 시작
        for (i = 1; i < count; i++) {
            temp = arr[i]; // 현재 값 저장
            j = i;

            // 이전 값들과 비교하며 삽입 위치 찾기
            while ((j > 0) && arr[j - 1] > temp) {
                arr[j] = arr[j - 1]; // 오른쪽으로 이동
                j = j - 1;
            }
            arr[j] = temp; // 적절한 위치에 삽입

            // 중간 결과 출력
            System.out.println("반복 - " + i);
            printSort(arr, count);
        }
    }

    /**
     * 배열 내용을 출력.
     *
     * @param value 출력할 배열
     * @param count 배열의 크기
     */
    public static void printSort(int[] value, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(value[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 메인 메서드: 삽입 정렬 실행.
     */
    public static void main(String[] args) {
        // 정렬할 배열
        int[] arr = {80, 50, 70, 10, 60, 20, 40, 30};

        // 삽입 정렬 수행
        insertionSort(arr, arr.length);
    }
}
