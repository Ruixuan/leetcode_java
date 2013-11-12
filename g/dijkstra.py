def dijkstra(G, s):
    for v in G:
        dist[v] = infinite
    dist[s] = 0
    not_visited = set(G)
    pre = dict()
    for i = 0 to n - 1:
        min_d = infinite
        for v in not_visited:
            if dist[v] < min_d:
                u = v
                min_d = dist[v]
        not_visted.remove(s)
        for v in u.neigbor:
            if v in not_visted:
                alt = dist[u] + edge[u][v]
                if alt < dist[v]:
                    dist[v] = alt
    return dist

