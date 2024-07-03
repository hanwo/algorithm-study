package com.wooseok.algorithm.programmers.algorithm.graph.BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
	static class Edge {
		int start;
		int destination;
		int cost;

		Edge(int start, int destination, int cost) {
			this.start = start;
			this.destination = destination;
			this.cost = cost;
		}
	}

	private final ArrayList<Edge> graph;
	private final int nodes;
	private final int edges;

	public BellmanFord(int nodes, int edges) {
		this.nodes = nodes;
		this.edges = edges;
		this.graph = new ArrayList<>();
	}

	public void addEdge(int start, int destination, int cost) {
		graph.add(new Edge(start, destination, cost));
	}

	public boolean findShortestPaths(int start) {
		int[] dist = new int[nodes + 1]; // 최단 거리(가중치) 를 저장할 배열
		Arrays.fill(dist, Integer.MAX_VALUE); // 모든 원소 무한대로 초기화
		dist[start] = 0;

		// 정점 개수 만큼 반복
		for (int i = 1; i <= nodes; i++) {
			System.out.println("##### " + (i + 1) + "번째 " + "(i = " + (i + 1) + ")" + " #####");
			// 모든 간선 확인
			for (Edge edge : graph) {

				if (dist[edge.start] == Integer.MAX_VALUE) {
					continue;
				}
				// 현재 간선의 출발 정점이 무한대가 아니고, 도착 정점의 거리가 출발 정점의 거리 + 간선의 가중치보다 크다면
				if (dist[edge.destination] > dist[edge.start] + edge.cost) {
					System.out.printf("거리갱신: min(%d, %d + %d) = %d\n",
						dist[edge.destination], dist[edge.start], edge.cost, dist[edge.start] + edge.cost);
					// 도착 정점의 거리를 갱신
					dist[edge.destination] = dist[edge.start] + edge.cost;

					// 음수 가중치 사이클을 확인
					if (i == nodes) {
						System.out.println("비상~ 비상~! 음수 가중치 사이클이에요~!~!");
						return false;
					}
				} else {
					System.out.printf("거리 갱신 X: min(%d, %d + %d) = %d (no change)\n",
						dist[edge.destination], dist[edge.start], edge.cost, dist[edge.start] + edge.cost);
				}
				System.out.print("거리: ");
				printDistances(dist);
			}
		}

		System.out.println("\n최단 거리:");
		printDistances(dist);
		return true;
	}

	private void printDistances(int[] dist) {
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.print("INF ");
			} else {
				System.out.print(dist[i] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// int nodes = 3; // 정점의 개수
		// int edges = 4; // 간선의 개수
		int nodes = 5; // 정점의 개수
		int edges = 10; // 간선의 개수

		BellmanFord bellmanFord = new BellmanFord(nodes, edges);
		// bellmanFord.addEdge(1, 2, 4);
		// bellmanFord.addEdge(1, 3, 3);
		// bellmanFord.addEdge(2, 3, -4);
		// bellmanFord.addEdge(3, 1, -2);

		bellmanFord.addEdge(1, 2, 6);
		bellmanFord.addEdge(1, 3, 7);
		bellmanFord.addEdge(2, 3, 8);
		bellmanFord.addEdge(2, 4, 5);
		bellmanFord.addEdge(2, 5, -4);
		bellmanFord.addEdge(3, 4, -3);
		bellmanFord.addEdge(3, 5, 9);
		bellmanFord.addEdge(4, 2, -2);
		bellmanFord.addEdge(5, 1, 2);
		bellmanFord.addEdge(5, 4, 7);

		if (bellmanFord.findShortestPaths(1)) {
			System.out.println("Shortest paths found successfully.");
		} else {
			System.out.println("Negative-weight cycle detected.");
		}
	}
}
