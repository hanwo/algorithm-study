# DFS 구현 방법
### 반복 구현 ( Stack 활용)
- 반복구현에서는 스택 데이터 구조를 사용하여 방문할 정점을 추적한다.

1. 임의의 정점에서 시작하여 방문한 것으로 표시하고 스택에 푸시한다.
2. 스택에서 맨 위 정점을 가져온다.
3. 방문하지 않은 모든 인접 정점을 방문하여 방문한 것으로 표시하고 스택으로 푸시한다.
4. 스택이 비워질 때까지 프로세스를 반복한다.

```java
class DFS {
   static ArrayList<Integer>[] adj; // 인접 리스트
   static boolean[] visited; // 방문 배열

   public static void main(String[] args) {
      int n = 5; // 정점의 수
      adj = new ArrayList[n]; // 인접 리스트 초기화
      visited = new boolean[n]; // 방문 배열 초기화

      for (int i = 0; i < n; i++) {
         adj[i] = new ArrayList<>(); // 각 정점에 대한 인접 리스트 초기화
         visited[i] = false; // 모든 정점을 방문하지 않은 상태로 초기화
      }

      // 그래프의 간선 추가
      adj[0].add(1);
      adj[0].add(2);
      adj[1].add(2);
      adj[2].add(0);
      adj[2].add(3);
      adj[3].add(3);

      // 모든 정점에 대해 DFS 수행
      for (int i = 0; i < n; i++) {
         if (!visited[i]) { // 정점이 방문되지 않았다면
            dfs(i); // DFS 수행
         }
      }
   }

   public static void dfs(int v) {
      Stack<Integer> stack = new Stack<>(); // 스택 생성
      stack.push(v); // 시작 정점을 스택에 추가
      visited[v] = true; // 시작 정점을 방문했다고 표시

      while (!stack.isEmpty()) { // 스택이 비어있지 않은 동안 반복
         int vertex = stack.pop(); // 스택에서 정점을 하나 꺼냄
         System.out.print(vertex + " "); // 정점을 출력

         for (int neighbor : adj[vertex]) { // 현재 정점의 모든 인접 정점을 확인
            if (!visited[neighbor]) { // 인접 정점이 방문되지 않았다면
               stack.push(neighbor); // 스택에 추가
               visited[neighbor] = true; // 방문했다고 표시
            }
         }
      }
   }
}
```

```
그래프 구조:
0 -> 1
|    |
v    v
2 -> 3
^
|
3

DFS 동작 과정:
1. 시작 정점 0을 스택에 추가하고 방문 표시.
   스택: [0]
   방문: [true, false, false, false, false]

2. 스택에서 0을 꺼내고 인접 정점 1, 2를 스택에 추가.
   스택: [1, 2]
   방문: [true, true, true, false, false]

3. 스택에서 2를 꺼내고 인접 정점 0, 3을 확인. 0은 이미 방문, 3을 스택에 추가.
   스택: [1, 3]
   방문: [true, true, true, true, false]

4. 스택에서 3을 꺼내고 인접 정점 3을 확인. 이미 방문.
   스택: [1]
   방문: [true, true, true, true, false]

5. 스택에서 1을 꺼내고 인접 정점 2를 확인. 이미 방문.
   스택: []
   방문: [true, true, true, true, false]

6. 모든 정점 방문 완료.
```


### 재귀 구현
재귀 함수를 사용하여 그래프의 모든 정점을 방문한다.

이 함수는 현재 정점과 방문한 집합을 입력으로 사용하고 아직 방문하지 않은 모든 인접 정점에 DFS를 적용한다. 재귀는 모든 정점을 방문하는 사례에서 유용하다.

```java
class DFS {
   static ArrayList<Integer>[] adj; // 인접 리스트
   static boolean[] visited; // 방문 배열

   public static void main(String[] args) {
      int n = 5; // 정점의 수
      adj = new ArrayList[n]; // 인접 리스트 초기화
      visited = new boolean[n]; // 방문 배열 초기화

      for (int i = 0; i < n; i++) {
         adj[i] = new ArrayList<>(); // 각 정점에 대한 인접 리스트 초기화
         visited[i] = false; // 모든 정점을 방문하지 않은 상태로 초기화
      }

      // 그래프의 간선 추가
      adj[0].add(1);
      adj[0].add(2);
      adj[1].add(2);
      adj[2].add(0);
      adj[2].add(3);
      adj[3].add(3);

      // 모든 정점에 대해 DFS 수행
      for (int i = 0; i < n; i++) {
         if (!visited[i]) { // 정점이 방문되지 않았다면
            dfs(i); // DFS 수행
         }
      }
   }

   public static void dfs(int v) {
      visited[v] = true; // 현재 정점을 방문했다고 표시
      System.out.print(v + " "); // 현재 정점을 출력

      for (int neighbor : adj[v]) { // 현재 정점의 모든 인접 정점을 확인
         if (!visited[neighbor]) { // 인접 정점이 방문되지 않았다면
            dfs(neighbor); // 재귀적으로 DFS 호출
         }
      }
   }
}
```

```
그래프 구조:
0 -> 1
|    |
v    v
2 -> 3
^
|
3

DFS 동작 과정:
1. 시작 정점 0을 방문하고 출력.
   방문: [true, false, false, false, false]
   출력: 0

2. 정점 0의 인접 정점 1을 방문하고 출력.
   방문: [true, true, false, false, false]
   출력: 0 1

3. 정점 1의 인접 정점 2를 방문하고 출력.
   방문: [true, true, true, false, false]
   출력: 0 1 2

4. 정점 2의 인접 정점 0은 이미 방문됨.
   방문: [true, true, true, false, false]
   출력: 0 1 2

5. 정점 2의 인접 정점 3을 방문하고 출력.
   방문: [true, true, true, true, false]
   출력: 0 1 2 3

6. 정점 3의 인접 정점 3은 이미 방문됨.
   방문: [true, true, true, true, false]
   출력: 0 1 2 3

7. 모든 정점 방문 완료.
```

```java
class DFS {
   LinkedList<Integer>[] linkedList = new LinkedList[9]; // 인접 리스트
   boolean[] isVisited = new boolean[9]; // 방문 배열

   public static void main(String[] args) {
      LinkedList<Integer>[] linkedList = new LinkedList[9]; // 인접 리스트 초기화
      boolean[] isVisited = new boolean[9]; // 방문 배열 초기화

      for (int i = 0; i < 9; i++) {
         linkedList[i] = new LinkedList<>(); // 각 정점에 대한 인접 리스트 초기화
         isVisited[i] = false; // 모든 정점을 방문하지 않은 상태로 초기화
      }

      // 그래프의 간선 추가
      linkedList[1].add(2);
      linkedList[1].add(3);
      linkedList[1].add(8);
      linkedList[2].add(1);
      linkedList[2].add(7);
      linkedList[3].add(1);
      linkedList[3].add(4);
      linkedList[3].add(5);
      linkedList[4].add(3);
      linkedList[4].add(5);
      linkedList[5].add(3);
      linkedList[5].add(4);
      linkedList[6].add(7);
      linkedList[7].add(2);
      linkedList[7].add(6);
      linkedList[7].add(8);
      linkedList[8].add(1);
      linkedList[8].add(7);

      // 시작 정점 1에서 DFS 수행
      dfs(linkedList, isVisited, 1);
   }

   public static void dfs(LinkedList<Integer>[] linkedList, boolean[] isVisited, int currentNode) {
      if (!isVisited[currentNode]) { // 현재 정점이 방문되지 않았다면
         System.out.println("currentNode = " + currentNode); // 현재 정점을 출력
         isVisited[currentNode] = true; // 현재 정점을 방문했다고 표시
      }

      for (int i = 0; i < linkedList[currentNode].size(); i++) { // 현재 정점의 모든 인접 정점을 확인
         int nextNode = linkedList[currentNode].get(i); // 다음 정점을 가져옴
         if (!isVisited[nextNode]) { // 다음 정점이 방문되지 않았다면
            dfs(linkedList, isVisited, nextNode); // 재귀적으로 DFS 호출
         }
      }
   }
}
```

```
그래프 구조:
1 -> 2
|    |
v    v
3 -> 8
|    |
v    v
4 -> 5
^
|
7 -> 6
```


# 인접 행렬을 이용한 방법
```java
class DFS {
   static int[][] adjMatrix; // 인접 행렬
   static boolean[] visited; // 방문 배열

   public static void main(String[] args) {
      int n = 5; // 정점의 수
      adjMatrix = new int[n][n]; // 인접 행렬 초기화
      visited = new boolean[n]; // 방문 배열 초기화

      // 그래프의 간선 추가
      adjMatrix[0][1] = 1;
      adjMatrix[0][2] = 1;
      adjMatrix[1][0] = 1;
      adjMatrix[1][2] = 1;
      adjMatrix[2][0] = 1;
      adjMatrix[2][1] = 1;
      adjMatrix[2][3] = 1;
      adjMatrix[3][2] = 1;
      adjMatrix[3][3] = 1;

      // 모든 정점에 대해 DFS 수행
      for (int i = 0; i < n; i++) {
         if (!visited[i]) { // 정점이 방문되지 않았다면
            dfs(i); // DFS 수행
         }
      }
   }

   public static void dfs(int v) {
      visited[v] = true; // 현재 정점을 방문했다고 표시
      System.out.print(v + " "); // 현재 정점을 출력

      for (int i = 0; i < adjMatrix[v].length; i++) { // 현재 정점의 모든 인접 정점을 확인
         if (adjMatrix[v][i] == 1 && !visited[i]) { // 인접 정점이 방문되지 않았다면
            dfs(i); // 재귀적으로 DFS 호출
         }
      }
   }
}
```

```
그래프 구조:
0 -> 1
|    |
v    v
2 -> 3
^
|
3

인접 행렬:
  0 1 2 3 4
0 0 1 1 0 0
1 1 0 1 0 0
2 1 1 0 1 0
3 0 0 1 1 0
4 0 0 0 0 0

DFS 동작 과정:
1. 시작 정점 0을 방문하고 출력.
   방문: [true, false, false, false, false]
   출력: 0

2. 정점 0의 인접 정점 1을 방문하고 출력.
   방문: [true, true, false, false, false]
   출력: 0 1

3. 정점 1의 인접 정점 2를 방문하고 출력.
   방문: [true, true, true, false, false]
   출력: 0 1 2

4. 정점 2의 인접 정점 0은 이미 방문됨.
   방문: [true, true, true, false, false]
   출력: 0 1 2

5. 정점 2의 인접 정점 3을 방문하고 출력.
   방문: [true, true, true, true, false]
   출력: 0 1 2 3

6. 정점 3의 인접 정점 3은 이미 방문됨.
   방문: [true, true, true, true, false]
   출력: 0 1 2 3

7. 모든 정점 방문 완료.
```










---
# Chat-GPT
```java
import java.util.*;

class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // 무방향 그래프인 경우
    }

    public List<Integer> getAdjVertices(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }
}

class DFS {
    private final Graph graph;
    private final Set<Integer> visited;

    public DFS(Graph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
    }

    public void performDFS(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");

                for (int neighbor : graph.getAdjVertices(vertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void reset() {
        visited.clear();
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        DFS dfs = new DFS(graph);
        System.out.println("DFS starting from vertex 1:");
        dfs.performDFS(1);
    }
}
```

### 설명:
1. **Graph 클래스**:
    - `adjacencyList`: 각 정점과 그 정점에 연결된 인접 정점들을 저장하는 해시맵.
    - `addVertex(int vertex)`: 그래프에 정점을 추가.
    - `addEdge(int source, int destination)`: 그래프에 간선을 추가. 무방향 그래프를 가정하여 양쪽에 간선을 추가.
    - `getAdjVertices(int vertex)`: 특정 정점의 인접 정점 리스트를 반환.
    - `getVertices()`: 그래프의 모든 정점을 반환.

2. **DFS 클래스**:
    - `graph`: 탐색할 그래프.
    - `visited`: 방문한 정점을 저장하는 집합.
    - `performDFS(int startVertex)`: 주어진 시작 정점에서 DFS를 수행.
    - `reset()`: 방문한 정점 집합을 초기화.

3. **Main 클래스**:
    - 그래프를 생성하고 정점과 간선을 추가.
    - DFS 객체를 생성하고 DFS를 수행.

이 구현은 객체지향적 설계를 따르며, 그래프와 DFS 알고리즘을 분리하여 코드의 가독성과 유지보수성을 높였습니다.