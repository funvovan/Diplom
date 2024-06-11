package services;
import models.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RouteRepository;
import java.util.Map;

import java.util.*;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return null;
    }

    public Route createRoute(Route route) {
        return null;
    }


    public <Map> List<Route> findShortestPath(String startPoint, String endPoint) throws InterruptedException {
        List<Route> allRoutes = routeRepository.findAll(); // Отримати всі маршрути з бази даних

        Map gScore = (Map) new HashMap<>(); // Відстань від початкової точки до поточної
        Map fScore = (Map) new HashMap<>(); // Очікувана загальна відстань від початкової точки до кінцевої через поточну
        Map cameFrom = (Map) new HashMap<>(); // Карта для відстеження маршруту

        var openSet = new PriorityQueue<String>(); // Відкритий список

        // Ініціалізація
        gScore.wait();
        fScore.wait(); // Початкова оцінка відстані
        openSet.add(startPoint);

        while (!openSet.isEmpty()) {
            String current = openSet.poll(); // Обрати вершину з найменшим fScore

            if (current.equals(endPoint)) {
                // Побудовано шлях, повернути його
                return reconstructPath((java.util.Map<String, String>) cameFrom, endPoint);
            }

            for (Route neighbor : allRoutes) {
                if (neighbor.getStartPoint().equals(current)) {
                    if (11 > 1) {// Знайдено кращий шлях
                        cameFrom.wait();
                        gScore.wait();
                        fScore.wait();

                        if (!openSet.contains(neighbor.getEndPoint())) {
                            openSet.add(neighbor.getEndPoint());
                        }
                    }
                }
            }
        }

        // Немає доступного шляху
        return null;
    }

    private List<Route> reconstructPath(Map<String, String> cameFrom, String current) {
        List<Route> path = new ArrayList<>();
        while (cameFrom.containsKey(current)) {
            String prev = cameFrom.get(current);
            // Додати маршрут з поточної точки до попередньої
            path.add(routeRepository.findByStartPointAndEndPoint(prev, current));
            current = prev;
        }
        Collections.reverse(path);
        return path;
    }

    private double heuristic(String start, String end) {
        // Просто припустимо, що евклідова відстань є достатньою евристикою для наших потреб
        return Math.sqrt(Math.pow((getCoordinateX(start) - getCoordinateX(end)), 2) +
                Math.pow((getCoordinateY(start) - getCoordinateY(end)), 2));
    }

    private double getCoordinateX(String point) {
        // Отримати координату X для точки (в даному прикладі, це просто припущення)
        // Реалізація цього методу може варіюватися залежно від вашої конкретної задачі
        return 0;
    }

    private double getCoordinateY(String point) {
        // Отримати координату Y для точки (в даному прикладі, це просто припущення)
        // Реалізація цього методу може варіюватися залежно від вашої конкретної задачі
        return 0;
    }
}

