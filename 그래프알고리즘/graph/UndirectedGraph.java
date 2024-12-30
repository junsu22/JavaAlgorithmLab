package ch04.graph;

/**
 * 무방향 그래프를 인접 행렬로 구현한 클래스.
 */
public class UndirectedGraph {

    private int count; // 노드의 개수
    private int[][] vertexMatrix; // 그래프를 인접 행렬로 표현한 2차원 배열

    /**
     * 생성자: 그래프 초기화
     * 
     * @param count 그래프의 노드 개수
     */
    public UndirectedGraph(int count) {
        this.count = count;
        this.vertexMatrix = new int[count][count]; // 노드 개수에 따른 2차원 배열 초기화
    }

    /**
     * 간선 추가 메서드
     * 
     * @param from   간선의 시작 노드
     * @param to     간선의 끝 노드
     * @param weight 간선의 가중치
     */
    public void addEdges(int from, int to, int weight) {
        vertexMatrix[from][to] = weight; // 시작 노드에서 끝 노드로의 가중치 설정
        vertexMatrix[to][from] = weight; // 무방향 그래프이므로 반대 방향도 동일하게 설정
    }

    /**
     * 인접 행렬 반환 메서드
     * 
     * @return 그래프의 인접 행렬
     */
    public int[][] getMatrix() {
        return vertexMatrix; // 그래프의 현재 상태(인접 행렬)를 반환
    }
}
