package distributedsystems.terrainService.services.repository;

import distributedsystems.terrainService.services.models.Terrain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TerrainRepository extends CrudRepository <Terrain, Long > {
    Optional<Terrain> findById(UUID id);
}
