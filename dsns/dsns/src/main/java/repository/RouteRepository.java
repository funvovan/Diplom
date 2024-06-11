package repository;
import models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findByStartPointAndEndPoint(String prev, String current);
}

