package algorithm.jindian;

import java.util.*;

public class 面试题0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(start < 0 || target >= n){
            return false;
        }

        // 首先获得邻接矩阵
        List<Integer>[] map = new LinkedList[n];
        for(int i = 0; i< graph.length; i++){
            int from = graph[i][0];
            int to = graph[i][1];
            if(map[from] == null){
                map[from] = new LinkedList<>();
            }
            map[from].add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            // 访问队列中的节点
            for(int i= 0; i< size; i++){
                int from = queue.poll();
                // 首先找到该节点后面的顶点列表
                List<Integer> list = map[from];
                // 如果该节点出度为0，则循环后面的
                if(list == null){
                    continue;
                }
                // 遍历列表
                for(Integer end : list){
                    int e = end;
                    // 如果列表中的节点有等于target的直接返回
                    if(e == target){
                        return true;
                    }
                    //  如果是之前访问过的节点，继续下一个节点
                    if(visited[e]){
                        continue;
                    }
                    // 设置当前节点为访问过的
                    visited[e] = true;
                    queue.offer(e);
                }
            }
        }
        return false;
    }
}
