package ch04.bfs;

import java.util.ArrayList;
import ch04.graph.UndirectedGraph;

/**
 * 너비 우선 탐색(BFS) 구현 클래스.
 * BFS는 큐(Queue)를 활용하여 그래프를 탐색
 */
public class BfsSearch {

    private int count; // 노드의 개수
    private boolean[] visited; // 방문 여부를 확인하는 배열
    private ArrayList<Integer> queue; // 큐 자료구조를 ArrayList로 구현
    private int[][] matrix; // 그래프를 인접 행렬로 표현

    /**
     * BfsSearch 생성자
     * 
     * @param count 그래프의 노드 개수
     */
    public BfsSearch(int count) {
        this.count = count;
        this.visited = new boolean[count];
        this.queue = new ArrayList<>();
    }

    /**
     * 너비 우선 탐색(BFS)을 수행하는 메서드.
     * 시작 노드는 0번으로 설정.
     */
    public void bfsTraversal() {
        queue.add(0); // 시작 노드를 큐에 추가
        visited[0] = true; // 시작 노드를 방문 처리

        while (!queue.isEmpty()) { // 큐가 비어있지 않은 동안 반복
            int node = queue.remove(0); // 큐의 첫 번째 노드를 꺼냄
            System.out.print(node + " "); // 방문한 노드 출력

            for (int j = 0; j < count; j++) {
                // 인접 노드 중 방문하지 않은 노드를 큐에 추가
                if (matrix[node][j] != 0 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true; // 해당 노드 방문 처리
                }
            }
        }
    }

    /**
     * 메인 메서드: 그래프 생성 및 BFS 실행.
     */
    public static void main(String[] args) {
        int count = 8; // 그래프의 노드 개수
        UndirectedGraph graph = new UndirectedGraph(count);
        BfsSearch bfsSearch = new BfsSearch(count);

        // 그래프의 간선 추가
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(4, 5, 1);
        graph.addEdges(3, 7, 1);

        // BFS 실행
        bfsSearch.matrix = graph.getMatrix(); // 인접 행렬을 가져옴
        bfsSearch.bfsTraversal();
    }
}