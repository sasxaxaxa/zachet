package ex24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Класс для хранения ребра Graph
class Edge
{
    int src, dest;

    Edge(int src, int dest)
    {
        this.src = src;
        this.dest = dest;
    }
}

// Класс для представления graphического объекта
class Graph
{
    // Список списков для представления списка смежности
    List<List<Integer>> adjList = new ArrayList<>();

    // Конструктор для построения Graphа
    public Graph(List<Edge> edges)
    {
        // найти вершину с максимальным номером
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        // выделяем память для списка смежности
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // добавляем ребра в ориентированный graph
        for (Edge current: edges)
        {
            // выделяем новый узел в списке смежности от src до dest
            adjList.get(current.src).add(current.dest);

            // раскомментировать строку ниже для неориентированного Graph

            // выделяем новый узел в списке смежности от места назначения до источника
            // adjList.get(current.dest).add(current.src);
        }
    }

    // Функция для печати представления списка смежности Graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n)
        {
            // вывести текущую вершину и все соседние с ней вершины
            for (int dest: graph.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }
}

class Main
{
    public static void main (String[] args)
    {
        // Вход: список ребер в орграфе (согласно приведенной выше диаграмме)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));

        // построить graph из заданного списка ребер
        Graph graph = new Graph(edges);

        // вывести представление списка смежности Graph
        Graph.printGraph(graph);
    }
}