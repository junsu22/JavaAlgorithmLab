package ch03;

/**
 * Min-Heap을 구현한 클래스.
 * 힙 정렬을 수행하는 메서드를 포함합니다.
 */
public class HeapSort {

    private int SIZE;       // 현재 힙에 저장된 요소 개수
    private int[] heapArr;  // 힙 배열

    /**
     * 생성자: 초기 힙 크기를 설정.
     */
    public HeapSort() {
        SIZE = 0;
        heapArr = new int[50]; // 최대 50개의 요소 저장 가능
    }

    /**
     * 힙에 요소 삽입 (Min-Heap 기준).
     *
     * @param input 삽입할 값
     */
    public void insertHeap(int input) {
        int i = ++SIZE;

        // 부모 노드와 비교하며 위로 이동
        while ((i != 1) && (input < heapArr[i / 2])) { // Min-Heap 조건
            heapArr[i] = heapArr[i / 2];
            i = i / 2;
        }
        heapArr[i] = input; // 적절한 위치에 삽입
    }

    /**
     * 현재 힙 크기 반환.
     *
     * @return 힙에 저장된 요소 개수
     */
    public int getHeapSize() {
        return SIZE;
    }

    /**
     * 힙에서 최솟값 삭제 및 반환 (Min-Heap 기준).
     *
     * @return 삭제된 최솟값
     */
    public int deleteHeap() {
        int parent, child;
        int data, temp;

        data = heapArr[1];      // 루트 노드 값 저장
        temp = heapArr[SIZE];   // 마지막 노드 값 가져오기
        SIZE--;                 // 힙 크기 감소

        parent = 1;
        child = 2;

        // 힙 재구성
        while (child <= SIZE) {
            // 자식 노드 중 더 작은 값 선택
            if ((child < SIZE) && (heapArr[child] > heapArr[child + 1])) {
                child++;
            }

            // Min-Heap 조건을 만족하면 중단
            if (temp <= heapArr[child]) break;

            heapArr[parent] = heapArr[child]; // 자식 노드를 부모로 이동
            parent = child;
            child *= 2; // 왼쪽 자식으로 이동
        }

        heapArr[parent] = temp; // 적절한 위치에 값 삽입
        return data;            // 삭제된 최솟값 반환
    }

    /**
     * 힙의 현재 상태 출력.
     */
    public void printHeap() {
        System.out.printf("\n Min Heap: ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.printf("[%d] ", heapArr[i]);
        }
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort();

        // 힙에 값 삽입
        heap.insertHeap(80);
        heap.insertHeap(50);
        heap.insertHeap(70);
        heap.insertHeap(10);
        heap.insertHeap(60);
        heap.insertHeap(20);

        // 힙 출력
        heap.printHeap();

        // 힙에서 값 삭제 및 출력
        int n = heap.getHeapSize();
        for (int i = 1; i <= n; i++) {
            int data = heap.deleteHeap();
            System.out.printf("\n 삭제된 값: [%d]", data);
        }
    }
}
